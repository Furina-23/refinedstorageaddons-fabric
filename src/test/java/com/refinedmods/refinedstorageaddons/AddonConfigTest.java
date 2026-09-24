package com.refinedmods.refinedstorageaddons;

import com.refinedmods.refinedstorageaddons.config.ServerConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AddonConfigTest {
    @Test
    void wirelessCraftingGridUsesExpectedDefaults() {
        ServerConfig.WirelessCraftingGrid config = new ServerConfig().getWirelessCraftingGrid();

        assertTrue(config.getUseEnergy());
        assertEquals(3200, config.getCapacity());
        assertEquals(30, config.getOpenUsage());
        assertEquals(1, config.getCraftUsage());
        assertEquals(10, config.getClearUsage());
    }

}
