package com.vetpetmon.srpmeshi.core;


import com.dhanantry.scapeandrunparasites.SRPMain;
import com.vetpetmon.srpmeshi.Core;
import com.vetpetmon.srpmeshi.client.IHasModel;
import net.minecraft.item.ItemFood;

public class ItemSRPFood extends ItemFood implements IHasModel {

    public ItemSRPFood(String name, int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(SRPMain.SRP_CREATIVETAB);
        SRPMItems.ALL_ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Core.proxy.modelReg(this, 0, "inventory");
    }
}
