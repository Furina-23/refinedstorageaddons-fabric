package com.refinedmods.refinedstorageaddons.fabric;

import com.refinedmods.refinedstorageaddons.RSAddons;
import com.refinedmods.refinedstorageaddons.RSAddonsItems;
import com.refinedmods.refinedstorageaddons.setup.CommonSetup;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public final class RSAddonsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        RSAddons.SERVER_CONFIG.getSpec().load(
            FabricLoader.getInstance().getConfigDir().resolve("refinedstorageaddons-server.json")
        );
        RSAddonsItems.register();
        CommonSetup.initialize();
    }
}
