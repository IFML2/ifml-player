package ifml.core.engine.model.saved;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class SavedVariable implements Serializable {

    /** Current version of object for serialization. */
    private static final long serialVersionUID = 1L;

    @XmlAttribute(name = "name")
    private String name;
    @XmlValue
    private String value;

    public SavedVariable() {}

    public SavedVariable(final String name, final String value) {
        this();
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

}
