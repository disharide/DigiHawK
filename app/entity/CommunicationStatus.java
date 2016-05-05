package entity;

import com.avaje.ebean.annotation.EnumValue;

public enum CommunicationStatus {

	@EnumValue("BLOCKED")
	BLOCKED, @EnumValue("ALLOWED")
	ALLOWED
}
