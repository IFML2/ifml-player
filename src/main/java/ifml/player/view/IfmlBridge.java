package ifml.player.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bridge class to be able make Java up call from HTML page JavaScript.
 *
 * The bridge installed as object part of window (window.IFML) 
 */
public class IfmlBridge {

    private static final Logger LOG = LoggerFactory.getLogger(IfmlBridge.class);

    private final IfmlAdapter ifmlAdapter;

    public IfmlBridge(final IfmlAdapter ifmlAdapter) {
        this.ifmlAdapter = ifmlAdapter;
    }

    /**
     * Provided to JS function for parse strings.
     *
     * @param text the text for parsing
     */
    public void parse(final String text) {
        ifmlAdapter.parse(text);
    }

    /**
     * Add to log message provided by JS from page.
     *
     * @param text the message
     */
    public void log(final String text) {
        LOG.info("[JS-Bridge] Log: " + text);
    }

}
