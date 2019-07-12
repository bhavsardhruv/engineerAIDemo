package com.anthesis.assignment.utils;

import com.anthesis.assignment.model.Response;
import com.anthesis.assignment.model2.Hint;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebService {
    @GET("v1/search_by_date?")
    Call<Hint> getData(
            @Query("tags") String tags,
            @Query("page") int page
    );

}
