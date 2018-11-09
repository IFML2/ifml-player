package ifml.player.view;

import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ifml.core.engine.IfmlEngineImpl;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import netscape.javascript.JSObject;

public class MainView implements Initializable {

    private static final Logger LOG = LoggerFactory.getLogger(MainView.class);

    @FXML private MenuItem menuItemFileOpen;
    @FXML private MenuItem menuItemFileRestart;
    @FXML private MenuItem menuItemFileSave;
    @FXML private MenuItem menuItemFileLoad;
    @FXML private MenuItem menuItemFileExit;

    @FXML private MenuItem menuItemLibraryCatalog;
    @FXML private MenuItem menuItemLibraryImport;

    @FXML private MenuItem menuItemSettingsCheat;
    @FXML private MenuItem menuItemSettingsSettings;

    @FXML private WebView webView;

    private IfmlEngineImpl ifmlEngine = new IfmlEngineImpl();

    private void initMenuItems() {
        menuItemFileOpen.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                var fileChooser = new FileChooser();
                var selected = fileChooser.showOpenDialog(null);
                if (selected != null) {
                    //TODO: file was choosen;
                    ifmlEngine.loadStory(selected);
                }
            }

        });

        menuItemFileRestart.setDisable(true);
        menuItemFileRestart.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //TODO: Ask You are sure ?
                ifmlEngine.restart();
            }

        });

        menuItemFileSave.setDisable(true);

        menuItemFileLoad.setDisable(true);

        menuItemFileExit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //TODO: Add question: You are really want to exit.
                Platform.exit();
            }

        });

        menuItemLibraryCatalog.setDisable(true);

        menuItemLibraryImport.setDisable(true);

        menuItemSettingsCheat.setDisable(true);

        menuItemSettingsSettings.setDisable(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initMenuItems();

        webView.setContextMenuEnabled(false);
        var webEngine = webView.getEngine();
        var adapter = new IfmlAdapter(webEngine, ifmlEngine);
        var bridge = new IfmlBridge(adapter);

        webEngine.setOnAlert(new EventHandler<WebEvent<String>>() {

            @Override
            public void handle(WebEvent<String> event) {
                LOG.info("ALERT: {}", event.getData());
            }

        });

        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
            @Override
            public void changed(ObservableValue<? extends State> observable, State oldValue, State newValue) {
                if (newValue == State.SUCCEEDED) {
                    var win = (JSObject) webEngine.executeScript("window");
                    win.setMember("IFML", bridge); //TODO: create with dependencies to Engine...
                    webEngine.executeScript("window.IFML.log('test');");
                }
            }
        });
        ifmlEngine.registerOutDevice(adapter);

        webEngine.load(getClass().getResource("/story/story.html").toExternalForm());
    }

}
