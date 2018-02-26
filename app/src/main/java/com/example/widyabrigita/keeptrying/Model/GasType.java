package com.example.widyabrigita.keeptrying.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by widyabrigita on 2/16/18.
 */

public class GasType {
  @SerializedName("tag_id")
  @Expose
  private String tagId;
  @SerializedName("gas_type_id")
  @Expose
  private String gasTypeId;
  @SerializedName("amount_lt")
  @Expose
  private String amountLt;

  public String getTagId() {
    return tagId;
  }

  public void setTagId(String tagId) {
    this.tagId = tagId;
  }

  public String getGasTypeId() {
    return gasTypeId;
  }

  public void setGasTypeId(String gasTypeId) {
    this.gasTypeId = gasTypeId;
  }

  public String getAmountLt() {
    return amountLt;
  }

  public void setAmountLt(String amountLt) {
    this.amountLt = amountLt;
  }
}
