package net.nick.steveeatstew.mixin;

import net.minecraft.item.Item;
import net.nick.steveeatstew.util.SteveEatStewUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {
    @Inject(method = "getMaxCount", at = @At(value = "HEAD"), cancellable = true)
    private void changeMaxStack(CallbackInfoReturnable<Integer> cir) {
        if (!SteveEatStewUtils.INCREASE_STACK_ITEMS.contains((Item)(Object)this)) {
            return;
        }
        cir.setReturnValue(64);
        cir.cancel();
    }
}
