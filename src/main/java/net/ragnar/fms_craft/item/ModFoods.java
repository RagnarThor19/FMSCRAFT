package net.ragnar.fms_craft.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CHEESEBURGER = new FoodProperties.Builder()
            .fast().nutrition(16).saturationMod(1.4F).build();

    public static final FoodProperties JOINT = new FoodProperties.Builder().saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 200), 0.8f).build();
}
