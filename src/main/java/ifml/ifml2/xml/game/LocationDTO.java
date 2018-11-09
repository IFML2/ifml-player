package ifml.ifml2.xml.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LocationDTO implements Serializable {

    /** Object version for serialization. */
    private static final long serialVersionUID = 1L;

    private String id;
    private List<String> items = new ArrayList<>();

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
