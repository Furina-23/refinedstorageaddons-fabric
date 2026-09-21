package com.refinedmods.refinedstorageaddons.fabric;

import com.refinedmods.refinedstorageaddons.setup.ClientSetup;
import net.fabricmc.api.ClientModInitializer;

public final class RSAddonsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientSetup.initialize();
    }
}
