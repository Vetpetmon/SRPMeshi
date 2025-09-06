package com.vetpetmon.srpmeshi;


import com.vetpetmon.srpmeshi.client.IHasModel;
import com.vetpetmon.srpmeshi.core.SRPMItems;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Core.MOD_ID, name = Core.MOD_NAME, version = Core.VERSION, dependencies = Core.DEPENDENCIES)

public class Core {
    public static final String
            MOD_ID = "srpmeshi",
            MOD_NAME = "SRP Meshi",
            VERSION = "1.3",
            DEPENDENCIES = "required-after:forge@[14.21.1.2387,);required-after:srparasites@[1.9.20,)",
            PROXY_COMMON = "com.vetpetmon.srpmeshi.CommonProxy",
            PROXY_CLIENT = "com.vetpetmon.srpmeshi.ClientProxy";

    public static Logger logger = LogManager.getLogger(MOD_ID);

    @SidedProxy(serverSide = PROXY_COMMON, clientSide = PROXY_CLIENT)
    public static com.vetpetmon.srpmeshi.CommonProxy proxy;
    @Mod.EventHandler
    public void PreInit(FMLPreInitializationEvent event) {

        logger = event.getModLog();
        proxy.preInit(event);

        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void Postinit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }


    public static ResourceLocation getResource(final String name)
    {
        return new ResourceLocation(Core.MOD_ID, name);
    }

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equals(Core.MOD_ID))
        {
            ConfigManager.sync(Core.MOD_ID, Config.Type.INSTANCE);
            logger.info("Configuration loaded or changed.");
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void modelRegister(ModelRegistryEvent event) {
        for (Item item : SRPMItems.ALL_ITEMS) if (item instanceof IHasModel)  ((IHasModel) item).registerModels();
    }
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void registerModels(ModelRegistryEvent event) {
        for (Item item : SRPMItems.ALL_ITEMS) if (item instanceof IHasModel)  ((IHasModel) item).registerModels();
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(SRPMItems.ALL_ITEMS.toArray(new Item[0]));
    }

    @Mod.Instance(MOD_ID)
    public static Core instance;
}
