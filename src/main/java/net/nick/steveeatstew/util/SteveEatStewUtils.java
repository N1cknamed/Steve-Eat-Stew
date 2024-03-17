package net.nick.steveeatstew.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;

import java.util.Set;

public class SteveEatStewUtils {
    public static final Set<Class<? extends Item>> INCREASE_STACK_ITEMS = Set.of(
            PotionItem.class,
            StewItem.class,
            HoneyBottleItem.class
    );

//    public static final Set<Class<? extends Item>> MAKE_EDIBLE_ITEMS = Set.of(
//
//    );

    public static void dropStackWhenFull(PlayerEntity player, ItemStack stack) {
        if (!player.giveItemStack(stack)) {
            player.dropStack(stack);
        }
    }

}
