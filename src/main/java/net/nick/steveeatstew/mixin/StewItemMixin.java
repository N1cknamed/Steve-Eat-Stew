package net.nick.steveeatstew.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.StewItem;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import net.nick.steveeatstew.util.SteveEatStewUtils;

@Mixin(StewItem.class)
public class StewItemMixin {
    @ModifyReturnValue(
            method = "finishUsing",
            at = @At("RETURN")
    )
    private ItemStack increaseStewMaxStack(ItemStack original, ItemStack stack, World world, LivingEntity user) {
        if (!(user instanceof PlayerEntity player) || stack.getCount() <= 0) {
            return original;
        }
        if (!player.isCreative()) {
            SteveEatStewUtils.dropStackWhenFull(player, new ItemStack(Items.BOWL));
        }
        return stack;
    }
}