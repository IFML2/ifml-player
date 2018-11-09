package ifml.ifml2.xml.game;

import java.io.Serializable;

public class VariableDTO implements Serializable {

    /** Object version for serialization */
    private static final long serialVersionUID = 1L;

    private String name;
    private String value;

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
