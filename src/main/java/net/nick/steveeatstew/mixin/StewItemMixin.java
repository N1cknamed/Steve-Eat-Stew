package net.nick.steveeatstew.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.StewItem;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.nick.steveeatstew.util.SteveEatStewUtils;

@Mixin(StewItem.class)
public class StewItemMixin {
    @Inject(method = "finishUsing", at = @At(value = "RETURN"), cancellable = true)
    private void increaseStewMaxStack(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        if (user instanceof PlayerEntity player) {
            if (stack.getCount() > 0) {
                if (!player.isCreative()) {
                    SteveEatStewUtils.dropStackWhenFull(player, new ItemStack(Items.BOWL)); //TODO: move last bowl to stack if available
                }
                cir.setReturnValue(stack);
                cir.cancel();
            }
        }
    }
}