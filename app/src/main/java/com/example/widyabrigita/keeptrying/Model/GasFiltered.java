package com.example.widyabrigita.keeptrying.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GasFiltered {
  @SerializedName("id")
  private String id;
  @SerializedName("station_name")
  private String stationName;
  @SerializedName("gas_type")
  private String gasType;
  @SerializedName("created_date")
  private String createdDate;
  @SerializedName("amount_rp")
  private Integer amountRp;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getStationName() {
    return stationName;
  }

  public void setStationName(String stationName) {
    this.stationName = stationName;
  }

  public String getGasType() {
    return gasType;
  }

  public void setGasType(String gasType) {
    this.gasType = gasType;
  }

  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public Integer getAmountRp() {
    return amountRp;
  }

  public void setAmountRp(Integer amountRp)  {
    this.amountRp = amountRp;
  }
}
