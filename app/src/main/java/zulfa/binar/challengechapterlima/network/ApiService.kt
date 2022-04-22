package zulfa.binar.challengechapterlima.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import zulfa.binar.challengechapterlima.model.popular.GetPopularFilm

interface ApiService {

    @GET("/3/movies/get-popular-movies")
    fun getPopularMovie() : Call<List<GetPopularFilm>>
}