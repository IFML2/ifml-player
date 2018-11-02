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
        webView.getEngine().load(getClass().getResource("/story/about.html").toExternalForm());
    }

}
