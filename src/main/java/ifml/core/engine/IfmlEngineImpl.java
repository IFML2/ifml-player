package ifml.core.engine;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ifml.core.IfmlOutputDevice;
import ifml.core.engine.model.Location;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class IfmlEngineImpl implements IfmlEngine {

    private static final Logger LOG = LoggerFactory.getLogger(IfmlEngineImpl.class);

    private IfmlOutputDevice outDevice;

    private SimpleObjectProperty<Location> location = new SimpleObjectProperty<>();

    public IfmlEngineImpl() {
        location.addListener(new ChangeListener<Location>() {

            @Override
            public void changed(ObservableValue<? extends Location> observable, Location oldValue, Location newValue) {
                showLocation(newValue);
            }

        });
    }

    public void registerOutDevice(final IfmlOutputDevice outDevice) {
        this.outDevice = outDevice;
    }

    @Override
    public void loadDictionary(final File file) {
        LOG.info("Loading dictionary... {}", file);
    }

    @Override
    public void loadStory(final File file) {
        LOG.info("Lodaing story... {}", file);
        showLocation(location.get());
    }

    @Override
    public void restart() {
        LOG.info("Restart current story...");
    }

    @Override
    public void saveGame(File file) {
        LOG.info("Save game to file {}...", file);
    }

    @Override
    public void loadGame(File file) {
        LOG.info("Load game from file {}...", file);
    }

    @Override
    public void parse(String command) {
        LOG.info("Parse command: {}...", command);
        outDevice.showText("Я не понимаю: '" + command + "'");
    }

    private void showLocation(final Location location) {
        if (outDevice != null) {
            outDevice.showLocation("-location name-", "-location description-");
        }
    }

}
