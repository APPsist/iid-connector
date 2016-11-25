package de.appsist.service.iid.server.model;

/**
 * Enumeration for a activity types.
 * @author simon.schwantzer(at)im-c.de
 */
public enum Activity {
	MAIN,
	SIDE,
	UNKNOWN;
	
	public static Activity fromString(String textValue) throws IllegalArgumentException {
		return Activity.valueOf(textValue.toUpperCase());
	}
	
	@Override
	public String toString() {
		return this.name().toLowerCase();
	}

}
