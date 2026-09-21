package com.refinedmods.refinedstorageaddons.setup;

import com.refinedmods.refinedstorageaddons.RSAddons;
import com.refinedmods.refinedstorageaddons.RSAddonsItems;
import com.refinedmods.refinedstorageaddons.apiimpl.network.grid.WirelessCraftingGridGridFactory;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public final class CommonSetup {
    private CommonSetup() {
    }

    public static void initialize() {
        RSAddons.RSAPI.getGridManager().add(WirelessCraftingGridGridFactory.ID, new WirelessCraftingGridGridFactory());
        Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            new ResourceLocation(RSAddons.ID, "general"),
            CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                .title(Component.translatable("itemGroup.refinedstorageaddons"))
                .icon(() -> new ItemStack(RSAddonsItems.CREATIVE_WIRELESS_CRAFTING_GRID.get()))
                .displayItems((params, output) -> {
                    output.accept(RSAddonsItems.WIRELESS_CRAFTING_GRID.get());
                    output.accept(RSAddonsItems.CREATIVE_WIRELESS_CRAFTING_GRID.get());
                })
                .build()
        );
    }
}
