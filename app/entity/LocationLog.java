package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.Model;

@Entity
@Table(name = "location_log")
public class LocationLog extends RootEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String latitude;

	public String longitude;

	@ManyToOne
	public ChildUser user;

	@Column(name = "TIME_IN_MILLIS")
	public Long timeInMillis;

	public static Model.Finder<Long, LocationLog> find = new Finder<>(
			LocationLog.class);

}
