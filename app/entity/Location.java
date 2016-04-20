package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.avaje.ebean.Model;

@Entity
public class Location extends RootEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String latitude;

	public String longitude;

	@ManyToOne
	public User user;

	@Column(name = "TIME_IN_MILLIS")
	public String timeInMillis;

	public static Model.Finder<Long, Location> find = new Finder<>(
			Location.class);

}
