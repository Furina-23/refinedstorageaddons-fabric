package com.refinedmods.refinedstorageaddons;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public final class RSAddonsKeyBindings {
    public static final KeyMapping OPEN_WIRELESS_CRAFTING_GRID = new KeyMapping(
        "key.refinedstorageaddons.openWirelessCraftingGrid",
        InputConstants.Type.KEYSYM,
        GLFW.GLFW_KEY_G,
        "Refined Storage Addons"
    );
}
