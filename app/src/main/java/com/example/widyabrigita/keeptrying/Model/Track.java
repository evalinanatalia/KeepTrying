package com.example.widyabrigita.keeptrying.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by BRI on 2/28/2018.
 */

public class Track {
    @SerializedName("success")
    private String success;
    @SerializedName("data")
    private List<GasFiltered> data;


    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<GasFiltered> getData() {
        return data;
    }

    public void setData(List<GasFiltered> data) {
        this.data = data;
    }

}

