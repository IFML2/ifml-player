package ifml.player;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ifml.player.system.FolderChecker;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Main class for IFML Player application.
 */
public class App extends Application {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    @Override
    public void init() {
        LOG.info("Initialization...");
        if (!FolderChecker.INSTANCE.checkAppFolder()) {
            System.exit(-1);
        }
        if (!FolderChecker.INSTANCE.checkStoriesFolder()) {
            System.exit(-1);
        }
        //TODO: Load stories description...
    }

    @Override
    public void stop() {
        LOG.info("Finalization...");
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        var resourceBundle = ResourceBundle.getBundle("ifml-player", new Locale("ru", "RU"));
        var parent = loadParent("/view/Main.fxml", resourceBundle);

        primaryStage.setScene(new Scene(parent, 800.0, 600.0));
        primaryStage.setTitle(resourceBundle.getString("title"));
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/ifml.png")));

        primaryStage.show();
    }

    private Parent loadParent(final String viewName, final ResourceBundle resourceBundle) {
        try {
            return (Parent) FXMLLoader.load(getClass().getResource(viewName), resourceBundle);
        } catch (IOException ex) {
            LOG.error("Error during load FXML", ex);
        }
        return null;
    }

    /**
     * Entry point for all application.
     *
     * @param args the command line arguments.
     */
    public static void main(String...args) {
        LOG.info("The application arguments is {}", Arrays.toString(args));
        if (args.length > 1) {
            //TODO: Pre-load story
        }
        launch(App.class, args);
    }

}
