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

package club.mcams.carpet;

import club.mcams.carpet.util.recipes.CraftingRule;
import club.mcams.carpet.settings.Rule;
import static club.mcams.carpet.settings.AmsRuleCategory.*;

import club.mcams.carpet.validators.rule.maxBlockInteractionDistance.maxBlockInteractionDistanceValidator;
import club.mcams.carpet.validators.rule.maxClientBlockReachDistance.maxClientBlockReachDistanceValidator;

public class AmsServerSettings {

    @Rule(categories = {AMS, FEATURE})
    public static boolean superBow = false;

    @Rule(categories = {AMS, FEATURE, SURVIVAL})
    public static boolean scheduledRandomTickCactus = false;

    @Rule(categories = {AMS, FEATURE, SURVIVAL})
    public static boolean scheduledRandomTickBamboo = false;

    @Rule(categories = {AMS, FEATURE, SURVIVAL})
    public static boolean scheduledRandomTickChorusFlower = false;

    @Rule(categories = {AMS, FEATURE, SURVIVAL})
    public static boolean scheduledRandomTickSugarCane = false;

    @Rule(categories = {AMS, FEATURE, SURVIVAL})
    public static boolean scheduledRandomTickStem = false;

    @Rule(categories = {AMS, FEATURE, SURVIVAL})
    public static boolean scheduledRandomTickAllPlants = false;

    @Rule(categories = {AMS, OPTIMIZATION})
    public static boolean optimizedDragonRespawn = false;

    @Rule(
            options = {"bone_block", "wither_skeleton_skull", "note_block", "OFF"},
            categories = {AMS, FEATURE, AMS_CHUNKLOADER}
    )
    public static String noteBlockChunkLoader = "OFF";

    @Rule(
            options = {"bone_block", "bedrock", "all", "OFF"},
            categories = {AMS, FEATURE, AMS_CHUNKLOADER}
    )
    public static String pistonBlockChunkLoader = "OFF";

    @Rule(categories = {AMS, FEATURE, AMS_CHUNKLOADER})
    public static boolean bellBlockChunkLoader = false;

    @Rule(categories = {AMS, FEATURE, AMS_CHUNKLOADER})
    public static boolean blockChunkLoaderKeepTickUpdate = false;

    @Rule(categories = {AMS, FEATURE, AMS_CHUNKLOADER})
    public static boolean keepEntityUpdate = false;

    @Rule(categories = {AMS, COMMAND, AMS_CHUNKLOADER})
    public static String commandChunkLoading = "false";

    @Rule(categories = {AMS, FEATURE})
    public static boolean netherWaterPlacement = false;

    //#if MC>=11700
    @Rule(categories = {AMS, FEATURE, SURVIVAL})
    public static boolean softDeepslate = false;
    //#endif

    @Rule(categories = {AMS, FEATURE, SURVIVAL})
    public static boolean softObsidian = false;

    @Rule(categories = {AMS, FEATURE, TNT})
    public static boolean blowUpEverything = false;

    @Rule(categories = {AMS, FEATURE, SURVIVAL})
    public static boolean sharedVillagerDiscounts = false;

    @Rule(categories = {AMS, FEATURE})
    public static boolean fakePeace = false;

    @Rule(categories = {AMS, FEATURE, SURVIVAL})
    public static boolean extinguishedCampfire = false;

    @Rule(categories = {AMS, FEATURE, SURVIVAL})
    public static boolean safeFlight = false;

    //#if MC<11900
    @Rule(categories = {AMS, FEATURE})
    public static boolean boneBlockUpdateSuppressor = false;
    //#endif

    @Rule(categories = {AMS, FEATURE, SURVIVAL, TNT})
    public static boolean weakObsidian = false;

    @Rule(categories = {AMS, FEATURE, SURVIVAL, TNT})
    public static boolean weakCryingObsidian = false;

    //#if MC>=11900
    //$$ @Rule(categories = {AMS, FEATURE, SURVIVAL, TNT})
    //$$ public static boolean weakReinforcedDeepslate = false;
    //#endif

    @Rule(categories = {AMS, FEATURE, SURVIVAL, TNT})
    public static boolean weakBedRock = false;

    @Rule(categories = {AMS, FEATURE, SURVIVAL, TNT})
    public static boolean enhancedWorldEater = false;

    @Rule(categories = {AMS, FEATURE, SURVIVAL})
    public static boolean infiniteTrades = false;

    @Rule(categories = {AMS, FEATURE})
    public static boolean invulnerable = false;

    @Rule(categories = {AMS, FEATURE, CREATIVE})
    public static boolean creativeOneHitKill = false;

    @Rule(categories = {AMS, FEATURE, SURVIVAL})
    public static boolean largeEnderChest = false;

    @Rule(categories = {AMS, FEATURE, OPTIMIZATION})
    public static boolean bambooModelNoOffset = false;

    @Rule(categories = {AMS, FEATURE})
    public static boolean bambooCollisionBoxDisabled = false;

    @Rule(categories = {AMS, FEATURE})
    public static boolean campfireSmokeParticleDisabled = false;

    @Rule(categories = {AMS, FEATURE})
    public static boolean antiFireTotem = false;

    @Rule(categories = {AMS, FEATURE, TNT})
    public static boolean itemAntiExplosion = false;

    @Rule(categories = {AMS, FEATURE, CREATIVE})
    public static boolean creativeShulkerBoxDropsDisabled = false;

