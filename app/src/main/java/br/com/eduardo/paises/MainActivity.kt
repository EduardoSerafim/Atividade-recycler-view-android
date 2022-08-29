package br.com.eduardo.paises

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.eduardo.paises.databinding.ActivityMainBinding
import br.com.eduardo.paises.model.Pais

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val lAdapter = PaisAdapter()
    var cont = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecycler()

    }

    private fun setupRecycler(){
        binding.rvListaPaises.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val l = mutableListOf<Pais>()
        l.add(Pais("Brasil", "america"))
        l.add(Pais("Japão", "asia"))
        l.add(Pais("Portugal", "europa"))
        l.add(Pais("Fiji", "oceania"))
        l.add(Pais("Chade", "africa"))
        lAdapter.setLista(l)
        binding.rvListaPaises.adapter = lAdapter

    }
}