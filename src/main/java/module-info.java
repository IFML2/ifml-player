module ifml.player {
    requires javafx.base;
    requires javafx.controls;
    requires transitive javafx.graphics;
    requires javafx.fxml;
    requires javafx.web;
    requires org.slf4j;
    requires java.desktop;
    exports ifml.player;
    opens ifml.player.view to javafx.fxml;
}