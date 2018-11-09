module ifml.player {
    requires javafx.base;
    requires javafx.controls;
    requires transitive javafx.graphics;
    requires javafx.fxml;
    requires javafx.web;
    requires org.slf4j;
    requires java.desktop;
    requires jdk.jsobject;
    requires javafx.media;
    requires java.xml.bind;
    exports ifml.player;
    opens ifml.player.view to javafx.fxml, javafx.web;
    opens ifml.core.xml to com.fasterxml.jackson.dataformat.xml;
}