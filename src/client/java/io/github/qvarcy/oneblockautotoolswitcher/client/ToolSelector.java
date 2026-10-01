package io.github.qvarcy.oneblockautotoolswitcher.client;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

final class ToolSelector {
    private static final float DEFAULT_HAND_SPEED = 1.0F;
    private static final double CORRECT_TOOL_BONUS = 1000.0D;
    private static final double EPSILON = 0.0001D;
    private static final int MIN_REMAINING_DURABILITY = 5;

    private ToolSelector() {
    }

    static int findBestHotbarSlot(LocalPlayer player, BlockState state) {
        Inventory inventory = player.getInventory();
        int currentSlot = inventory.getSelectedSlot();
        int bestSlot = currentSlot;
        double bestScore = score(inventory.getItem(currentSlot), state);

        for (int slot = 0; slot < Inventory.getSelectionSize(); slot++) {
            ItemStack stack = inventory.getItem(slot);
            double score = score(stack, state);

            if (score > bestScore + EPSILON) {
                bestScore = score;
                bestSlot = slot;
            }
        }

        return bestScore > DEFAULT_HAND_SPEED ? bestSlot : currentSlot;
    }

    private static double score(ItemStack stack, BlockState state) {
        if (stack.isEmpty() || isAlmostBroken(stack)) {
            return 0.0D;
        }

        float speed = stack.getDestroySpeed(state);
        boolean correctTool = stack.isCorrectToolForDrops(state);

        if (speed <= DEFAULT_HAND_SPEED && !correctTool) {
            return 0.0D;
        }

        // drops matter more than shaving a tiny bit off the timer
        return speed + (correctTool ? CORRECT_TOOL_BONUS : 0.0D);
    }

    private static boolean isAlmostBroken(ItemStack stack) {
        if (!stack.isDamageableItem()) {
            return false;
        }

        int remaining = stack.getMaxDamage() - stack.getDamageValue();

        // five hits left means this tool has earned a quiet retirement
        return remaining <= MIN_REMAINING_DURABILITY;
    }
}
