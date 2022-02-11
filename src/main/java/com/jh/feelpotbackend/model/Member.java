package com.jh.feelpotbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "member")
public class Member {

  @Id
  @Column(name = "id")
  private String id;

  @Column(name = "name")
  private String name;

  @Column(name = "password")
  private String password;

  @Column(name = "birth")
  private Date birth;

  @Column(name = "is_male")
  private boolean isMale;

  @Column(name = "email")
  private String email;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "is_admin")
  private boolean isAdmin;

  public Member() {
  }

  public Member(String name, String password, Date birth, boolean isMale, String email, String phoneNumber, boolean isAdmin) {
    this.name = name;
    this.password = password;
    this.birth = birth;
    this.isMale = isMale;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.isAdmin = isAdmin;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public Date getBirth() {
    return birth;
  }

  public void setBirth(Date birth) {
    this.birth = birth;
  }

  public boolean getIsMale() {
    return isMale;
  }

  public void setIsMale(boolean isMale) {
    this.isMale = isMale;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public boolean getIsAdmin() {
    return isAdmin;
  }

  public void setIsAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;
  }
}
