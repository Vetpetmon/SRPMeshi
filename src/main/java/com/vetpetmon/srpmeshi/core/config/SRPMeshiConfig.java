package com.vetpetmon.srpmeshi.core.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Configuration;

@Config(modid = "srpmeshi", name = "srp_meshi_config")
public class SRPMeshiConfig {

    @Config.Name("Item Effects")
    @Config.Comment({"Enables or disables consumable effects.", "Setting this to false will disable items giving COTH or buffs to the player."})
    public static boolean itemEffects = true;

    @Config.Name("Negative Item Effects")
    @Config.Comment({"Enables or disables debuffs of food items.", "Setting this to false will disable items giving effects such as COTH to the player."})
    public static boolean itemNegEffects = true;

    @Config.Name("Positive Item Effects")
    @Config.Comment({"Enables or disables buffs of food items.", "Setting this to false will disable items giving effects such as Strength to the player."})
    public static boolean itemPosEffects = true;

    @Config.Name("Always Edible")
    @Config.Comment({"Allows food items to be eaten at any time."})
    public static boolean alwaysEdible = false;


}
