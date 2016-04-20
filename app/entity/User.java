package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.avaje.ebean.Model;

@Entity
@Table(name = "APP_USERS")
public class User extends RootEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "USER_NAME")
	public String name;

	@Column(unique = true, name = "EMAIL_ID")
	public String emailId;

	@Column(name = "PASSWORD")
	public String password;

	@Column(name = "USER_TYPE")
	public UserType userType;

	@OneToMany(cascade = CascadeType.ALL)
	public List<PhoneLog> phoneLogs;

	@OneToMany(cascade = CascadeType.ALL)
	public List<SmsLog> smsLogs;

	@OneToMany(cascade = CascadeType.ALL)
	public List<Location> locations;

	public static Model.Finder<Long, User> find = new Finder<>(User.class);

}
