import com.neha.fabcoder.data.model.DrinksList
import retrofit2.http.GET
import java.util.*

//interface ApiService {
//
//    @GET("f=a")
//     fun getAllDrinks() : Call<List<DrinksList>>
//
//    companion object {
//
//        var retrofitService: ApiService? = null
//
//        fun getInstance() : ApiService {
//            if (retrofitService == null) {
//                val retrofit = Retrofit.Builder()
//                    .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/search.php?")
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//                retrofitService = retrofit.create(ApiService::class.java)
//            }
//            return retrofitService!!
//        }
//    }
//}
interface ApiService {

    @GET("f=a")
    suspend fun getAllDrinks(): List<DrinksList>

}