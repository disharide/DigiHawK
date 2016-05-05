package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.avaje.ebean.Model;

@Entity
@Table(name = "parent_users")
public class ParentUser extends RootEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6345797510205805322L;

	@Column(name = "first_name")
	public String firstName;

	@Column(name = "last_name")
	public String lastName;

	@Column(unique = true, name = "email_id")
	public String emailId;

	@Column(unique = true, name = "mobile_number")
	public Long mobileNo;

	public String password;

	@OneToMany
	public List<ChildUser> children;

	public static Model.Finder<Long, ParentUser> find = new Finder<>(
			ParentUser.class);

}
