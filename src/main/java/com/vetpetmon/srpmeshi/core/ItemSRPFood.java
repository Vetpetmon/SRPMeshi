package com.vetpetmon.srpmeshi.core;


import com.dhanantry.scapeandrunparasites.SRPMain;
import com.vetpetmon.srpmeshi.Core;
import com.vetpetmon.srpmeshi.client.IHasModel;
import com.vetpetmon.srpmeshi.core.config.SRPMeshiConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemSRPFood extends ItemFood implements IHasModel {

    public ItemSRPFood(String name, int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        setUnlocalizedName(name);
        setRegistryName(name);
        this.alwaysEdibleToggle(SRPMeshiConfig.alwaysEdible);
        setCreativeTab(SRPMain.SRP_CREATIVETAB);
        SRPMItems.ALL_ITEMS.add(this);
    }

    public ItemFood setPotionEffectSpecial(PotionEffect effect, float probability, boolean beneficialEffects)
    {
        return  (SRPMeshiConfig.itemEffects &&
                    ((beneficialEffects && SRPMeshiConfig.itemPosEffects)
                    || (!beneficialEffects && SRPMeshiConfig.itemNegEffects))
                )?this.setPotionEffect(effect,probability):this;
    }

    @Override
    public void registerModels() {
        Core.proxy.modelReg(this, 0, "inventory");
    }


    public ItemFood alwaysEdibleToggle(boolean toggle){
        return (toggle)?this.setAlwaysEdible():this;
    }
}
