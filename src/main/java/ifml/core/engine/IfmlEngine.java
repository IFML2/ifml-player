package ifml.core.engine;

import java.io.File;

public interface IfmlEngine {

    void loadDictionary(File file); // The Verb dictionary
    void loadStory(File file); // The Story
    void restart();
    void saveGame(File file);
    void loadGame(File file);
    void parse(String command);

}
