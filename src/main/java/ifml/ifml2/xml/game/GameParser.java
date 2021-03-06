package ifml.ifml2.xml.game;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GameParser extends DefaultHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GameParser.class);
    private GameDTO gameDto;

    public GameDTO loadGame(final InputStream inputStream) {
        var factory = SAXParserFactory.newInstance();
        try {
            var parser = factory.newSAXParser();
            parser.parse(inputStream, this);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            LOG.error("Unable parse Library", ex);
        }
        return gameDto;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        //
    }

}
