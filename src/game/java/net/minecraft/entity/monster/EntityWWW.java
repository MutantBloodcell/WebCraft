package net.minecraft.entity.monster;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityStalker extends EntityLiving {

    public EntityStalker(World worldIn) {
        super(worldIn);
        
        this.setSize(0.6F, 1.8F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        
        EntityPlayer player = this.worldObj.getClosestPlayerToEntity(this, 64.0D);

        if (player != null) {
            
            this.getLookHelper().setLookPositionWithEntity(player, 10.0F, 10.0F);
            
            
            this.rotationYaw = this.rotationYawHead;

            
            double distance = this.getDistanceToEntity(player);

            if (distance < 15.0D) {
                
                this.setDead();
                
                for (int i = 0; i < 20; ++i) {
                    this.worldObj.spawnParticle(net.minecraft.util.EnumParticleTypes.SMOKE_LARGE, 
                        this.posX + (this.rand.nextDouble() - 0.5D) * this.width, 
                        this.posY + this.rand.nextDouble() * this.height, 
                        this.posZ + (this.rand.nextDouble() - 0.5D) * this.width, 
                        0.0D, 0.0D, 0.0D);
                }
            }
        }
    }

    
    @Override
    protected String getLivingSound() { return null; }
    @Override
    protected String getHurtSound() { return null; }
    @Override
    protected String getDeathSound() { return null; }
    }

