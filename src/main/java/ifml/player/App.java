package ifml.player;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class for IFML Player application.
 */
public class App extends Application {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    @Override
    public void init() {
        LOG.info("Initialization...");
    }

    @Override
    public void stop() {
        LOG.info("Finalization...");
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        var parent = new Group();

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
        //TODO: Support command line parameter - story file name.
        launch(App.class, args);
    }

}
