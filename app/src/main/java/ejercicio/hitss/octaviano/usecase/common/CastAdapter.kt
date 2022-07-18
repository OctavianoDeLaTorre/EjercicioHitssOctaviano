package ejercicio.hitss.octaviano.usecase.common

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ejercicio.hitss.octaviano.databinding.TalentItemBinding
import ejercicio.hitss.octaviano.model.Cast
import ejercicio.hitss.octaviano.utils.loadNetworkImage

class CastAdapter(context: Context, private val cast: List<Cast>) :
    RecyclerView.Adapter<CastAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            TalentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cast[position])
    }

    override fun getItemCount(): Int = cast.size

    inner class ViewHolder(private val binding: TalentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cast: Cast) {
            cast.person.image?.let { binding.image.loadNetworkImage(it.medium) }
            binding.textTalentName.text = cast.person.name
        }
    }
}