package system;

import ifml.player.model.ApplicationConfiguration;

/**
 * Singleton class which provide configuration for application.
 */
public enum ConfigHolder {
    INSTANCE;

    private ApplicationConfiguration config = null;

    public ApplicationConfiguration getConfiguration() {
        if (config == null) {
            // TODO: load configuration
        }
        return config;
    }

}
