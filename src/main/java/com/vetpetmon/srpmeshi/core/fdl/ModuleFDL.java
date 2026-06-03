package com.vetpetmon.srpmeshi.core.fdl;


import com.dhanantry.scapeandrunparasites.entity.monster.adapted.EntityLumAdapted;
import com.dhanantry.scapeandrunparasites.entity.monster.feral.EntityFerCow;
import com.dhanantry.scapeandrunparasites.entity.monster.inborn.EntityLodo;
import com.dhanantry.scapeandrunparasites.entity.monster.inborn.EntityMudo;
import com.dhanantry.scapeandrunparasites.entity.monster.inborn.EntityNuuh;
import com.dhanantry.scapeandrunparasites.entity.monster.infected.EntityInfCow;
import com.dhanantry.scapeandrunparasites.entity.monster.infected.EntityInfSquid;
import com.dhanantry.scapeandrunparasites.entity.monster.infected.special.EntitySpeCow;
import com.dhanantry.scapeandrunparasites.entity.monster.primitive.EntityLum;
import com.dhanantry.scapeandrunparasites.util.SRPReference;
import com.vetpetmon.srpmeshi.Core;
import com.vetpetmon.srpmeshi.core.SRPMItems;
import com.vetpetmon.srpmeshi.core.config.SRPMeshiConfig;
import com.wdcftgg.farmersdelightlegacy.api.recipe.CookingPotRecipeApi;
import com.wdcftgg.farmersdelightlegacy.api.recipe.CuttingBoardRecipeApi;
import com.wdcftgg.farmersdelightlegacy.api.recipe.knife.HuntingDropRecipeApi;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.LinkedHashMap;

/**
 * The module with exclusively Farmer's Delight Legacy API.
 */
public class ModuleFDL {
    public static void registerRuntimeRecipes() {
        if (SRPMeshiConfig.fdlModule) {
            cookingPot();
            huntingDrops();
        }
    }
    private static void cuttingBoard() {

    }

    private static void cookingPot() {

    }

    private static void huntingDrops() {
        HuntingDropRecipeApi.registerRecipe(recipeKey("buglin_hunting"), target -> target.getClass() == EntityLodo.class,
                new ItemStack(SRPMItems.raw_buglin), false, 0.75f, 0.25f, false, entityId(SRPReference.MOD_ID, "buglin"));
        HuntingDropRecipeApi.registerRecipe(recipeKey("rupter_hunting"), target -> target.getClass() == EntityMudo.class,
                new ItemStack(SRPMItems.raw_buglin), false, 0.5f, 0.1f, false, entityId(SRPReference.MOD_ID, "rupter"));
        HuntingDropRecipeApi.registerRecipe(recipeKey("mangler_hunting"), target -> target.getClass() == EntityNuuh.class,
                new ItemStack(SRPMItems.raw_buglin), false, 0.25f, 0.2f, false, entityId(SRPReference.MOD_ID, "mangler"));
        HuntingDropRecipeApi.registerRecipe(recipeKey("assim_cow_hunting"), target -> target.getClass() == EntityInfCow.class,
                new ItemStack(SRPMItems.vilebeefr), false, 0.45f, 0.25f, false, entityId(SRPReference.MOD_ID, "sim_cow"));
        HuntingDropRecipeApi.registerRecipe(recipeKey("mar_cow_hunting"), target -> target.getClass() == EntitySpeCow.class,
                new ItemStack(SRPMItems.vilebeefr), false, 0.45f, 0.25f, false, entityId(SRPReference.MOD_ID, "mar_cow"));
        HuntingDropRecipeApi.registerRecipe(recipeKey("fer_cow_hunting"), target -> target.getClass() == EntityFerCow.class,
                new ItemStack(SRPMItems.vilebeefr), false, 0.45f, 0.25f, false, entityId(SRPReference.MOD_ID, "fer_cow"));
        HuntingDropRecipeApi.registerRecipe(recipeKey("assim_squid_hunting"), target -> target.getClass() == EntityInfSquid.class,
                new ItemStack(SRPMItems.devourercala), false, 0.15f, 0.1f, false, entityId(SRPReference.MOD_ID, "sim_squid"));
        HuntingDropRecipeApi.registerRecipe(recipeKey("prim_devourer_hunting"), target -> target.getClass() == EntityLum.class,
                new ItemStack(SRPMItems.devourercala), false, 0.45f, 0.15f, false, entityId(SRPReference.MOD_ID, "pri_devourer"));
        HuntingDropRecipeApi.registerRecipe(recipeKey("ada_devourer_hunting"), target -> target.getClass() == EntityLumAdapted.class,
                new ItemStack(SRPMItems.devourercala), false, 0.75f, 0.25f, false, entityId(SRPReference.MOD_ID, "ada_devourer"));
    }

    private static void registerCooking(String name, String[] ingredients, ItemStack result, ItemStack container, int cookingTime, float experience) {
        CookingPotRecipeApi.registerRecipe(recipeKey("cooking/" + name), ingredients, result, container, cookingTime, experience);
    }

    private static void registerKnifeCutting(String name, ItemStack inputStack, ItemStack outputStack, int count, float chance) {
        registerKnifeCutting(name, itemToken(inputStack), outputStack, count, chance);
    }

    private static void registerKnifeCutting(String name, String inputToken, ItemStack outputStack, int count, float chance) {
        String normalOutputToken = itemToken(outputStack);
        CuttingBoardRecipeApi.registerRecipe(recipeKey("cutting/" + name), inputToken, null, normalOutputToken, count, chance);
    }

    private static String itemToken(ItemStack itemStack) {
        String token = itemStack.getItem().getRegistryName().toString();
        if (itemStack.getMetadata() != 0) token += "@" + itemStack.getMetadata();
        return token;
    }

    private static void registerShaped(RegistryEvent.Register<IRecipe> event, String name, ItemStack output, Object... recipe) {
        ShapedOreRecipe shapedOreRecipe = new ShapedOreRecipe(location(name), output, recipe);
        registerRecipe(event, name, shapedOreRecipe);
    }

    private static void registerShapeless(RegistryEvent.Register<IRecipe> event, String name, ItemStack output, Object... ingredients) {
        ShapelessOreRecipe shapelessOreRecipe = new ShapelessOreRecipe(location(name), output, ingredients);
        registerRecipe(event, name, shapelessOreRecipe);
    }

    private static void registerRecipe(RegistryEvent.Register<IRecipe> event, String name, IRecipe recipe) {
        recipe.setRegistryName(location(name));
        event.getRegistry().register(recipe);
    }

    private static ItemStack stack(Item item) {
        return new ItemStack(item);
    }

    private static ItemStack stack(Block block) {
        return new ItemStack(block);
    }

    private static ItemStack enchantedStack(Item item, Enchantment enchantment, int level) {
        ItemStack itemStack = stack(item);
        EnchantmentHelper.setEnchantments(new LinkedHashMap<Enchantment, Integer>() {{
            put(enchantment, level);
        }}, itemStack);
        return itemStack;
    }

    private static ItemStack itemStack(String registryName) {
        Item item = item(registryName);
        return item == Items.AIR ? ItemStack.EMPTY : new ItemStack(item);
    }

    private static Item item(String registryName) {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(registryName));
        return item == null ? Items.AIR : item;
    }

    private static ResourceLocation location(String path) {
        return new ResourceLocation(Core.MOD_ID, path);
    }

    private static String recipeKey(String path) {return Core.MOD_ID + ":" + path;}

    private static ResourceLocation entityId(String namespace, String path) {return new ResourceLocation(namespace, path);}
}
