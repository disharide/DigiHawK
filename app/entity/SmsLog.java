package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.Model;

@Entity
@Table(name = "SMS_LOG")
public class SmsLog extends RootEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "PHONE_NUMBER")
	public String phoneNumber;

	@Column(columnDefinition = "TEXT")
	public String text;

	public CommunicationType type;

	public CommunicationStatus status;

	@ManyToOne
	public ChildUser user;

	@Column(name = "TIME_IN_MILLIS")
	public Long timeInMillis;

	public static Model.Finder<Long, SmsLog> find = new Finder<>(SmsLog.class);

}
