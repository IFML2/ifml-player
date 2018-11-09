package ifml.player.view;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ifml.core.engine.IfmlEngine;
import ifml.core.engine.IfmlOutputDevice;
import javafx.scene.media.Media;
import javafx.scene.web.WebEngine;

/**
 * Adapter to connect HTML page and Engine.
 */
public class IfmlAdapter implements IfmlOutputDevice {

    private static final Logger LOG = LoggerFactory.getLogger(IfmlAdapter.class);

    private WebEngine  webEngine;
    private IfmlEngine ifmlEngine;

    public IfmlAdapter(final WebEngine webEngine, final IfmlEngine ifmlEngine) {
        this.webEngine = webEngine;
        this.ifmlEngine = ifmlEngine;
    }

    public void parse(final String command) {
        ifmlEngine.parse(command);
    }

    @Override
    public void showLocation(final String name, final String description) {
        webEngine.executeScript(String.format("window.IFMLUI.showLocation(\"%s\",\"%s\");", name, textPreProcessor(description)));
    }

    @Override
    public void showText(final String text) {
        webEngine.executeScript(String.format("window.IFMLUI.showText(\"%s\");", textPreProcessor(text)));
    }

    @Override
    public void showImage(final BufferedImage image, final String description) {
        var base64Image = imagePreProcessor(image);
        webEngine.executeScript(String.format("window.IFMLUI.showImage(\"%s\",\"%s\")", base64Image, description));
    }

    @Override
    public void playMusic(final Media media, final String description) {
        //TODO: Add music support...
    } 

    private String textPreProcessor(final String text) {
        //TODO: May be we need use special format for page mark up like asciidoc or markdown ???
        return text;
    }

    private String imagePreProcessor(final BufferedImage image) {
        try(var byteArrayStream = new ByteArrayOutputStream()) {
            ImageIO.write(image, "png", byteArrayStream);
            return Base64.getEncoder().encodeToString(byteArrayStream.toByteArray());
        } catch (Exception ex) {
            LOG.warn("Unable pre process image");
        }
        return "";
    }

}
