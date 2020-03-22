package com.spring.users.model;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.format.annotation.DateTimeFormat;
import com.spring.users.model.UsersAud;

@Entity
@Table(name = "users_aud")
public class UsersAud {

	private Integer rev;
	private Integer revtype;
	private Integer id;
	private String username;
	private String password;
	private Integer status;
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateofinsert;
	private Person person;

	public UsersAud() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rev", insertable = false, updatable = false, nullable = false)
	public Integer getRev() {
		return this.rev;
	}

	public void setRev(Integer rev) {
		this.rev = rev;
	}

	@Column(name = "revtype")
	public Integer getRevtype() {
		return this.revtype;
	}

	public void setRevtype(Integer revtype) {
		this.revtype = revtype;
	}

	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "dateofinsert")
	public Date getDateofinsert() {
		return this.dateofinsert;
	}

	public void setDateofinsert(Date dateofinsert) {
		this.dateofinsert = dateofinsert;
	}

	@ManyToOne
	@JoinColumn(name = "person_id")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
