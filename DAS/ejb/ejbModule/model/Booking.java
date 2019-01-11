package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
create table das_booking(
  id integer primary key,
  userid integer,
  datum date,
  subject varchar2(50),--new
  subjectID integer,--new
  operation varchar2(50) --new
);
 */

@Entity
@Table(name="das_booking")
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="boocking_seq")
	@SequenceGenerator(name="boocking_seq", sequenceName="boocking_sequenz", allocationSize=1)
	@Column(name="id")
	private int bookingId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="userid", nullable=false)
	private User userId;
	
	@Column(name="datum", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="subject", nullable=false)
	private String subject;
	
	@Column(name="subjectID", nullable=false)
	private int subjectId;

	@JoinColumn(name="operation", nullable=false)
	private String operation;
	
	public Booking() {
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
}
