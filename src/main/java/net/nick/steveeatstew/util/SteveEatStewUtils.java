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

    public static final Map<Item, Double> SLOW_EAT_ITEMS = new HashMap<>();

    static {
            SLOW_EAT_ITEMS.put(Items.COOKED_BEEF, 1.5);
            SLOW_EAT_ITEMS.put(Items.BREAD, 2.0);
            // add more items and their multipliers as needed
    }

//TODO: add qol method to stack last container
    public static void dropStackWhenFull(PlayerEntity player, ItemStack stack) {
        if (!player.giveItemStack(stack)) {
            player.dropItem(stack, false);
        }
    }

}
