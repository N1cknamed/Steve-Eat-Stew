package net.nick.steveeatstew.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;

import java.util.Set;

public class SteveEatStewUtils {
    //TODO: check for compatibility with other stack increase mods
    public static final Set<Item> INCREASE_STACK_ITEMS = Set.of(
            Items.MUSHROOM_STEW,
            Items.RABBIT_STEW,
            Items.BEETROOT_SOUP,
            Items.HONEY_BOTTLE
    );

//    public static final Set<Item> MAKE_EDIBLE_ITEMS = Set.of(
//            Items.GLISTERING_MELON_SLICE,
//            Items.SUGAR
//    );

//TODO: add qol method to stack last container
    public static void dropStackWhenFull(PlayerEntity player, ItemStack stack) {
        if (!player.giveItemStack(stack)) {
            player.dropItem(stack, false);
        }
    }

}
