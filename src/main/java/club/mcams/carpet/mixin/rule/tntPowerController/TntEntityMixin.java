/*
 * This file is part of the Carpet AMS Addition project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2025 A Minecraft Server and contributors
 *
 * Carpet AMS Addition is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Carpet AMS Addition is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Carpet AMS Addition. If not, see <https://www.gnu.org/licenses/>.
 */

package club.mcams.carpet.mixin.rule.tntPowerController;

import club.mcams.carpet.AmsServerSettings;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

import net.minecraft.entity.TntEntity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(TntEntity.class)
public abstract class TntEntityMixin {
    @ModifyExpressionValue(
        //#if MC>=12102
        //$$ method = "<init>(Lnet/minecraft/entity/EntityType;Lnet/minecraft/world/World;)V",
        //#else
        method = "explode",
        //#endif
        at = @At(value = "CONSTANT", args = "floatValue=4.0F")
    )
    private float modifyTntPower(float original) {
        return AmsServerSettings.tntPowerController != -1.0D ? (float) AmsServerSettings.tntPowerController : original;
    }
}
