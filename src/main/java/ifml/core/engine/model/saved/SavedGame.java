package ifml.core.engine.model.saved;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@XmlRootElement
public class SavedGame implements Serializable {

    /** Current object version for serialization. */
    private static final long serialVersionUID = 1L;

    @XmlAttribute(name = "story-id")
    private UUID storyID;
    @XmlAttribute(name = "story-file")
    private String storyFileName;
    @XmlElementWrapper(name = "global-vars")
    @XmlElement(name = "var")
    private List<SavedVariable> globalVars;
    @XmlElementWrapper(name = "system-vars")
    @XmlElement(name = "var")
    private List<SavedVariable> systemVars;
    @XmlElementWrapper(name = "inventory")
    @XmlElement(name = "item")
    private List<String> savedInventory;
    @XmlElementWrapper(name = "locations")
    @XmlElement(name = "loc")
    private List savedLocations;
    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
    private List savedItems;

}
