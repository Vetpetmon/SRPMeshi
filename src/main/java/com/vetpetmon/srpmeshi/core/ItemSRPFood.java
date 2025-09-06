package com.vetpetmon.srpmeshi.core;


import com.dhanantry.scapeandrunparasites.SRPMain;
import com.vetpetmon.srpmeshi.Core;
import com.vetpetmon.srpmeshi.client.IHasModel;
import com.vetpetmon.srpmeshi.core.config.SRPMeshiConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSRPFood extends ItemFood implements IHasModel {

    public ItemSRPFood(String name, int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(SRPMain.SRP_CREATIVETAB);
        SRPMItems.ALL_ITEMS.add(this);
    }

    // I cannot be bothered to deal with access transformers. Therefore, we will rewrite this entirely
    /** Represents the potion effect that will occur upon eating this food. Set by setPotionEffect */
    protected PotionEffect potionType;
    /** Probably of the set potion effect occurring */
    protected float potionEffectChance;
    /** If this item gives beneficial effects */
    protected boolean beneficialEffects;

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (SRPMeshiConfig.itemEffects) {
            if (!worldIn.isRemote && this.potionType != null && worldIn.rand.nextFloat() < this.potionEffectChance)
            {
                if (
                        (this.beneficialEffects && SRPMeshiConfig.itemPosEffects)
                        || (!this.beneficialEffects && SRPMeshiConfig.itemNegEffects)
                )
                    player.addPotionEffect(new PotionEffect(this.potionType));
            }
        }
    }


    public ItemFood setPotionEffectSpecial(PotionEffect effect, float probability, boolean beneficialEffects)
    {
        this.potionType = effect;
        this.potionEffectChance = probability;
        this.beneficialEffects = beneficialEffects;
        return this;
    }

    @Override
    public void registerModels() {
        Core.proxy.modelReg(this, 0, "inventory");
    }
}