    @Rule(categories = {AMS, FEATURE, CREATIVE})
    public static boolean bedRockFlying = false;

    @Rule(categories = {AMS, FEATURE, SURVIVAL})
    public static boolean shulkerHitLevitationDisabled = false;

    @Rule(categories = {AMS, FEATURE, SURVIVAL})
    public static boolean immuneShulkerBullet = false;

    @Rule(categories = {AMS, FEATURE, SURVIVAL})
    public static boolean kirinArm = false;

    @Rule(categories = {AMS, FEATURE, EXPERIMENTAL})
    public static blueSkullProbability blueSkullController = blueSkullProbability.VANILLA;

    @Rule(categories = {AMS, FEATURE, EXPERIMENTAL})
    public static boolean enderManTeleportRandomlyDisabled = false;

    @Rule(
            options = {"VANILLA", "Ⅰ", "Ⅱ", "Ⅲ", "Ⅳ", "Ⅴ"},
            categories = {AMS, FEATURE, EXPERIMENTAL}
    )
    public static String fasterMovement = "VANILLA";

    @Rule(categories = {AMS, FEATURE, EXPERIMENTAL})
    public static fasterMovementDimension fasterMovementController = fasterMovementDimension.ALL;

    @Rule(categories = {AMS, FEATURE, SURVIVAL})
    public static boolean easyWitherSkeletonSkullDrop = false;

    @Rule(categories = {AMS, FEATURE, SURVIVAL, COMMAND})
    public static boolean anvilInteractionDisabled = false;

    @Rule(categories = {AMS, FEATURE, SURVIVAL, COMMAND})
    public static boolean opPlayerNoCheatExtra = false;

    //#if MC<=11800
    @Rule(categories = {AMS, FEATURE, SURVIVAL, EXPERIMENTAL})
    public static boolean amsUpdateSuppressionCrashFix = false;
    //#endif

    @Rule(categories = {AMS, FEATURE, SURVIVAL})
    public static boolean cakeBlockDropOnBreak = false;

    @Rule(categories = {AMS, FEATURE, SURVIVAL})
    public static boolean noCakeEating = false;

    @Rule(categories = {AMS, FEATURE})
    public static boolean redstoneComponentSound = false;

    @Rule(categories = {AMS, FEATURE, EXPERIMENTAL})
    public static boolean largeShulkerBox = false;

    @Rule(
            options = {"-1"},
            categories = {AMS, FEATURE, SURVIVAL},
            validators = maxBlockInteractionDistanceValidator.class,
            strict = false
    )
    public static double maxBlockInteractionDistance = -1.0D;

    @Rule(
            options = {"-1"},
            categories = {AMS, FEATURE, SURVIVAL},
            validators = maxClientBlockReachDistanceValidator.class,
            strict = false
    )
    public static double maxClientBlockReachDistance = -1.0D;

    @Rule(categories = {AMS, FEATURE})
    public static boolean mineBedrock = false;

    @Rule(categories = {AMS, FEATURE})
    public static boolean mineEndPortalFrame = false;

    @Rule(
            options = {"VANILLA", "minecraft:bedrock", "minecraft:bedrock,minecraft:obsidian"},
            categories = {AMS, FEATURE},
            strict = false
    )
    public static String customMovableBlock = "VANILLA";

    @Rule(categories = {AMS, FEATURE})
    public static boolean easyMaxLevelBeacon = false;

    /*
     * 合成表规则
     */
    @SuppressWarnings("unused")
    @CraftingRule(recipes = "enchanted_golden_apples.json")
    @Rule(categories = {AMS, CRAFTING, SURVIVAL})
    public static boolean craftableEnchantedGoldenApples = false;

    //#if MC>=11700
    @SuppressWarnings("unused")
    @CraftingRule(recipes = "bundle.json")
    @Rule(categories = {AMS, CRAFTING, SURVIVAL})
    public static boolean craftableBundle = false;
    //#endif

    //#if MC<11900 && MC>=11700
    @SuppressWarnings("unused")
    @CraftingRule(recipes = "sculk_sensor.json")
    @Rule(categories = {AMS, CRAFTING, SURVIVAL})
    public static boolean craftableSculkSensor = false;
    //#endif

    @SuppressWarnings("unused")
    @CraftingRule(recipes = "bone_block.json")
    @Rule(categories = {AMS, CRAFTING, SURVIVAL})
    public static boolean betterCraftableBoneBlock = false;

    @SuppressWarnings("unused")
    @CraftingRule(recipes = "elytra.json")
    @Rule(categories = {AMS, CRAFTING, SURVIVAL})
    public static boolean craftableElytra = false;

    @SuppressWarnings("unused")
    @CraftingRule(recipes = {"dispenser1.json", "dispenser2.json"})
    @Rule(categories = {AMS, CRAFTING, SURVIVAL})
    public static boolean betterCraftableDispenser = false;

    //#if MC>=11700
    @SuppressWarnings("unused")
    @CraftingRule(recipes = "polished_blackstone_button.json")
    @Rule(categories = {AMS, CRAFTING, SURVIVAL})
    public static boolean betterCraftablePolishedBlackStoneButton = false;
    //#endif

    public enum blueSkullProbability {
        VANILLA,
        SURELY,
        NEVER
    }

    public enum fasterMovementDimension {
        OVERWORLD,
        NETHER,
        END,
        ALL
    }
}
