package com.geek.android3_hw2.data;

import android.util.Log;

import com.geek.android3_hw2.data.model.EachFilm;
import com.geek.android3_hw2.data.remote.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressWarnings("ALL")
public class FilmStorage {
    public void getFilm(String filmId, FilmCallback callback) {
        RetrofitBuilder.getInstance().getFilm(filmId).enqueue(new Callback<EachFilm>() {
            @Override
            public void onResponse(Call<EachFilm> call, Response<EachFilm> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.success(response.body());
                } else callback.onFailure("Request error");
            }

            @Override
            public void onFailure(Call<EachFilm> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());
            }
        });
    }

    public interface FilmCallback {
        void success(EachFilm film);

        default void onFailure(String errorMsg) {
            Log.e("TAG", "onFailure: " + errorMsg);
        }
    }
}
