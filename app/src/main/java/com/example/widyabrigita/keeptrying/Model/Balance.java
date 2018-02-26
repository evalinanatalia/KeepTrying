package com.example.widyabrigita.keeptrying.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Balance {
  @SerializedName("balance")
  @Expose
  private Integer balance;

  public Integer getBalance() {
    return balance;
  }

  public void setBalance(Integer balance) {
    this.balance = balance;
  }
}
