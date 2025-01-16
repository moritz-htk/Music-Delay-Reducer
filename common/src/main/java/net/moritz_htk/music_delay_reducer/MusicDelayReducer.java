package net.moritz_htk.music_delay_reducer;

import net.moritz_htk.music_delay_reducer.config.MDRConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The MusicDelayReducer class serves as the entry point for the Music Delay Reducer mod.
 * It initializes the mod, handles logging, and provides debug logging capabilities.
 */
public class MusicDelayReducer {
    /**
     * The unique identifier for the mod.
     */
    public static final String MOD_ID = "music_delay_reducer";

    /**
     * Logger instance for logging messages related to the mod.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    /**
     * Initializes the Music Delay Reducer mod by logging startup messages
     * and loading the configuration.
     */
    public static void init() {
        LOGGER.info("Starting Music Delay Reducer...");
        MDRConfigManager.loadConfig();
        LOGGER.info("Music Delay Reducer started");
    }

    /**
     * Logs a debug message if debug mode is enabled in the configuration.
     *
     * @param message  The message to log.
     * @param argument Optional arguments to include in the log message.
     */
    public static void logDebugMode(String message, Object... argument) {
        if (MDRConfigManager.getConfig().debugModeToggle) {
            if (argument.length > 0) {
                LOGGER.info(message, argument);
            } else {
                LOGGER.info(message);
            }
        }
    }
}