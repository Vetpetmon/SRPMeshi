package com.vetpetmon.srpmeshi.core;

import com.dhanantry.scapeandrunparasites.init.SRPPotions;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

public class SRPMItems {

    public static final List<Item> ALL_ITEMS = new ArrayList<>();

    public static final Item
        roasted_buglin = new ItemSRPFood("roasted_buglin",3,0.1f,true),
        raw_buglin = new ItemSRPFood("raw_buglin",1,0.0f,true).setPotionEffectSpecial(new PotionEffect(SRPPotions.COTH_E, 300, 0), 1.0F,false),
        rupter_ramen = new ItemSRPFood("rupter_ramen",4,0.2f,false).setPotionEffectSpecial(new PotionEffect(SRPPotions.COTH_E, 300, 0), 1.0F,false),
        raw_fangs = new ItemSRPFood("raw_fangs",2,0.15f,true).setPotionEffectSpecial(new PotionEffect(MobEffects.POISON, 100, 0), 1.0F,false),
        roasted_fangs = new ItemSRPFood("roasted_fangs",5,0.2f,true),
        beckon_stick = new ItemSRPFood("beckon_stick",3,0.3f,false).setPotionEffectSpecial(new PotionEffect(SRPPotions.COTH_E, 300, 0), 1.0F,false),
        eyebush_stick = new ItemSRPFood("eyebush_stick",4,0.35f,false).setPotionEffectSpecial(new PotionEffect(SRPPotions.COTH_E, 300, 0), 1.0F,false),
        raw_scallops = new ItemSRPFood("raw_scallops",3,0.2f,true).setPotionEffectSpecial(new PotionEffect(MobEffects.POISON, 100, 0), 1.0F,false),
        cooked_scallops = new ItemSRPFood("cooked_scallops",6,0.3f,true),
        summoner_jelly = new ItemSRPFood("summoner_jelly",3,0.2f,false).setPotionEffectSpecial(new PotionEffect(MobEffects.STRENGTH, 600, 0), 1.0F,true),
        glazed_fangs = new ItemSRPFood("glazed_fangs",6,0.5f,false).setPotionEffectSpecial(new PotionEffect(MobEffects.STRENGTH, 900, 1), 1.0F,true),

        raw_ground_tendons = new ItemSRPFood("raw_ground_tendons",2,0.1f,true).setPotionEffectSpecial(new PotionEffect(MobEffects.POISON, 80, 1), 1.0F,false),
        cooked_ground_tendons = new ItemSRPFood("cooked_ground_tendons",4,0.2f,true),
        membread = new ItemSRPFood("membread",2,0.1f,false).setPotionEffectSpecial(new PotionEffect(SRPPotions.COTH_E, 300, 0), 1.0F,false),
        tendon_sandwich = new ItemSRPFood("tendon_sandwich",5,0.25f,false).setPotionEffectSpecial(new PotionEffect(MobEffects.ABSORPTION, 1200, 0), 1.0F,true),
        tendon_sandwich_b = new ItemSRPFood("tendon_sandwich_b",6,0.3f,false).setPotionEffectSpecial(new PotionEffect(MobEffects.ABSORPTION, 1200, 1), 1.0F,true),
        sum_jelly_sandwich = new ItemSRPFood("sum_jelly_sandwich",5,0.25f,false).setPotionEffectSpecial(new PotionEffect(MobEffects.STRENGTH, 900, 1), 1.0F,true),
        sum_jelly_sandwich_b = new ItemSRPFood("sum_jelly_sandwich_b",6,0.3f,false).setPotionEffectSpecial(new PotionEffect(MobEffects.STRENGTH, 600, 2), 1.0F,true),
        core_kebab = new ItemSRPFood("core_kebab",8,0.4f,false).setPotionEffectSpecial(new PotionEffect(MobEffects.INVISIBILITY, 1200, 0), 1.0F,true),
        friedbeckonskins = new ItemSRPFood("friedbeckonskins",2,0.25f,false).setPotionEffectSpecial(new PotionEffect(MobEffects.HASTE, 300, 0), 1.0F,true),
        rotdog = new ItemSRPFood("rotdog",6,0.3f,false).setPotionEffectSpecial(new PotionEffect(MobEffects.STRENGTH, 200, 3), 1.0F,true),
        vilebeefr = new ItemSRPFood("vilebeefr",2,0.1f,false).setPotionEffectSpecial(new PotionEffect(MobEffects.POISON, 100, 2), 1.0F,false),
        vilebeefu = new ItemSRPFood("vilebeefu",4,0.15f,false).setPotionEffectSpecial(new PotionEffect(SRPPotions.COTH_E, 200, 0), 1.0F,false),
        vilebeefc = new ItemSRPFood("vilebeefc",6,0.25f,false).setPotionEffectSpecial(new PotionEffect(MobEffects.STRENGTH, 400, 2), 1.0F,true),
    
        devourercala = new ItemSRPFood("devourercala",1,0.0f,false).setPotionEffectSpecial(new PotionEffect(MobEffects.POISON, 100, 3), 1.0F,false),
        devourercalacooked = new ItemSRPFood("devourercala_cooked",2,0.1f,false).setPotionEffectSpecial(new PotionEffect(SRPPotions.COTH_E, 400, 0), 1.0F,false),
        devourersushi = new ItemSRPFood("devourersushi",4,0.2f,false).setPotionEffectSpecial(new PotionEffect(SRPPotions.COTH_E, 200, 0), 1.0F,false)

        ;
}
