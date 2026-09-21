package com.refinedmods.refinedstorageaddons;

import com.refinedmods.refinedstorage.api.IRSAPI;
import com.refinedmods.refinedstorage.apiimpl.API;
import com.refinedmods.refinedstorageaddons.config.ServerConfig;

public final class RSAddons {
    public static final IRSAPI RSAPI = API.instance();

    public static final String ID = "refinedstorageaddons";
    public static final ServerConfig SERVER_CONFIG = new ServerConfig();

    private RSAddons() {
    }
}
