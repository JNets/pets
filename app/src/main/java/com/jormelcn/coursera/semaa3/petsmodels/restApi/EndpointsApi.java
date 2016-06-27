package com.jormelcn.coursera.semaa3.petsmodels.restApi;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jormelcn on 26/06/16.
 */
public interface EndpointsApi {
    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<PetResponse> getRecentMedia();
}
