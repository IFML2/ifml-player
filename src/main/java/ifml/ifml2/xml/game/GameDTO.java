package ifml.ifml2.xml.game;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class GameDTO implements Serializable {

    /** Object version for serialization. */
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String name;
    private List<VariableDTO> globalVars;
    private List<VariableDTO> systemVars;
    private List<String> inventory;
    private List<LocationDTO> locations;
    private List<ItemDTO> items;

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<VariableDTO> getGlobalVars() {
        return globalVars;
    }

    public void setGlobalVars(final List<VariableDTO> globalVars) {
        this.globalVars = globalVars;
    }

    public List<VariableDTO> getSystemVars() {
        return systemVars;
    }

    public void setSystemVars(final List<VariableDTO> systemVars) {
        this.systemVars = systemVars;
    }

    public List<String> getInventory() {
        return inventory;
    }

    public void setInventory(final List<String> inventory) {
        this.inventory = inventory;
    }

    public List<LocationDTO> getLocations() {
        return locations;
    }

    public void setLocations(final List<LocationDTO> locations) {
        this.locations = locations;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(final List<ItemDTO> items) {
        this.items = items;
    }

}
