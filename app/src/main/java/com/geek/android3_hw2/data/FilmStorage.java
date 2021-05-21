package com.geek.android3_hw2.data;

import android.util.Log;

import com.geek.android3_hw2.data.model.EachFilm;
import com.geek.android3_hw2.data.remote.RetrofitBuilder;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmStorage {
    public void getFilm(String filmId,FilmCallback callback){
        RetrofitBuilder.getInstance().getFilm(filmId).enqueue(new Callback<EachFilm>() {
            @Override
            public void onResponse(Call<EachFilm> call, Response<EachFilm> response) {
                if (response.isSuccessful() && response.body()!=null){
                    callback.success(response.body());
                }
                else callback.onFailure("Request error");
                Log.e("TAG", response.body().toString() );
                //  errorText.setText(response.body().getTitle());
            }

            @Override
            public void onFailure(Call<EachFilm> call, Throwable t) {
                //    errorText.setText(t.getMessage());
                callback.onFailure(t.getLocalizedMessage());
                Log.e("TAG", "onFailure: "+t.getMessage() );
                Log.e("TAG", "onFailure: "+ call.request() );
                Log.e("TAG", "onFailure: "+t.getCause() );
                Log.e("TAG", "onFailure: "+ Arrays.toString(t.getStackTrace()) );
            }
        });
    }

    public interface FilmCallback{
        void success(EachFilm film);
      default   void onFailure(String errorMsg){
          Log.e("TAG", "onFailure: "+errorMsg );
      }
    }
}
