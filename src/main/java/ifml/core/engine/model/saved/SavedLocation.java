package ifml.core.engine.model.saved;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class SavedLocation implements Serializable {

    /** Current object version for serialization.  */
    private static final long serialVersionUID = 1L;

    @XmlAttribute(name = "id")
    private String id;
    @XmlElement(name = "item")
    private List<String> items = new ArrayList<>();

    public SavedLocation() {}

    public SavedLocation(final String id, final List<String> items) {
        this();
        this.id = id;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(final List<String> items) {
        this.items = items;
    }

}
