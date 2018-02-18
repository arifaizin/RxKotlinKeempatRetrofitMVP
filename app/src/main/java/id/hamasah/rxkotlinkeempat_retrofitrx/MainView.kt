package id.hamasah.kotlindaymvp

import id.hamasah.rxkotlinkeempat_retrofitrx.model.ResultsItem


/**
 * Created by idn on 2/17/2018.
 */
interface MainView {
    fun sukses(data : List<ResultsItem>)

    fun gagal(data : String)
}