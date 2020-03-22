package com.spring.users.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.format.annotation.DateTimeFormat;
import com.spring.users.model.Users;

@Audited
@Entity
@Table(name = "users")
public class Users {

	private Integer id;
	private String username;
	private String password;
	private Integer status;
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateofinsert;

	private Set<UsersRoles> usersRoles;
	private Person person;

	public Users() {
	}

	public Users(String username, String password, Integer status) {
		super();
		this.username = username;
		this.password = password;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotEmpty
	@Column(name = "username", nullable = false, unique = true)
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

	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@ManyToOne
	@JoinColumn(name = "person_id", nullable = false)
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@NotAudited
	@OneToMany(fetch = FetchType.EAGER)
	@Cascade({ CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinColumn(name = "roles_id")
	public Set<UsersRoles> getUsersRoles() {
		return usersRoles;
	}

	public void setUsersRoles(Set<UsersRoles> usersRoles) {
		this.usersRoles = usersRoles;
	}
}
