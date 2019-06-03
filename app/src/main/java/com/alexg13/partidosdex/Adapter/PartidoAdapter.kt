package com.alexg13.partidosdex.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexg13.partidosdex.Entities.Partido
import com.alexg13.partidosdex.R
import kotlinx.android.synthetic.main.cardview_book.view.*

class PartidoAdapter internal  constructor(context: Context, val clickListenerBoton: (Partido) -> Unit ) : RecyclerView.Adapter<PartidoAdapter.ViewHolder>() {
    private var partidos: List<Partido> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_book, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = partidos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(partidos[position], clickListenerBoton)

    internal fun setpartidos(partidos: List<Partido>) {
        this.partidos = partidos
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(book: Partido, clickListenerBoton: (Partido) -> Unit) = with(itemView) {
            /*Glide.with(itemView.context)
                .load(book.equipo1)
                .placeholder(R.drawable.ic_launcher_background)
                .into(Iv_book_portada)*/
            Tv_book_name.text = book.equipo1+"   VS   "+book.equipo2
            this.setOnClickListener{
                clickListenerBoton(book)
            }
        }
    }
}