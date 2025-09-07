package com.vetpetmon.srpmeshi;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Core.MOD_ID)
public class HandlerBus {


    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equals(Core.MOD_ID))
        {
            ConfigManager.sync(Core.MOD_ID, Config.Type.INSTANCE);
            Core.logger.info("Configuration loaded or changed.");
        }
    }

}
