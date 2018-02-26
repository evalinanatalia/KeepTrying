package com.example.widyabrigita.keeptrying.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile {
  @Expose
  private String name;
  @SerializedName("address")
  @Expose
  private String address;
  @SerializedName("phonenumber")
  @Expose
  private String phonenumber;
  @SerializedName("balance")
  @Expose
  private Integer balance;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhonenumber() {
    return phonenumber;
  }

  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }

  public Integer getBalance() {
    return balance;
  }

  public void setBalance(Integer balance) {
    this.balance = balance;
  }
}
