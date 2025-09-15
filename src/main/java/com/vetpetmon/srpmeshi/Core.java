package com.vetpetmon.srpmeshi;


import com.vetpetmon.srpmeshi.client.IHasModel;
import com.vetpetmon.srpmeshi.core.SRPMItems;
import com.vetpetmon.srpmeshi.core.config.SRPMeshiConfig;
import com.vetpetmon.srpmeshi.core.tfc.MeshiFoodData;
import net.dries007.tfc.api.capability.food.CapabilityFood;
import net.dries007.tfc.api.capability.food.FoodData;
import net.dries007.tfc.api.capability.food.FoodHandler;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipeSimple;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

@Mod(modid = Core.MOD_ID, name = Core.MOD_NAME, version = Core.VERSION, dependencies = Core.DEPENDENCIES)
public class Core {
    public static final String
            MOD_ID = "srpmeshi",
            MOD_NAME = "SRP Meshi",
            VERSION = "1.7",
            DEPENDENCIES = "required-after:forge@[14.21.1.2387,);required-after:srparasites@[1.9.20,);after:tfc",
            PROXY_COMMON = "com.vetpetmon.srpmeshi.CommonProxy",
            PROXY_CLIENT = "com.vetpetmon.srpmeshi.ClientProxy";

    public static Logger logger = LogManager.getLogger(MOD_ID);

    @SidedProxy(serverSide = PROXY_COMMON, clientSide = PROXY_CLIENT)
    public static com.vetpetmon.srpmeshi.CommonProxy proxy;
    @Mod.EventHandler
    public void PreInit(FMLPreInitializationEvent event) {

        logger = event.getModLog();
        proxy.preInit(event);

        if (Loader.isModLoaded("tfc") && SRPMeshiConfig.tfcModule) {
            logger.info("Hello, Terrafirmacraft!");
        }

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
        logger.info("All items have been registered.");

        if (Loader.isModLoaded("tfc") && SRPMeshiConfig.tfcModule) {
            logger.info("We will now attempt to natively support TFC's food system.");
            attachFoodData();
            TFCRegistries.HEAT.registerAll(
                    new HeatRecipeSimple(IIngredient.of(SRPMItems.vilebeefr),               new ItemStack(SRPMItems.vilebeefu), 200, 480).setRegistryName("undercooked_vilebeef"),
                    new HeatRecipeSimple(IIngredient.of(SRPMItems.vilebeefu),               new ItemStack(SRPMItems.vilebeefc), 200, 480).setRegistryName("cooked_vilebeef"),
                    new HeatRecipeSimple(IIngredient.of(SRPMItems.raw_buglin),              new ItemStack(SRPMItems.roasted_buglin), 200, 480).setRegistryName("roasted_buglin"),
                    new HeatRecipeSimple(IIngredient.of(SRPMItems.raw_fangs),               new ItemStack(SRPMItems.roasted_fangs), 200, 480).setRegistryName("roasted_fangs"),
                    new HeatRecipeSimple(IIngredient.of(SRPMItems.raw_ground_tendons),      new ItemStack(SRPMItems.cooked_ground_tendons), 200, 480).setRegistryName("cooked_ground_tendons"),
                    new HeatRecipeSimple(IIngredient.of(SRPMItems.devourercala),            new ItemStack(SRPMItems.devourercalacooked), 200, 480).setRegistryName("cooked_devourer_calamari"),
                    new HeatRecipeSimple(IIngredient.of(SRPMItems.raw_scallops),            new ItemStack(SRPMItems.cooked_scallops), 200, 480).setRegistryName("cooked_scallops")
            );
        }
    }

    public void attachFoodData(){

        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.devourercala),             () -> new FoodHandler(null, MeshiFoodData.DEVOURER_CALAMARI));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.devourercalacooked),       () -> new FoodHandler(null, MeshiFoodData.COOKED_DEVOURER_CALAMARI));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.devourersushi),            () -> new FoodHandler(null, MeshiFoodData.DEVOURER_SUSHI));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.vilebeefr),                () -> new FoodHandler(null, MeshiFoodData.RAW_VILEBEEF));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.vilebeefu),                () -> new FoodHandler(null, MeshiFoodData.UNDERCOOKED_VILEBEEF));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.vilebeefc),                () -> new FoodHandler(null, MeshiFoodData.COOKED_VILEBEEF));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.rupter_ramen),             () -> new FoodHandler(null, MeshiFoodData.RUPTER_RAMEN));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.raw_buglin),               () -> new FoodHandler(null, MeshiFoodData.RAW_BUGLIN));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.roasted_buglin),           () -> new FoodHandler(null, MeshiFoodData.ROASTED_BUGLIN));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.raw_fangs),                () -> new FoodHandler(null, MeshiFoodData.RAW_FANGS));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.roasted_fangs),            () -> new FoodHandler(null, MeshiFoodData.COOKED_FANGS));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.glazed_fangs),             () -> new FoodHandler(null, MeshiFoodData.GLAZED_FANGS));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.raw_scallops),             () -> new FoodHandler(null, MeshiFoodData.RAW_SCALLOPS));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.cooked_scallops),          () -> new FoodHandler(null, MeshiFoodData.COOKED_SCALLOPS));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.sum_jelly_sandwich_b),     () -> new FoodHandler(null, MeshiFoodData.SUMMONER_JELLY_SANDWICH_B));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.sum_jelly_sandwich),       () -> new FoodHandler(null, MeshiFoodData.SUMMONER_JELLY_SANDWICH));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.tendon_sandwich_b),        () -> new FoodHandler(null, MeshiFoodData.TENDON_SANDWICH_B));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.tendon_sandwich),          () -> new FoodHandler(null, MeshiFoodData.TENDON_SANDWICH));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.summoner_jelly),           () -> new FoodHandler(null, MeshiFoodData.SUMMONER_JELLY));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.beckon_stick),             () -> new FoodHandler(null, MeshiFoodData.BECKON_STICK));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.eyebush_stick),            () -> new FoodHandler(null, MeshiFoodData.EYEBUSH_STICK));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.friedbeckonskins),         () -> new FoodHandler(null, MeshiFoodData.FRIED_BECKON_MEMBRANE));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.core_kebab),               () -> new FoodHandler(null, MeshiFoodData.CORE_KEBAB));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.membread),                 () -> new FoodHandler(null, MeshiFoodData.MEMBRANE_BREAD));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(SRPMItems.rotdog),                   () -> new FoodHandler(null, MeshiFoodData.ROTDOG));

    }

    @Mod.Instance(MOD_ID)
    public static Core instance;
}
