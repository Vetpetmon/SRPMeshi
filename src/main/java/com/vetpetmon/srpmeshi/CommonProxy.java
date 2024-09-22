package com.vetpetmon.srpmeshi;

import com.vetpetmon.srpmeshi.core.FurnaceRecipes;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
    }

    public void init(FMLInitializationEvent event) {
        FurnaceRecipes.register();
    }

    public void modelReg(Item item, int meta, String id) {}
    public void postInit(FMLPostInitializationEvent event) {
    }


    public void registerItemRenderer(Item item, int meta, String id) {

    }

}
