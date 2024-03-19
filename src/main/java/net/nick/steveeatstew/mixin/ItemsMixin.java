package net.nick.steveeatstew.mixin;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;

public class ItemsMixin {
    @Mixin(Items.class)
    public static class ItemMixin {
        @ModifyArg(
                method = "<clinit>",
                slice = @Slice(
                        from = @At(value="CONSTANT", args = "stringValue=glistering_melon_slice")
                ),
                at = @At(value = "INVOKE", target = "net/minecraft/item/Item.<init>(Lnet/minecraft/item/Item$Settings;)V", ordinal = 0)
        )
        private static Item.Settings edibleGlisteringMelon(Item.Settings original) {
            return new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.6F).build());
        }

        @ModifyArg(
                method = "<clinit>",
                slice = @Slice(
                        from = @At(value="CONSTANT", args = "stringValue=sugar")
                ),
                at = @At(value = "INVOKE", target = "net/minecraft/item/Item.<init>(Lnet/minecraft/item/Item$Settings;)V", ordinal = 0)
        )
        private static Item.Settings edibleSugar(Item.Settings original) {
            return new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1F).build());
        }
    }
}
