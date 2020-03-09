package com.spring.users.model;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "logins")
public class Logins {

    private Long id;
    private String ip;
    private String browser;
    private int success;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date dateofinsert;
    private Users users;

    public Logins() {}

    public Logins(String ip, String browser, int success, Users users) {
        super();
        this.ip = ip;
        this.browser = browser;
        this.success = success;
        this.users = users;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Column(name = "browser")
    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    @Column(name = "success")
    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    @Column(name = "dateofinsert")
    public Date getDateofinsert() {
        return this.dateofinsert;
    }

    public void setDateofinsert(Date dateofinsert) {
        this.dateofinsert = dateofinsert;
    }

    @ManyToOne
    @JoinColumn(name = "users_id")
    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

}
