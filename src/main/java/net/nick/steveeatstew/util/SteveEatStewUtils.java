package net.nick.steveeatstew.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SteveEatStewUtils {
    //TODO: check for compatibility with other stack increase mods
    public static final Set<Item> INCREASE_STACK_ITEMS = Set.of(
            Items.MUSHROOM_STEW,
            Items.RABBIT_STEW,
            Items.BEETROOT_SOUP,
            Items.HONEY_BOTTLE,
            Items.CAKE
    );

    public static final Map<Item, Double> USETIME_MODIFIERS = new HashMap<>();
    static {
            //Snack
            USETIME_MODIFIERS.put(Items.COOKIE, 0.5);
            USETIME_MODIFIERS.put(Items.SUGAR, 0.5);
            USETIME_MODIFIERS.put(Items.MELON_SLICE, 0.5);
            USETIME_MODIFIERS.put(Items.SPIDER_EYE, 0.5);

            //Dessert
            USETIME_MODIFIERS.put(Items.APPLE, 0.75);
            USETIME_MODIFIERS.put(Items.CARROT, 0.75);
            USETIME_MODIFIERS.put(Items.GLISTERING_MELON_SLICE, 0.75);
            USETIME_MODIFIERS.put(Items.SWEET_BERRIES, 0.75);
            USETIME_MODIFIERS.put(Items.GLOW_BERRIES, 0.75);

            //Lunch
            USETIME_MODIFIERS.put(Items.MUSHROOM_STEW, 1.25);
            USETIME_MODIFIERS.put(Items.RABBIT_STEW, 1.25);

            //Dinner
            USETIME_MODIFIERS.put(Items.COOKED_BEEF, 1.5);
            USETIME_MODIFIERS.put(Items.BEEF, 1.5);
            USETIME_MODIFIERS.put(Items.COOKED_CHICKEN, 1.5);
            USETIME_MODIFIERS.put(Items.CHICKEN, 1.5);
            USETIME_MODIFIERS.put(Items.COOKED_MUTTON, 1.5);
            USETIME_MODIFIERS.put(Items.MUTTON, 1.5);
            USETIME_MODIFIERS.put(Items.COOKED_PORKCHOP, 1.5);
            USETIME_MODIFIERS.put(Items.PORKCHOP, 1.5);
            USETIME_MODIFIERS.put(Items.COOKED_RABBIT, 1.5);
            USETIME_MODIFIERS.put(Items.RABBIT, 1.5);
            USETIME_MODIFIERS.put(Items.BREAD, 1.5);
            USETIME_MODIFIERS.put(Items.ROTTEN_FLESH, 1.5);
    }

//TODO: add qol method to stack last container
    public static void dropStackWhenFull(PlayerEntity player, ItemStack stack) {
        if (!player.giveItemStack(stack)) {
            player.dropItem(stack, false);
        }
    }

}
