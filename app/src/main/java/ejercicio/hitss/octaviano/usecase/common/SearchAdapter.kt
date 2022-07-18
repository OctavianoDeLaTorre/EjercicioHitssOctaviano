package ejercicio.hitss.octaviano.usecase.common

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ejercicio.hitss.octaviano.databinding.TvProgramItemBinding
import ejercicio.hitss.octaviano.model.ScheduleElement
import ejercicio.hitss.octaviano.model.SearchResult
import ejercicio.hitss.octaviano.usecase.showdetails.TvShowDetailsActivity
import ejercicio.hitss.octaviano.utils.loadNetworkImage

/**
 * @param context Contexto para iniciar actividad de detalles del Show.
 * @param dataSet Lista de resultados de la busqued.
 */
class SearchAdapter(val context: Context, private val dataSet: List<SearchResult>) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            TvProgramItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size

    inner class ViewHolder(private val binding: TvProgramItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(element: SearchResult) {
            binding.textTitle.text = element.show.name
            binding.textNetworkName.text = element.show.network?.name
            binding.textDate.text = "${element.show.schedule.time} | ${element.show.schedule.days}"
            if (element.show.image != null)
                binding.image.loadNetworkImage(element.show.image.medium)

            binding.container.setOnClickListener {
                context.startActivity(Intent(context, TvShowDetailsActivity::class.java).also {
                    it.putExtra("idShow", element.show.id)
                })
            }
        }

    }
}