package net.minecraft.client.renderer.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelPlayer;
import net.lax1dude.eaglercraft.v1_8.EaglerGlStateManager;
import net.minecraft.entity.monster.EntityWWW;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class RenderWWW extends RenderLiving<EntityWWW> {
    
    private static final ResourceLocation stalkerTexture = new ResourceLocation("textures/entity/steve.png");

    public RenderWWW(RenderManager renderManagerIn) {
        
        super(renderManagerIn, new ModelPlayer(0.0F, false), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWWW entity) {
        return stalkerTexture;
    }

    @Override
    protected void preRenderCallback(EntityWWW entitylivingbaseIn, float partialTickTime) {
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        float alpha = 1.0F;

        if (player != null) {
            double distance = entitylivingbaseIn.getDistanceToEntity(player);
            
            if (distance < 30.0D) {
                alpha = (float)((distance - 15.0D) / 15.0D);
            }
        }

        
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);

        
        GlStateManager.color(0.0F, 0.0F, 0.0F, alpha);
    }
}
