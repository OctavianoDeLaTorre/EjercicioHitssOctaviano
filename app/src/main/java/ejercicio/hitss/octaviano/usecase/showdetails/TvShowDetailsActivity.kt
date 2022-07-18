package ejercicio.hitss.octaviano.usecase.showdetails

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ejercicio.hitss.octaviano.databinding.ActivityTvShowDetailsBinding
import ejercicio.hitss.octaviano.model.Show
import ejercicio.hitss.octaviano.usecase.common.CastAdapter
import ejercicio.hitss.octaviano.usecase.common.ChipsAdapter
import ejercicio.hitss.octaviano.utils.*
import okhttp3.internal.Util
import kotlin.properties.Delegates


class TvShowDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTvShowDetailsBinding

    private val model: ShowDetailsViewModel by viewModels()
    private var idShow by Delegates.notNull<Long>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTvShowDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.lockPortraitOrientation()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        onLoading()
        getIdShow()
        loadShowDetails()
        onLoadedShow()
        onLoadedCast()
    }

    /**
     * Mostrar shimmer miestras se carga la información.
     */
    private fun onLoading() {
        model.loading.observe(this) { isLoading ->
            if (isLoading) {
                binding.talentsList.showShimmer()
                binding.gendersList.showShimmer()
                binding.daysList.showShimmer()
                binding.shimmerViewContainer.startShimmer()
                return@observe
            }

            binding.talentsList.hideShimmer()
            binding.daysList.hideShimmer()
            binding.shimmerViewContainer.stopShimmer()
            binding.shimmerViewContainer.hideShimmer()
            binding.gendersList.hideShimmer()
        }
    }

    /**
     * Obtener id del show de los extras.
     */
    private fun getIdShow() {
        idShow = intent.extras?.getLong("idShow") ?: 0
    }

    /**
     * Obtener la información del show apartir de su id.
     */
    private fun loadShowDetails() {
        model.getShow(idShow)
        model.getCast(idShow)
    }

    /**
     * Mostrar la lista de actores.
     */
    private fun onLoadedCast() {
        model.cast.observe(this) { cast ->
            binding.talentsList.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.talentsList.adapter = CastAdapter(this, cast)
        }
    }

    /**
     * Mostrar los datos del show de tv.
     */
    private fun onLoadedShow() {
        model.show.observe(this) { show ->
            updateUI(show)
        }
    }

    private fun updateUI(show: Show) {
        if (show.image != null)
            binding.image.loadNetworkImage(show.image.medium)
        binding.textShowName.text = show.name
        binding.textNetworkName.text = show.network?.name ?: ""

        if (show.rating.average != null) {
            binding.textRating.text = "Rating: ${show.rating.average}"
            binding.ratingBar.rating = show.rating.average.toFloat() / 2
            binding.textRating.show()
            binding.ratingBar.show()
        } else {
            binding.textRating.hiden()
            binding.ratingBar.hiden()
        }

        binding.textSummary.text = show.summary.fromHtml()
        binding.chipTime.text = show.schedule.time
        binding.gendersList.initHorizontal()
        binding.gendersList.adapter = ChipsAdapter(show.genres)
        binding.daysList.initHorizontal()
        binding.daysList.adapter = ChipsAdapter(show.schedule.days)
        binding.buttonWebSite.setOnClickListener {
            show.officialSite?.let { url -> this.launchUrl(url) }
        }
    }

}