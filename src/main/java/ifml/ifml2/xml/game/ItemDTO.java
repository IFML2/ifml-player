package ifml.ifml2.xml.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ItemDTO implements Serializable {

    /** Object version for serialization. */
    private static final long serialVersionUID = 1L;

    private String id;
    private List<RoleDTO> roles = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(final List<RoleDTO> roles) {
        this.roles = roles;
    }

}
