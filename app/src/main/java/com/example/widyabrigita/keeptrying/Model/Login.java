package com.example.widyabrigita.keeptrying.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by widyabrigita on 2/16/18.
 */

public class Login {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phonenumber")
    @Expose
    private String phonenumber;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("access_token")
    @Expose
    private String access_token;
    @SerializedName("refresh_token")
    @Expose
    private String refresh_token;
    @SerializedName("token_type")
    @Expose
    private String token_type;
    @SerializedName("balance")
    @Expose
    private String balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type= token_type;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance= balance;
    }
}
