package ifml.ifml2.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ifml.ifml2.xml.game.GameDTO;
import ifml.ifml2.xml.game.GameParser;
import ifml.ifml2.xml.libs.LibraryDTO;
import ifml.ifml2.xml.libs.LibraryParser;
import ifml.ifml2.xml.story.StoryDTO;
import ifml.ifml2.xml.story.StoryParser;

public enum XmlLoader {
    INSTANCE;

    private static final Logger LOG = LoggerFactory.getLogger(XmlLoader.class);

    public LibraryDTO loadLibrary(final File file) {
        try (var fis = new FileInputStream(file)) {
            return loadLibrary(fis);
        } catch (IOException  ex) {
            LOG.error("Unable load library {}", file.getAbsolutePath(), ex);
        }
        return null;
    }

    public StoryDTO loadStory(final File file) {
        return null;
    }

    public GameDTO loadGame(final File file) {
        try (var fis = new FileInputStream(file)) {
            return loadGame(fis);
        } catch (IOException ex) {
            LOG.error("Unable load game {}", file.getAbsolutePath(), ex);
        }
        return null;
    }

    public LibraryDTO loadLibrary(final InputStream inputStream) {
        var libraryParser = new LibraryParser();
        return libraryParser.loadLibrary(inputStream);
    }

    public StoryDTO loadStory(final InputStream inputStream) {
        var storyParser = new StoryParser();
        return storyParser.loadStory(inputStream);
    }

    public GameDTO loadGame(final InputStream inputStream) {
        var gameParser = new GameParser();
        return gameParser.loadGame(inputStream);
    }

}
