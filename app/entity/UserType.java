package entity;

import com.avaje.ebean.annotation.EnumValue;

public enum UserType {

	@EnumValue("PARENT")
	PARENT, @EnumValue("CHILD")
	CHILD
}
