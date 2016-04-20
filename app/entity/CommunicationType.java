package entity;

import com.avaje.ebean.annotation.EnumValue;

public enum CommunicationType {

	@EnumValue("OUTGOING")
	OUTGOING, @EnumValue("INCOMING")
	INCOMING
}
