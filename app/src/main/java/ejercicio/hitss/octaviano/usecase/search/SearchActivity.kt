package ejercicio.hitss.octaviano.usecase.search

import android.app.SearchManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ejercicio.hitss.octaviano.databinding.ActivitySearchBinding
import ejercicio.hitss.octaviano.usecase.common.SearchAdapter

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private val model: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.elevation = 0f
        handleSearchIntent(intent)
        onLoading()
        onSearch()
    }

    /**
     * Obtener la consulta de busqueda.
     */
    private fun handleSearchIntent(intent: Intent) {
        if (Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                model.search(query)
            }
        }
    }

    /**
     * Mostrar shimmer miestras se carga la información.
     */
    private fun onLoading() {
        model.loading.observe(this) { isLoading ->
            if (isLoading) {
                binding.tvProgramsList.showShimmer()
                return@observe
            }

            binding.tvProgramsList.hideShimmer()
        }
    }

    /**
     * Mostrar resultados de busqueda.
     */
    private fun onSearch() {
        model.searchResults.observe(this) { results ->
            binding.tvProgramsList.adapter = SearchAdapter(this, results)
        }
    }
}