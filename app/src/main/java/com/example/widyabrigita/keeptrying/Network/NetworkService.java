package com.example.widyabrigita.keeptrying.Network;


import com.example.widyabrigita.keeptrying.Model.Balance;
import com.example.widyabrigita.keeptrying.Model.GasFiltered;
import com.example.widyabrigita.keeptrying.Model.GasType;
import com.example.widyabrigita.keeptrying.Model.Login;
import com.example.widyabrigita.keeptrying.Model.Profile;
import com.example.widyabrigita.keeptrying.Model.Track;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface NetworkService {

  @GET("polls.apiblueprint.org/v1/user/profile")
  Call<Profile> getProfile(
      @Header("Authorization") String credentials,
      @Header("Content-Type") String type);

  @POST("polls.apiblueprint.org/v1/user/profile")
  Call<Profile> postProfile(
      @Header("Authorization") String credentials,
      @Header("Content-Type") String type);

  @GET("polls.apiblueprint.org/v1/user/balance")
  Call<Balance> getBalance(
    @Header("Authorization") String credentials,
    @Header("Content-Type") String type);

  @POST("polls.apiblueprint.org/v1/user/balance")
  Call<Balance> postBalance(
      @Header("Authorization") String credentials,
      @Header("Pass-key") String passKey,
      @Header("Content-Type") String type);

  @POST("polls.apiblueprint.org/v1/login")
  Call<Login> postLogin(@Header("Authorization") String credentials);

  @GET("polls.apiblueprint.org/v1/makeorder")
  Call<GasType> getOrder(
      @Header("Client-ID") String clientId,
      @Header("Pass-key") String passKey,
      @Header("Content-Type") String type);

  @GET("polls.apiblueprint.org/v1/makeorder/error")
  Call<GasType> getOrderError(
      @Header("Client-ID") String clientId,
      @Header("Pass-key") String passKey,
      @Header("Content-Type") String type);

  @GET("/v1/history")
  Call<Track> getHistory(
      //@Header("Authorization") String credentials,
      //@Header("Content-Type") String  type);
  );

  @GET("/v1/history")
  Call<Track> getHistoryByDate(
          @Query("start") String start,
          @Query("end") String end
  );

//  @GET("polls.apiblueprint.org/v1/history?start="09/11/2017"&end="20/11/2017")

}
