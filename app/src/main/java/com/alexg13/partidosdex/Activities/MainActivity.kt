package com.alexg13.partidosdex.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.alexg13.partidosdex.Adapter.PartidoAdapter
import com.alexg13.partidosdex.Entities.Partido
import com.alexg13.partidosdex.Fragments.ListFragmentActivity
import com.alexg13.partidosdex.R
import com.alexg13.partidosdex.ViewModel.PartidoViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mainFragment: ListFragmentActivity
    private lateinit var bookRepoViewModel: PartidoViewModel
    private lateinit var bookAdapter: PartidoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initMainFragment()

        /*bookAdapter = BooksAdapter(this, { partido: Partido -> triggerActivity(partido) })
        val recyclerView = findViewById<RecyclerView>(R.id.list_books)
        recyclerView.adapter = bookAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        bookRepoViewModel = ViewModelProviders.of(this).get(BookRepoViewModel::class.java)

        bookRepoViewModel.allPartidos.observe(this,androidx.lifecycle.Observer { books->
            books?.let{bookAdapter.setBooks(it)}
        })

        btnAgregar.setOnClickListener {
            var intent = Intent(this, NewMatchActivity::class.java)
            startActivity(intent)
        }*/
    }

    fun partidoFavorito(partido: Partido){

    }

    fun initMainFragment(){
        mainFragment = ListFragmentActivity()
        changeFragment(R.id.main_fragment,mainFragment)
    }

    fun triggerActivity(partido: Partido){
        val matchBundle = Bundle()
        matchBundle.putParcelable("partido",partido)
        startActivity(Intent(this, ViewMatchActivity::class.java).putExtras(matchBundle))
    }

    private fun changeFragment(id: Int, frag: Fragment){ supportFragmentManager.beginTransaction().replace(id, frag).commit() }






}
