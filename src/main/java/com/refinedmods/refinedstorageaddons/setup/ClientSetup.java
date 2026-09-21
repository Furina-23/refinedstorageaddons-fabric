package com.refinedmods.refinedstorageaddons.setup;

import com.refinedmods.refinedstorage.item.property.NetworkItemPropertyGetter;
import com.refinedmods.refinedstorage.screen.KeyInputListener;
import com.refinedmods.refinedstorageaddons.RSAddons;
import com.refinedmods.refinedstorageaddons.RSAddonsItems;
import com.refinedmods.refinedstorageaddons.RSAddonsKeyBindings;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public final class ClientSetup {
    private ClientSetup() {
    }

    public static void initialize() {
        KeyBindingHelper.registerKeyBinding(RSAddonsKeyBindings.OPEN_WIRELESS_CRAFTING_GRID);
        NetworkItemPropertyGetter network = new NetworkItemPropertyGetter();
        ResourceLocation connected = new ResourceLocation(RSAddons.ID, "connected");
        ItemProperties.register(RSAddonsItems.WIRELESS_CRAFTING_GRID.get(), connected, network::call);
        ItemProperties.register(RSAddonsItems.CREATIVE_WIRELESS_CRAFTING_GRID.get(), connected, network::call);
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null && Screen.hasControlDown()
                && RSAddonsKeyBindings.OPEN_WIRELESS_CRAFTING_GRID.consumeClick()) {
                KeyInputListener.findAndOpen(
                    RSAddonsItems.WIRELESS_CRAFTING_GRID.get(),
                    RSAddonsItems.CREATIVE_WIRELESS_CRAFTING_GRID.get()
                );
            }
        });
    }
}
