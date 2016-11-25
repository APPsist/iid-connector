package de.appsist.service.iid.server.model;

import org.vertx.java.core.json.JsonObject;

/**
 * Broadcast a appsist event.
 * @author simon.schwantzer(at)im-c.de
 */
public class AppsistEventAction extends Action {
	/**
	 * Creates a new action firing a appsist event.
	 * @param modelId Model of the APPsist event to instantiate.
	 * @param payload Payload for the event.
	 */
	public AppsistEventAction(String modelId, JsonObject payload) {
		super(new JsonObject());
		json.putString("type", "appsist-event");
		json.putString("model", modelId);
		json.putObject("payload", payload);
	}
	
	protected AppsistEventAction(JsonObject json) throws IllegalArgumentException {
		super(json);
		validateJson(json);
	}
	
	private static void validateJson(JsonObject json) throws IllegalArgumentException {
		if (json.getString("model") == null) throw new IllegalArgumentException("Missing appsist event model (model).");
	}
	
	@Override
	public Type getType() {
		return Type.APPSIST_EVENT;
	}
	
	/**
	 * Returns the event model.
	 * @return APPsist event model.
	 */
	public String getModel() {
		return json.getString("model");
	}
	
	/**
	 * Returns the payload to be published with the event.
	 * @return Event payload.
	 */
	public JsonObject getPayload() {
		return json.getObject("payload");
	}
	
	@Override
	public String getSessionId() {
		return json.getString("sessionId");
	}
	
	@Override
	public void setSessionId(String sessionId) {
		json.putString("sessionId", sessionId);
	}
	
	@Override
	public String getToken() {
		return json.getString("token");
	}
	
	@Override
	public void setToken(String token) {
		json.putString("token", token);
	}
}