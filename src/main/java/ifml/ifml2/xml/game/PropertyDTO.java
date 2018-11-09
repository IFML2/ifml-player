package ifml.ifml2.xml.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PropertyDTO implements Serializable {

    /** Object version for serialization. */
    private static final long serialVersionUID = 1L;

    private String name;
    private List<String> items = new ArrayList<>();

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
