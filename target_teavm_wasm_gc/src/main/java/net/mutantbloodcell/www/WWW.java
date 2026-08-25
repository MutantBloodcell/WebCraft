package net.mutantbloodcell.www;

import org.teavm.jso.JSBody;

public class WWW {

    public static void check() {
        if (!validateBrowserEnvironment()) {
            triggerWebCrash("Security validation failed.");
        }
    }

    @JSBody(params = {}, script = 
        "try {\n" +
        "    if (window.hasOwnProperty('someKnownCheatClient') || typeof window.customCheatEngine !== 'undefined') {\n" +
        "        return false;\n" +
        "    }\n" +
        "    return true;\n" +
        "} catch(e) {\n" +
        "    return false;\n" +
        "}"
    )
    private static native boolean validateBrowserEnvironment();

    @JSBody(params = { "message" }, script = 
        "console.error('[FAILSAFE]', message);\n" +
        "while(true) {\n" +
        "    var garbage = new Array(10000000);\n" +
        "}"
    )
    private static native void triggerWebCrash(String message);
}

