/*
 * This file is part of the Carpet AMS Addition project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2024  A Minecraft Server and contributors
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

package club.mcams.carpet.mixin.rule.experimentalContentCheckDisabled;

import club.mcams.carpet.utils.compat.DummyClass;

//#if MC>=11900
//$$ import com.llamalad7.mixinextras.injector.ModifyReturnValue;
//$$ import net.minecraft.resource.featuretoggle.FeatureSet;
//$$ import org.spongepowered.asm.mixin.injection.At;
//$$ import club.mcams.carpet.AmsServerSettings;
//#endif

import org.spongepowered.asm.mixin.Mixin;

import top.byteeeee.annotationtoolbox.annotation.GameVersion;

@GameVersion(version = "Minecraft >= 1.19")
//#if MC>=11900
//$$ @Mixin(FeatureSet.class)
//#else
@Mixin(DummyClass.class)
//#endif
public abstract class FeatureSetMixin {
    //#if MC>=11900
    //$$ @ModifyReturnValue(method = "contains", at = @At("RETURN"))
    //$$ private boolean contains(boolean original) {
    //$$     return AmsServerSettings.experimentalContentCheckDisabled ? true : original;
    //$$ }
    //#endif
}
