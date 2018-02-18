package id.hamasah.kotlindayluassegitiga

import android.util.Log
import id.hamasah.kotlindaymvp.MainPresenter
import id.hamasah.kotlindaymvp.MainView
import id.hamasah.rxkotlinkeempat_retrofitrx.Network
import id.hamasah.rxkotlinkeempat_retrofitrx.model.ResponseServer
import id.hamasah.rxkotlinkeempat_retrofitrx.model.ResultsItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by idn on 2/17/2018.
 */
class MainPresenterImp : MainPresenter{


    var mainView : MainView? = null
    var data : ArrayList<ResultsItem>? = null


    constructor(mainView: MainView?) {
        this.mainView = mainView
        data = ArrayList()
    }
    override fun addList() {
        Network.service.getPlace()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {t: ResponseServer? ->
                            Log.d("data server", t?.results.toString())
//                            recycler.adapter = CustomAdapter(t?.results!!)
                            mainView?.sukses((t?.results as List<ResultsItem>?)!!)


                        },
                        {e ->
                            Log.d("data error", e.localizedMessage)
                            mainView?.gagal(e.toString())

                        })
    }
}