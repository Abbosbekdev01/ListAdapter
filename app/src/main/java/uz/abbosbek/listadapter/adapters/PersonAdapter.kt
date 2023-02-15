package uz.abbosbek.listadapter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.abbosbek.listadapter.databinding.ItemRvBinding
import uz.abbosbek.listadapter.models.Person

class PersonAdapter: ListAdapter<Person, PersonAdapter.Vh>(MyDifUtils()) {

    class MyDifUtils: DiffUtil.ItemCallback<Person>(){
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.number == newItem.number
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem == newItem
        }
    }
    inner class Vh(val itemRv:ItemRvBinding):RecyclerView.ViewHolder(itemRv.root){
        fun onBind(person: Person){
            itemRv.tvName.text = person.name
            itemRv.tvNumber.text = person.number.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder:Vh, position: Int) {
        holder.onBind(getItem(position))
    }
}