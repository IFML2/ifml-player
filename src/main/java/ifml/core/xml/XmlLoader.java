package ifml.core.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

import ifml.core.xml.libs.LibraryDTO;
import ifml.core.xml.libs.LibraryParser;

public enum XmlLoader {
    INSTANCE;

    public LibraryDTO loadLibrary(final File file) {
        try (var is = new FileInputStream(file)) {
            return loadLibrary(is);
        } catch (IOException  ex) {
            //TODO: Log the error
        }
        return null;
    }

    public LibraryDTO loadLibrary(final InputStream inputStream) {
        var factory = SAXParserFactory.newInstance();
        try {
            var parser = factory.newSAXParser();
            parser.parse(inputStream, new LibraryParser());
        } catch (SAXException ex) {
            //TODO: Log the exception
        } catch (ParserConfigurationException e) {
            //TODO: Log the exception
        } catch (IOException e) {
            //TODO: Log the exception
        }
        return null;
    }

    private String inputStreamToString(final InputStream is) {
        var stringBuilder = new StringBuilder();
        String line;
        try(var bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
        return stringBuilder.toString();
    }


}
