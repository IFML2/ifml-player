package ifml.core.xml.libs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LibraryTests {

    @Test void testLoadingEmptyLibrary() throws IOException {
        var parser = new LibraryParser();
        var stream = new ByteArrayInputStream(
                ("<library id=\"b1711ca9-c5ba-47f5-92fe-4c5d5b9c6d6e\" name=\"TestLib\">"
               + "</library>").getBytes()
        );
        var library = parser.loadLibrary(stream);
        stream.close();
        Assertions.assertNotNull(library);
        Assertions.assertEquals(UUID.fromString("b1711ca9-c5ba-47f5-92fe-4c5d5b9c6d6e"), library.getId());
        Assertions.assertEquals("TestLib", library.getName());
    }

    @Test void testLoadingLibraryWithAttributeDefinitions() throws IOException {
        var parser = new LibraryParser();
        var stream = new ByteArrayInputStream(
                ("<library id=\"b1711ca9-c5ba-47f5-92fe-4c5d5b9c6d6e\" name=\"TestLib\">"
               + "  <attribute-definitions>"
               + "    <attribute-definition name=\"someProperty\" description=\"The long explain about property\"/>"
               + "    <attribute-definition name=\"theProperty\" description=\"something going wrange\"/>"
               + "  </attribute-definitions>"
               + "</library>").getBytes()
        );
        var library = parser.loadLibrary(stream);
        stream.close();
        Assertions.assertNotNull(library);
        Assertions.assertNotNull(library.getAttributeDefinitions());
        Assertions.assertEquals(2, library.getAttributeDefinitions().size());
    }

}
