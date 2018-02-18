package id.hamasah.rxkotlinkeempat_retrofitrx

import id.hamasah.rxkotlinkeempat_retrofitrx.model.ResponseServer
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by idn on 2/18/2018.
 */
interface ApiService {

    @GET("json?location=-7.0511601,110.4321671&radius=500&type=restaurant&key=AIzaSyAlbGqrLs1wyzimUp2HGY3x7kAsIjqad3o")
    fun getPlace():Observable<ResponseServer>
}