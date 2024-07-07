/*
 * This file is part of the Carpet AMS Addition project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2024 A Minecraft Server and contributors
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

package club.mcams.carpet.mixin.rule.preventEndSpikeRespawn;

import club.mcams.carpet.AmsServerSettings;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(targets="net/minecraft/entity/boss/dragon/EnderDragonSpawnState$3")
public class EnderDragonSpawnStateMixin {
    @WrapOperation(
            method = "run",
            at = @At(
                    value="INVOKE",
                    target="Lnet/minecraft/server/world/ServerWorld;removeBlock(Lnet/minecraft/util/math/BlockPos;Z)Z"
            )
    )
    private boolean onRemoveBlock(ServerWorld instance, BlockPos blockPos, boolean b, Operation<Boolean> original) {
        if (AmsServerSettings.preventEndSpikeRespawn.equals("false")) {
            return original.call(instance, blockPos, b);
        }
        else{
            return false;
        }
    }

    @WrapOperation(
            method = "run",
            at = @At(
                    value = "INVOKE",
                    target =
                    //#if MC<11904
                            "Lnet/minecraft/server/world/ServerWorld;createExplosion(Lnet/minecraft/entity/Entity;DDDFLnet/minecraft/world/explosion/Explosion$DestructionType;)Lnet/minecraft/world/explosion/Explosion;"
                    //#else
                    //$$    "Lnet/minecraft/server/world/ServerWorld;createExplosion(Lnet/minecraft/entity/Entity;DDDFLnet/minecraft/world/World$ExplosionSourceType;)Lnet/minecraft/world/explosion/Explosion;"
                    //#endif
            )
    )
    private Explosion onCreateExplosion(ServerWorld instance, Entity entity, double x, double y, double z, float power,
                                        //#if MC<11904
                                        Explosion.DestructionType destructionType,
                                        //#else
                                        //$$ World.ExplosionSourceType destructionType,
                                        //#endif
                                        Operation<Explosion> original) {
        if (AmsServerSettings.preventEndSpikeRespawn.equals("false")) {
            original.call(instance, entity, x, y, z, power, destructionType);
        }
        return null;
    }
}
