package system;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The helper for check/recreate folder structure. 
 */
public enum FolderChecker {
    INSTANCE;

    public boolean checkAppFolder() {
        var appFolder = getAppPath().toFile();
        if (!appFolder.exists()) {
            return appFolder.mkdirs();
        } else if (!appFolder.isDirectory()) {
            LOG.error("Unable create application folder because already exists file with the same name");
            return false;
        }
        return true;
    }

    public boolean checkStoriesFolder() {
        var storiesFolder = Paths.get(getAppPath().toAbsolutePath().toString(), "stories").toFile();
        if (!storiesFolder.exists()) {
            return storiesFolder.mkdirs();
        } else if (!storiesFolder.isDirectory()) {
            LOG.error("Unable create stories folder because already exists file with the same name");
            return false;
        }
        return true;
    }

    private static final Logger LOG = LoggerFactory.getLogger(FolderChecker.class);

    private Path getAppPath() {
        return Paths.get(System.getProperty("user.home"), ".ifml", "player");
    }

}
