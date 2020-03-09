package com.spring.users.model;

import java.util.Set;
import java.util.Date;
import java.util.HashSet;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;
import com.spring.users.model.Users;

@Entity
@Table(name = "person")
public class Person {

    private Integer id;
    private String name;
    private String surname;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date dateofbirth;
    private String phone;
    private String address;
    private String town;
    private String country;
    private Integer status;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date dateofinsert;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date lastupdate;
    private Set<Users> usersSet = new HashSet<Users>(0);

    public Person() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname")
    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "dateofbirth")
    public Date getDateofbirth() {
        return this.dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    @Column(name = "phone")
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "address")
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "town")
    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Column(name = "country")
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return this.status;
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

    @Column(name = "lastupdate")
    public Date getLastupdate() {
        return this.lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", orphanRemoval = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    @Cascade({CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    public Set<Users> getUsersSet() {
        return this.usersSet;
    }

    public void setUsersSet(Set<Users> usersSet) {
        this.usersSet = usersSet;
    }

    /*
    @OneToMany
    @Cascade({CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "person_id")
    public Set<Users> getUsersSet() {
        return usersSet;
    }

    public void setUsers(Set<Users> usersSet) {
        this.usersSet = usersSet;
    }
*/
}
