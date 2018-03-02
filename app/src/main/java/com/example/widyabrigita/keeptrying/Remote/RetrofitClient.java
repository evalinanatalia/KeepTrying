package com.example.widyabrigita.keeptrying.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
  public static final String BASE_URL = "https://private-276a7f-pertaminago1.apiary-mock.com";
  private static Retrofit retrofit = null;
  public static Retrofit getClient() {
    if (retrofit==null) {
      retrofit = new Retrofit.Builder()
              .baseUrl(BASE_URL)
              .addConverterFactory(GsonConverterFactory.create())
              .build();
    }
    return retrofit;
  }
}