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

package club.mcams.carpet.mixin.rule.opPlayerNoCheatExtra;

import club.mcams.carpet.AmsServerSettings;
import club.mcams.carpet.util.Messenger;
import static club.mcams.carpet.AmsServer.fancyName;

import net.minecraft.entity.Entity;
import net.minecraft.server.command.KillCommand;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.*;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collection;

@Mixin(KillCommand.class)
public abstract class KillCommandMixin {
    @Inject(method = "execute", at = @At("HEAD"))
    private static void execute(ServerCommandSource source, Collection<? extends Entity> targets, CallbackInfoReturnable<Integer> cir) {
        if(AmsServerSettings.opPlayerNoCheatExtra) {
            //#if MC>11800
            //$$ Messenger.tell(source, Text.literal("<" + fancyName + "> "+ "Disabled by opPlayerNoCheatExtra")
            //#else
            Messenger.tell(source, (BaseText) new LiteralText("<" + fancyName + "> "+ "Disabled by opPlayerNoCheatExtra")
                    //#endif
                    .setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xFF0000))), true);
            cir.cancel();
        }
    }
}