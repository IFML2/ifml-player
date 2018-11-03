package ifml.player.view;

import javafx.scene.web.WebEngine;

/**
 * Adapter to connect HTML page and Engine.
 */
public class IfmlAdapter {

    private WebEngine webEngine;

    public IfmlAdapter(final WebEngine webEngine) {
        this.webEngine = webEngine;
    }

    public void parse(final String text) {
        //TODO: Call to Engine
    }

    public void showText(final String text) {
        webEngine.executeScript("IFMLUI.showText(" + text + ")");
    } 

    public void showImage() {
        //TODO: how provide image ?
    }

    public void showLocation(final String name, final String description) {
        webEngine.executeScript("IFMLUI.showLocation(" + name + "," + description + ")");
    }
    //TODO: May be we need use special format for page mark up like asciidoc or markdown ???
}
