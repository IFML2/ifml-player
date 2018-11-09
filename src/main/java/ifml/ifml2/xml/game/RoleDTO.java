package ifml.ifml2.xml.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RoleDTO implements Serializable {

    /** Object version for serialization. */
    private static final long serialVersionUID = 1L;

    private String name;
    private List<PropertyDTO> properties = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<PropertyDTO> getProperties() {
        return properties;
    }

    public void setProperties(final List<PropertyDTO> properties) {
        this.properties = properties;
    }

}
