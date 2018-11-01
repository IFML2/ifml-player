package ifml.player;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import system.FolderChecker;

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
        var parent = (Parent) FXMLLoader.load(getClass().getResource("/view/Main.fxml"));

        primaryStage.setScene(new Scene(parent, 800.0, 600.0));
        primaryStage.setTitle("IFML Player");

        primaryStage.show();
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
