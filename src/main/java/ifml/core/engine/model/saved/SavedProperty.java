package ifml.core.engine.model.saved;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class SavedProperty implements Serializable {

    /** Object version for serialization. */
    private static final long serialVersionUID = 1L;

    @XmlAttribute(name = "name")
    private String name;
    @XmlElement(name = "item")
    private List<String> items = new ArrayList<>();

    public SavedProperty() {}

    public SavedProperty(final String name, final List<String> items) {
        this();
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(final List<String> items) {
        this.items = items;
    }

}
