package ejercicio.hitss.octaviano.provider.retrofit

import ejercicio.hitss.octaviano.BuildConfig
import ejercicio.hitss.octaviano.model.Cast
import ejercicio.hitss.octaviano.model.ScheduleElement
import ejercicio.hitss.octaviano.model.SearchResult
import ejercicio.hitss.octaviano.model.Show
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitClient {

    @GET("schedule")
    suspend fun getScheduleOf(
        @Query("country") country: String = "US",
        @Query("date") date: String,
    ): List<ScheduleElement>

    @GET("shows/{id}")
    suspend fun getShow(
        @Path("id") id: Long
    ): Show


    @GET("shows/{id}/cast")
    suspend fun getCast(
        @Path("id") id: Long
    ): List<Cast>


    @GET("search/shows")
    suspend fun search(
        @Query("q") query: String,
    ): List<SearchResult>

    companion object {
        fun getInstance(): RetrofitClient {
            val client = Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return client.create(RetrofitClient::class.java)
        }
    }
}