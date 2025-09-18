package com.vetpetmon.srpmeshi.core.tfc;


import com.vetpetmon.srpmeshi.core.SRPMItems;
import net.dries007.tfc.api.capability.food.CapabilityFood;
import net.dries007.tfc.api.capability.food.FoodHandler;
import net.dries007.tfc.api.recipes.heat.HeatRecipeSimple;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.minecraft.item.ItemStack;

/**
 * The module with exclusively TFC-related registries.
 */
public class ModuleTFC {

    /**
     * Registers Firepit/Charcoal Grill recipes
     */
    public static void registerHeatRecipes() {
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

    /**
     * Attaches TFC food data (nutrients system) to SRPM items
     */
    public static void attachFoodData(){

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
}
