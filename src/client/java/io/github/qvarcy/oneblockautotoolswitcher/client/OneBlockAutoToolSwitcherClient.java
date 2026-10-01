package io.github.qvarcy.oneblockautotoolswitcher.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public final class OneBlockAutoToolSwitcherClient implements ClientModInitializer {
    public static final String MOD_ID = "oneblock_autotoolswitcher";

    private final KeyMapping.Category category = KeyMapping.Category.register(
        Identifier.fromNamespaceAndPath(MOD_ID, "controls")
    );

    private final KeyMapping toggleKey = KeyMappingHelper.registerKeyMapping(
        new KeyMapping(
            "key.oneblock_autotoolswitcher.toggle",
            InputConstants.Type.KEYSYM,
            InputConstants.KEY_V,
            category
        )
    );

    private boolean enabled = true;

    @Override
    public void onInitializeClient() {
        ClientTickEvents.START_CLIENT_TICK.register(this::onClientTick);
    }

    private void onClientTick(Minecraft client) {
        while (toggleKey.consumeClick()) {
            enabled = !enabled;

            if (client.player != null) {
                client.player.sendSystemMessage(Component.literal(
                    "OneBlock AutoToolSwitcher: " + (enabled ? "ON" : "OFF")
                ));
            }
        }

        if (!enabled || client.player == null || client.level == null || client.gui.screen() != null) {
            return;
        }

        if (!client.options.keyAttack.isDown()) {
            return;
        }

        if (client.hitResult == null || client.hitResult.getType() != HitResult.Type.BLOCK) {
            return;
        }

        BlockHitResult blockHit = (BlockHitResult) client.hitResult;
        BlockState state = client.level.getBlockState(blockHit.getBlockPos());

        if (state.isAir()) {
            return;
        }

        int bestSlot = ToolSelector.findBestHotbarSlot(client.player, state);
        int currentSlot = client.player.getInventory().getSelectedSlot();

        if (bestSlot == currentSlot) {
            return;
        }

        // same block new tool less mouse wheel cardio
        client.player.getInventory().setSelectedSlot(bestSlot);
    }
}
