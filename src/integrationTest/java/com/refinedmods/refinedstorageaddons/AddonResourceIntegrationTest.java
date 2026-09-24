package com.refinedmods.refinedstorageaddons;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AddonResourceIntegrationTest {
    @Test
    void addonDeclaresRefinedStorageDependencyAndCraftingRecipe() throws IOException {
        String metadata = read("fabric.mod.json");
        String recipe = read("data/refinedstorageaddons/recipes/wireless_crafting_grid.json");

        assertTrue(metadata.contains("\"id\": \"refinedstorageaddons\""));
        assertTrue(metadata.contains("\"refinedstorage\": \">=1.12.4-fabric.1\""));
        assertTrue(metadata.contains("com.refinedmods.refinedstorageaddons.fabric.RSAddonsFabric"));
        assertTrue(recipe.contains("refinedstorageaddons:wireless_crafting_grid"));
        assertTrue(recipe.contains("refinedstorage:crafting_grid"));
    }

    private static String read(String resource) throws IOException {
        try (InputStream stream = AddonResourceIntegrationTest.class.getClassLoader().getResourceAsStream(resource)) {
            if (stream == null) {
                throw new IOException("Missing packaged resource: " + resource);
            }
            return new String(stream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}
