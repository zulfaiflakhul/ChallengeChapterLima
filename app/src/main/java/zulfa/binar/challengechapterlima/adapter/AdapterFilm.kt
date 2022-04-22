package zulfa.binar.chapterlima

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_film.view.*
import zulfa.binar.challengechapterlima.R
import zulfa.binar.challengechapterlima.model.popular.GetPopularFilm

class AdapterFilm(private var onclick : (GetPopularFilm)->Unit) : RecyclerView.Adapter<AdapterFilm.ViewHolder>() {

    private var datafilm : List<GetPopularFilm>? = null

    fun setDataFilm(film : List<GetPopularFilm>){
        this.datafilm = film
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemview = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_film, parent, false)
        return ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_movie_title.text = datafilm!![position].results
    }

    override fun getItemCount(): Int {
        if (datafilm == null){
            return 0
        } else {
            return datafilm!!.size
        }
    }
}