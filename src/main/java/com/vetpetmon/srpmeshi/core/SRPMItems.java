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
        rupter_ramen = new ItemSRPFood("rupter_ramen",4,0.2f,false).setPotionEffect(new PotionEffect(SRPPotions.COTH_E, 300, 0), 1.0F),
        raw_fangs = new ItemSRPFood("raw_fangs",2,0.15f,true).setPotionEffect(new PotionEffect(MobEffects.POISON, 100, 0), 1.0F),
        roasted_fangs = new ItemSRPFood("roasted_fangs",5,0.2f,true),
        beckon_stick = new ItemSRPFood("beckon_stick",3,0.3f,false).setPotionEffect(new PotionEffect(SRPPotions.COTH_E, 300, 0), 1.0F),
        eyebush_stick = new ItemSRPFood("eyebush_stick",4,0.35f,false).setPotionEffect(new PotionEffect(SRPPotions.COTH_E, 300, 0), 1.0F),
        raw_scallops = new ItemSRPFood("raw_scallops",3,0.2f,true).setPotionEffect(new PotionEffect(MobEffects.POISON, 100, 0), 1.0F),
        cooked_scallops = new ItemSRPFood("cooked_scallops",6,0.3f,true),
        summoner_jelly = new ItemSRPFood("summoner_jelly",3,0.2f,false).setPotionEffect(new PotionEffect(MobEffects.STRENGTH, 600, 0), 1.0F),
        glazed_fangs = new ItemSRPFood("glazed_fangs",6,0.5f,false).setPotionEffect(new PotionEffect(MobEffects.STRENGTH, 900, 1), 1.0F),

        raw_ground_tendons = new ItemSRPFood("raw_ground_tendons",2,0.1f,true).setPotionEffect(new PotionEffect(MobEffects.POISON, 80, 1), 1.0F),
        cooked_ground_tendons = new ItemSRPFood("cooked_ground_tendons",4,0.2f,true),
        membread = new ItemSRPFood("membread",2,0.1f,false).setPotionEffect(new PotionEffect(SRPPotions.COTH_E, 300, 0), 1.0F),
        tendon_sandwich = new ItemSRPFood("tendon_sandwich",5,0.25f,false).setPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 1200, 0), 1.0F),
        tendon_sandwich_b = new ItemSRPFood("tendon_sandwich_b",6,0.3f,false).setPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 1200, 1), 1.0F),
        sum_jelly_sandwich = new ItemSRPFood("sum_jelly_sandwich",5,0.25f,false).setPotionEffect(new PotionEffect(MobEffects.STRENGTH, 900, 1), 1.0F),
        sum_jelly_sandwich_b = new ItemSRPFood("sum_jelly_sandwich_b",6,0.3f,false).setPotionEffect(new PotionEffect(MobEffects.STRENGTH, 900, 2), 1.0F),
        core_kebab = new ItemSRPFood("core_kebab",8,0.4f,false).setPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 1200, 0), 1.0F),
        friedbeckonskins = new ItemSRPFood("friedbeckonskins",2,0.25f,false).setPotionEffect(new PotionEffect(MobEffects.HASTE, 300, 0), 1.0F),
        rotdog = new ItemSRPFood("rotdog",6,0.3f,false).setPotionEffect(new PotionEffect(MobEffects.STRENGTH, 200, 3), 1.0F)

        ;
}
