package ejercicio.hitss.octaviano.usecase.home

import android.app.SearchManager
import android.content.ComponentName
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.activity.viewModels
import ejercicio.hitss.octaviano.R
import ejercicio.hitss.octaviano.databinding.ActivityMainBinding
import ejercicio.hitss.octaviano.usecase.common.TvProgramsAdapter
import ejercicio.hitss.octaviano.usecase.search.SearchActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val model: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.elevation = 0f
        setTitle()
        onLoading()
        initTvProgramsList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        //Configurar SearchView en ActionBar
        val sm = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView =
            menu.findItem(R.id.search).actionView as androidx.appcompat.widget.SearchView
        searchView.setSearchableInfo(
            sm.getSearchableInfo(
                ComponentName(this, SearchActivity::class.java)
            )
        )
        return true
    }

    /**
     * Mostrar fecha actual como titulo.
     */
    private fun setTitle() {
        model.dateFormated.observe(this) { date ->
            binding.textCurrentDate.text = date
        }
    }

    /**
     * Mostrar shimmer miestras se carga la información.
     */
    private fun onLoading() {
        model.loading.observe(this) { isLoading ->
            if (isLoading)
                binding.tvProgramsList.showShimmer()
            else
                binding.tvProgramsList.hideShimmer()
        }
    }

    /**
     * Configurar la lista de programas para mostrar resultados.
     */
    private fun initTvProgramsList() {
        model.tvPrograms.observe(this) {
            binding.tvProgramsList.adapter = TvProgramsAdapter(this, it)
        }
    }
}