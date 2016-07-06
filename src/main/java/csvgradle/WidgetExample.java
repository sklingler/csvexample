package csvgradle;

import java.io.Serializable;

public class WidgetExample implements Serializable {

	private static final long serialVersionUID = -1399584499871036375L;

	private int id;
	private String name;
	private String description;
	// private WidgetType widgetType;
	private Boolean isInactive;

	public WidgetExample(int id, String name, String description, Boolean isInactive) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.isInactive = isInactive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsInactive() {
		return isInactive;
	}

	public void setIsInactive(Boolean isInactive) {
		this.isInactive = isInactive;
	}

}
