package com.example.ranielle.baronlogger.Network;

import com.example.ranielle.baronlogger.Model.Response;
import com.example.ranielle.baronlogger.Model.User;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

    public interface RetrofitInterface {


        @POST("authenticate")
        Observable<Response> login();

        @GET("users/{email}")
        Observable<User> getProfile(@Path("email") String email);

        @PUT("users/{email}")
        Observable<Response> changePassword(@Path("email") String email, @Body User user);

        @POST("users/{email}/password")
        Observable<Response> resetPasswordInit(@Path("email") String email);


}