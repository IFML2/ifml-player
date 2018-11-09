package ifml.ifml2.xml.libs;

import java.io.Serializable;

public class AttributeDefinitionDTO implements Serializable {

    /** Object version for Serialization. */
    private static final long serialVersionUID = 1L;

    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

}
