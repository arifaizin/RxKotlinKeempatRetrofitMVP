package id.hamasah.rxkotlinkeempat_retrofitrx

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.hamasah.rxkotlinkeempat_retrofitrx.model.ResultsItem
import kotlinx.android.synthetic.main.recycler_item.view.*

/**
 * Created by idn on 2/18/2018.
 */
class CustomAdapter (data : List<ResultsItem?>) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    // namaclass (namaconstructor : tipe data) : extend

    lateinit var listdata : List<ResultsItem?>

    init {
        listdata = data
    }


    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        //create member
        holder?.bind(listdata.get(position)!!)
        // change member ArrayList jadi User
    }

    override fun getItemCount(): Int {
        return listdata.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(view)
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(listdata: ResultsItem) {
            itemView.item_namabuah.text = listdata.name
            itemView.item_alamat.text = listdata.vicinity
            try{
                itemView.item_rating.rating = listdata.rating!!.toFloat()
            }catch(e : Exception){

            }
        }

    }
}