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

	@Column(name = "SMS_TEXT", columnDefinition = "TEXT")
	public String text;

	@Column(name = "SMS_TYPE")
	public CommunicationType smsType;

	@ManyToOne
	public User user;

	@Column(name = "TIME_IN_MILLIS")
	public String timeInMillis;

	public static Model.Finder<Long, SmsLog> find = new Finder<>(SmsLog.class);

}
