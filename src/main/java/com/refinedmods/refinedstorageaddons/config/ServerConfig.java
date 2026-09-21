package com.refinedmods.refinedstorageaddons.config;

import com.refinedmods.refinedstorage.config.ConfigSpec;

public class ServerConfig {
    private final ConfigSpec.Builder builder = new ConfigSpec.Builder();
    private final ConfigSpec spec;
    private WirelessCraftingGrid wirelessCraftingGrid;

    public ServerConfig() {
        wirelessCraftingGrid = new WirelessCraftingGrid();

        spec = builder.build();
    }

    public WirelessCraftingGrid getWirelessCraftingGrid() {
        return wirelessCraftingGrid;
    }

    public class WirelessCraftingGrid {
        private final ConfigSpec.BooleanValue useEnergy;
        private final ConfigSpec.IntValue capacity;
        private final ConfigSpec.IntValue openUsage;
        private final ConfigSpec.IntValue craftUsage;
        private final ConfigSpec.IntValue clearUsage;

        public WirelessCraftingGrid() {
            builder.push("wirelessCraftingGrid");

            useEnergy = builder.comment("Whether the Wireless Crafting Grid uses energy").define("useEnergy", true);
            capacity = builder.comment("The energy capacity of the Wireless Crafting Grid").defineInRange("capacity", 3200, 0, Integer.MAX_VALUE);
            openUsage = builder.comment("The energy used by the Wireless Crafting Grid to open").defineInRange("openUsage", 30, 0, Integer.MAX_VALUE);
            craftUsage = builder.comment("The energy used by the Wireless Crafting Grid to craft an item").defineInRange("craftUsage", 1, 0, Integer.MAX_VALUE);
            clearUsage = builder.comment("The energy used by the Wireless Crafting Grid to clear the crafting matrix").defineInRange("clearUsage", 10, 0, Integer.MAX_VALUE);

            builder.pop();
        }

        public boolean getUseEnergy() {
            return useEnergy.get();
        }

        public int getCapacity() {
            return capacity.get();
        }

        public int getOpenUsage() {
            return openUsage.get();
        }

        public int getCraftUsage() {
            return craftUsage.get();
        }

        public int getClearUsage() {
            return clearUsage.get();
        }
    }

    public ConfigSpec getSpec() {
        return spec;
    }
}
