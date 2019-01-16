package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 create table das_user(
	id integer primary key,
	name varchar2(30),
	passwort varchar2(2500),
	email varchar2(50) unique
		);
 */

@Entity
@Table(name="das_user")
public class User implements Serializable {
	
	private static final long serialVersionUID = -8572770050861835613L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")
	@SequenceGenerator(name="user_seq", sequenceName="user_sequenz", allocationSize=1)
	@Column(name="id")
	private int userId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="passwort")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy = "owner", fetch=FetchType.EAGER)
	private List<Document> documents;
	
	@OneToMany(mappedBy = "grantee", fetch=FetchType.EAGER)
	private List<Permission> permissions;
	
	public User(){
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
