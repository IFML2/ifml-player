package ifml.core.engine.model.saved;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class SavedRole implements Serializable {

    /** Current object version for serialization. */
    private static final long serialVersionUID = 1L;

    @XmlAttribute(name = "name")
    private String name;
    @XmlElementWrapper(name = "props")
    @XmlElement(name = "prop")
    private List<SavedProperty> properties = new ArrayList<>();

    public SavedRole() {}

    public SavedRole(final String name, final List<SavedProperty> properties) {
        this();
        this.name = name;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<SavedProperty> getProperties() {
        return properties;
    }

    public void setProperties(final List<SavedProperty> properties) {
        this.properties = properties;
    }

}
