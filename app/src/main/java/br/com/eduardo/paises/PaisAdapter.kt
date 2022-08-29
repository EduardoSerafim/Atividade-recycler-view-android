package br.com.eduardo.paises

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.eduardo.paises.databinding.ItemListaBinding
import br.com.eduardo.paises.model.Pais

class PaisAdapter : RecyclerView.Adapter<PaisAdapter.PaisHolder>() {
    val lista:MutableList<Pais> = mutableListOf()

    class PaisHolder(val itemListaView: ItemListaBinding): RecyclerView.ViewHolder(itemListaView.root){

        fun bind(pais: Pais){
            itemListaView.tvPais.text = pais.pais
            itemListaView.tvContinente.text = pais.continente
            when(pais.continente){
                "asia" -> itemListaView.ibIcone.setImageResource(R.drawable.ic_baseline_calculate_24)
                "america" -> itemListaView.ibIcone.setImageResource(R.drawable.ic_baseline_accessibility_24)
                "europa" -> itemListaView.ibIcone.setImageResource(R.drawable.ic_baseline_5g_24)
                "oceania" -> itemListaView.ibIcone.setImageResource(R.drawable.ic_baseline_add_ic_call_24)
                "africa" -> itemListaView.ibIcone.setImageResource(R.drawable.ic_baseline_wifi_off_24)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaisHolder {
       return PaisHolder(
            ItemListaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
       )
    }

    override fun onBindViewHolder(holder: PaisHolder, position: Int) {
        holder.bind(lista[position])
        holder.itemListaView.ibClose.setOnClickListener{
            removeItem(lista[position])
        }
    }

    override fun getItemCount(): Int =  lista.size

    fun setLista(listaItem: MutableList<Pais>){
        lista.clear()
        lista.addAll(listaItem)
        notifyDataSetChanged()
    }

    fun addItem(newItem: Pais){
        lista.add(newItem)
        notifyItemInserted(lista.size)
    }

    fun removeItem(removed: Pais){
        val removedIndex = lista.indexOf(removed)
        lista.remove(removed)
        notifyItemRemoved(removedIndex)
        notifyItemRangeChanged(removedIndex, lista.size)
    }

}