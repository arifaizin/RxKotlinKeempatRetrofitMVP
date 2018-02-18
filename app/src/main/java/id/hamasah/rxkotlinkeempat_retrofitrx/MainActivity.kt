package id.hamasah.rxkotlinkeempat_retrofitrx

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import id.hamasah.kotlindayluassegitiga.MainPresenterImp
import id.hamasah.kotlindaymvp.MainView
import id.hamasah.rxkotlinkeempat_retrofitrx.model.ResultsItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    override fun gagal(data: String) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT)
    }

    override fun sukses(data: List<ResultsItem>) {
        recycler.adapter = CustomAdapter(data)
    }



    lateinit var presenter : MainPresenterImp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ganti newtwk dari class jadi object dulu
//        Network.service.getPlace()
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        {t: ResponseServer? ->
//                            Log.d("data server", t?.results.toString())
//                            recycler.adapter = CustomAdapter(t?.results!!)
//
//                        },
//                        {e -> Log.d("data error", e.localizedMessage) })

        var data = ArrayList<ResultsItem>()

        recycler.adapter = CustomAdapter(data)
        recycler.layoutManager = LinearLayoutManager(this)

        initPresenter()

        presenter.addList()
    }

    private fun initPresenter() {
        presenter = MainPresenterImp(this)

    }

}
