/*
 * This file is part of the Carpet AMS Addition project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2023  A Minecraft Server and contributors
 *
 * Carpet AMS Addition is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Carpet AMS Addition is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Carpet AMS Addition.  If not, see <https://www.gnu.org/licenses/>.
 */

package club.mcams.carpet.mixin.rule.commandCustomAntiFireItems_itemAntiExplosion;

import club.mcams.carpet.AmsServerSettings;

import club.mcams.carpet.commands.rule.commandCustomAntiFireItems.CustomAntiFireItemsCommandRegistry;
import club.mcams.carpet.utils.RegexTools;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;

import net.minecraft.entity.ItemEntity;
//#if MC>=11900
//$$ import net.minecraft.registry.tag.DamageTypeTags;
//#endif
import net.minecraft.entity.damage.DamageSource;
//#if MC>=12102
//$$ import net.minecraft.server.world.ServerWorld;
//#endif

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Objects;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin implements ItemEntityInvoker {
    @ModifyReturnValue(method = "isFireImmune", at = @At("RETURN"))
    private boolean isFireImmune(boolean original) {
        if (
            !Objects.equals(AmsServerSettings.commandCustomAntiFireItems, "false") &&
            CustomAntiFireItemsCommandRegistry.CUSTOM_ANTI_FIRE_ITEMS.contains(RegexTools.getItemRegisterName(this.invokeGetStack()))
        ) {
            return true;
        } else {
            return original;
        }
    }

    //#if MC>=12102
    //$$ @ModifyExpressionValue(
    //$$     method = "damage",
    //$$     at = @At(
    //$$         value = "INVOKE",
    //$$         target = "Lnet/minecraft/entity/ItemEntity;isAlwaysInvulnerableTo(Lnet/minecraft/entity/damage/DamageSource;)Z"
    //$$     )
    //$$ )
    //#else
    @ModifyExpressionValue(
        method = "damage",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/ItemEntity;isInvulnerableTo(Lnet/minecraft/entity/damage/DamageSource;)Z"
        )
    )
    //#endif
    private boolean damage(
        boolean original,
        //#if MC>=12102
        //$$ ServerWorld world,
        //#endif
        DamageSource source
    ) {
        //#if MC>=11900
        //$$ if(AmsServerSettings.itemAntiExplosion && source.isIn(DamageTypeTags.IS_EXPLOSION)) {
        //#else
        if (AmsServerSettings.itemAntiExplosion && source.isExplosive()) {
            //#endif
            return original || AmsServerSettings.itemAntiExplosion;
        } else {
            return original;
        }
    }
}