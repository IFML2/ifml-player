package ifml.player.view;

import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

public class MainView implements Initializable {

    private static final Logger LOG = LoggerFactory.getLogger(MainView.class);

    @FXML private WebView webView;

    @FXML private void onOpen() {
        LOG.info("File::Open menu item");
    }

    @FXML private void onExit() {
        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        webView.setContextMenuEnabled(false);
        webView.getEngine().load(getClass().getResource("/story/story.html").toExternalForm());
    }

}
