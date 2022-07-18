package ejercicio.hitss.octaviano.usecase.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ejercicio.hitss.octaviano.databinding.ChipItemBinding

/**
 * Adaptador para muestrar una lista de chips.
 *
 * @param strings Lista de objetos para mostrar en chips.
 */
class ChipsAdapter(private val strings: List<Any>) :
    RecyclerView.Adapter<ChipsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ChipItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(strings[position])
    }

    override fun getItemCount(): Int = strings.size

    inner class ViewHolder(private val binding: ChipItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(value: Any) {
            binding.chipGender.text = value.toString()
        }
    }

}