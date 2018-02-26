package com.example.widyabrigita.keeptrying.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GasFiltered {
  @SerializedName("id")
  @Expose
  private String id;
  @SerializedName("station_name")
  @Expose
  private String stationName;
  @SerializedName("gas_type")
  @Expose
  private String gasType;
  @SerializedName("created_date")
  @Expose
  private String createdDate;
  @SerializedName("amount_rp")
  @Expose
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
