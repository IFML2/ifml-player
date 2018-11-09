package ifml.ifml2.xml.libs;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class LibraryDTO implements Serializable {

    /** Object version for serialization */
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String name;
    private List<AttributeDefinitionDTO> attributeDefinitions;

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<AttributeDefinitionDTO> getAttributeDefinitions() {
        return attributeDefinitions;
    }

    public void setAttributeDefinitions(final List<AttributeDefinitionDTO> attributeDefinitions) {
        this.attributeDefinitions = attributeDefinitions;
    }

}
