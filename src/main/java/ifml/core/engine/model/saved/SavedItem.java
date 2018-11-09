package ifml.core.engine.model.saved;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class SavedItem implements Serializable {

    /** Current object version for serialization. */
    private static final long serialVersionUID = 1L;

    @XmlAttribute(name = "id")
    private String id;
    @XmlElementWrapper(name = "roles")
    @XmlElement(name = "role")
    private List<SavedRole> roles = new ArrayList<>();

    public SavedItem() {}

    public SavedItem(final String id, final List<SavedRole> roles) {
        this();
        this.id = id;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public List<SavedRole> getRoles() {
        return roles;
    }

    public void setRoles(final List<SavedRole> roles) {
        this.roles = roles;
    }

}
