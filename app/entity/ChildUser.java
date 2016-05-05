package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.avaje.ebean.Model;

@Entity
@Table(name = "child_users")
public class ChildUser extends RootEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String name;

	@Column(name = "nick_name")
	public String nickName;

	@Column(name = "app_unique_id", unique = true)
	public String appUniqueId;

	@ManyToOne
	public ParentUser parent;

	@OneToMany
	public List<SmsLog> smsRecord;

	@OneToMany
	public List<PhoneLog> callRecord;

	public static Model.Finder<Long, ChildUser> find = new Finder<>(
			ChildUser.class);

}
