package com.vetpetmon.srpmeshi.core.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Configuration;

@Config(modid = "srpmeshi", name = "srp_meshi_config")
public class SRPMeshiConfig {

    @Config.Name("Item Effects")
    @Config.Comment({"Enables or disables consumable effects.", "Setting this to false will disable items giving COTH or buffs to the player."})
    @Config.RequiresMcRestart
    public static boolean itemEffects = true;

    @Config.Name("Negative Item Effects")
    @Config.Comment({"Enables or disables debuffs of food items.", "Setting this to false will disable items giving effects such as COTH to the player."})
    @Config.RequiresMcRestart
    public static boolean itemNegEffects = true;

    @Config.Name("Positive Item Effects")
    @Config.Comment({"Enables or disables buffs of food items.", "Setting this to false will disable items giving effects such as Strength to the player."})
    @Config.RequiresMcRestart
    public static boolean itemPosEffects = true;

    @Config.Name("Always Edible")
    @Config.Comment({"Allows food items to be eaten at any time."})
    @Config.RequiresMcRestart
    public static boolean alwaysEdible = false;

    @Config.Name("Terrafirmacraft Module")
    @Config.Comment({"Attaches Food Data to items.","If you are playing with Terrafirmagreg, this should be disabled in favor of using Crafttweaker.","Disabled by default. Requires a full game reboot to apply."})
    @Config.RequiresMcRestart
    public static boolean tfcModule = false;


}
