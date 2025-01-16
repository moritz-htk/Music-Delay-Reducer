package net.moritz_htk.music_delay_reducer.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.moritz_htk.music_delay_reducer.MusicDelayReducer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Manages the configuration for the Music Delay Reducer mod.
 * This class handles loading, saving, and accessing the mod's configuration file.
 */
public class MDRConfigManager {
    /**
     * Gson instance for JSON serialization and deserialization with pretty printing enabled.
     */
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * The file where the mod's configuration is stored.
     */
    private static final File CONFIG_FILE = new File("config/" + MusicDelayReducer.MOD_ID + ".json");

    /**
     * The current configuration instance.
     */
    private static MDRConfig CONFIG;

    /**
     * Loads the configuration from the configuration file. If the file does not exist,
     * it creates a new configuration instance with default values.
     */
    public static void loadConfig() {
        if (CONFIG_FILE.exists()) {
            try (FileReader reader = new FileReader(CONFIG_FILE)) {
                CONFIG = GSON.fromJson(reader, MDRConfig.class);
                MusicDelayReducer.logDebugMode("Config loaded successfully");
            } catch (IOException e) {
                MusicDelayReducer.LOGGER.error("Failed to load config: {}", e.getMessage());
                e.printStackTrace();
            }
        } else {
            CONFIG = new MDRConfig();
            MusicDelayReducer.LOGGER.warn("Config file not found. Creating new config...");
        }
    }

    /**
     * Saves the current configuration to the configuration file.
     */
    public static void saveConfig() {
        MusicDelayReducer.logDebugMode("Saving config...");
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            GSON.toJson(CONFIG, writer);
            MusicDelayReducer.logDebugMode("Config saved successfully");
        } catch (IOException e) {
            MusicDelayReducer.LOGGER.error("Failed to save config: {}", e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the current configuration instance.
     *
     * @return The current {@link MDRConfig} instance.
     */
    public static MDRConfig getConfig() {
        return CONFIG;
    }
}