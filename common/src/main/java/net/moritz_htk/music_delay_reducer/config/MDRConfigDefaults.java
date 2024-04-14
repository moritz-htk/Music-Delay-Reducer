package net.moritz_htk.music_delay_reducer.config;

public class MDRConfigDefaults implements MDRConfig {
    public static final int MIN_TIME = 10;
    public static final int MAX_TIME = 20;

    @Override
    public int minTime() {
        return MIN_TIME;
    }

    @Override
    public int maxTime() {
        return MAX_TIME;
    }
}