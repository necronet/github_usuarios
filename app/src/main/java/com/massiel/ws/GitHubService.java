package com.massiel.ws;

import retrofit.Call;
import retrofit.http.GET;

public interface GitHubService {
    @GET("/users/necronet")
    Call<Usuario> usuario();

}
