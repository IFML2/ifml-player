package ifml.player.view;

import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.concurrent.Worker.State;
import javafx.event.EventHandler;
import netscape.javascript.JSObject;

public class MainView implements Initializable {

    private static final Logger LOG = LoggerFactory.getLogger(MainView.class);

    @FXML private WebView webView;

    @FXML private void onOpen() {
        LOG.info("File::Open menu item");
    }

    @FXML private void onRestart() {
        LOG.info("File::Restart menu item");
    }

    @FXML private void onSave() {
        LOG.info("File::Save menu item");
    }

    @FXML private void onLoad() {
        LOG.info("File::Load menu item");
    }

    @FXML private void onExit() {
        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        webView.setContextMenuEnabled(false);
        var engine = webView.getEngine();
        var adapter = new IfmlAdapter(engine);
        var bridge = new IfmlBridge(adapter);

        engine.setOnAlert(new EventHandler<WebEvent<String>>() {
            
            @Override
            public void handle(WebEvent<String> event) {
                LOG.info("ALERT: {}", event.getData());
            }
        });

        engine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
            @Override
            public void changed(ObservableValue<? extends State> observable, State oldValue, State newValue) {
                if (newValue == State.SUCCEEDED) {
                    var win = (JSObject) engine.executeScript("window");
                    win.setMember("IFML", bridge); //TODO: create with dependencies to Engine...
                    engine.executeScript("window.IFML.log('test');");
                }
            }
        });

        engine.load(getClass().getResource("/story/story.html").toExternalForm());
    }

}
