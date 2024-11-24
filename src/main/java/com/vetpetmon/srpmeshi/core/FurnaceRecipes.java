package com.vetpetmon.srpmeshi.core;

import com.dhanantry.scapeandrunparasites.init.SRPItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FurnaceRecipes {

    public static void register(){
        furnaceRecipes();
    }

    private static void furnaceRecipes(){
        GameRegistry.addSmelting(SRPItems.itemlurecomponent1, new ItemStack(SRPMItems.roasted_buglin), 0.5f);
        GameRegistry.addSmelting(SRPMItems.raw_fangs, new ItemStack(SRPMItems.roasted_fangs), 2.0f);
        GameRegistry.addSmelting(SRPMItems.raw_scallops, new ItemStack(SRPMItems.cooked_scallops), 3.0f);
        GameRegistry.addSmelting(SRPMItems.raw_ground_tendons, new ItemStack(SRPMItems.cooked_ground_tendons), 1.0f);
        GameRegistry.addSmelting(SRPItems.venkrol_drop, new ItemStack(SRPMItems.membread), 1.0f);
        GameRegistry.addSmelting(SRPMItems.membread, new ItemStack(SRPMItems.friedbeckonskins,2), 1.0f);
        GameRegistry.addSmelting(SRPMItems.vilebeefr, new ItemStack(SRPMItems.vilebeefu), 1.0f);
        GameRegistry.addSmelting(SRPMItems.vilebeefu, new ItemStack(SRPMItems.vilebeefc), 1.5f);
    }
}
