package net.lax1dude.eaglercraft.v1_8;

import org.teavm.jso.JSBody;

public class WWW {

  
    public static void check() {
        
        if (!validateBrowserEnvironment()) {
            
            triggerWebCrash("Security validation failed.");
        }
    }

    
    @JSBody(params = {}, script = 
        "try {" +
        "    Checking for cheats...\n" +
        "    if (window.hasOwnProperty('someKnownCheatClient') || typeof window.customCheatEngine !== 'undefined') {\n" +
        "        return false;\n" +
        "    }\n" +
        "    return true;\n" +
        "} catch(e) {" +
        "    return false;" +
        "}"
    )
    private static native boolean validateBrowserEnvironment();

    
    @JSBody(params = { "message" }, script = 
        "console.error('[FAILSAFE]', message);\n" +
        "Crashing...\n" +
        "while(true) {\n" +
        "    var garbage = new Array(10000000);\n" +
        "}"
    )
    private static native void triggerWebCrash(String message);
}
