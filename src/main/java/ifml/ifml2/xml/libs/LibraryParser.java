package ifml.ifml2.xml.libs;

import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.UUID;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class LibraryParser extends DefaultHandler {

    private static final Logger LOG = LoggerFactory.getLogger(LibraryParser.class);

    private LibraryDTO libraryDto;

    public LibraryDTO loadLibrary(final InputStream inputStream) {
        var factory = SAXParserFactory.newInstance();
        try {
            var parser = factory.newSAXParser();
            parser.parse(inputStream, this);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            LOG.error("Unable parse Library", ex);
        }
        return libraryDto;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("library".equalsIgnoreCase(qName)) {
            if (libraryDto == null) {
                libraryDto = new LibraryDTO();
                libraryDto.setId(UUID.fromString(attributes.getValue("id")));
                libraryDto.setName(attributes.getValue("name"));
                
            } else {
                LOG.error("Duplicate root tag...");
            }
        } else if ("attribute-definitions".equalsIgnoreCase(qName)) {
            libraryDto.setAttributeDefinitions(new ArrayList<AttributeDefinitionDTO>());
        } else if ("attribute-definition".equalsIgnoreCase(qName)) {
            var attributeDef = new AttributeDefinitionDTO();
            attributeDef.setName(attributes.getValue("name"));
            attributeDef.setDescription(attributes.getValue("description"));
            libraryDto.getAttributeDefinitions().add(attributeDef);
        }
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
