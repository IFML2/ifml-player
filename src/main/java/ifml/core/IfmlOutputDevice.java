package ifml.core;

import java.awt.image.BufferedImage;

import javafx.scene.media.Media;

public interface IfmlOutputDevice {

    void showLocation(String name, String description);
    void showText(String text);
    void showImage(BufferedImage image, String description);
    void playMusic(Media media, String description);

}
