package net.nick.steveeatstew.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.item.Item;
import net.nick.steveeatstew.util.SteveEatStewUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {
    @ModifyReturnValue(
            method = "getMaxCount",
            at = @At("RETURN")
    )
    private int changeMaxStack(int original) {
        if (SteveEatStewUtils.INCREASE_STACK_ITEMS.contains((Item)(Object)this)) {
            return 64;
        }
        return original;
    }

    @ModifyReturnValue(
            method = "getMaxUseTime",
            at = @At("RETURN")
    )
    private int slowEat(int original) {
        Item item = (Item)(Object)this;
        if (SteveEatStewUtils.SLOW_EAT_ITEMS.containsKey(item)) {
            double multiplier = SteveEatStewUtils.SLOW_EAT_ITEMS.get(item);
            return (int) (original * multiplier);
        }
        return original;
    }
}
