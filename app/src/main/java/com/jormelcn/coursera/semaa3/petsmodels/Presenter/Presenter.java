package com.jormelcn.coursera.semaa3.petsmodels.Presenter;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.jormelcn.coursera.semaa3.petsmodels.Pet;
import com.jormelcn.coursera.semaa3.petsmodels.restApi.EndpointsApi;
import com.jormelcn.coursera.semaa3.petsmodels.restApi.PetResponse;
import com.jormelcn.coursera.semaa3.petsmodels.restApi.RestApiAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jormelcn on 26/06/16.
 */
public class Presenter {
    private MyView myView;
    private ArrayList<Pet> pets;

    public interface MyView{
        void mostrarPetList(ArrayList<Pet> pets);
    }

    public Presenter(MyView myView) {
        this.myView = myView;
        obtenerMediosRecientes();
    }

    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<PetResponse> petResponseCall = endpointsApi.getRecentMedia();

        petResponseCall.enqueue(new Callback<PetResponse>() {
            @Override
            public void onResponse(Call<PetResponse> call, Response<PetResponse> response) {
                PetResponse petResponse = response.body();
                pets = petResponse.getPets();
                mostrarPets();
            }

            @Override
            public void onFailure(Call<PetResponse> call, Throwable t) {
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });



    }

    private void mostrarPets() {
        myView.mostrarPetList(pets);
    }
}
