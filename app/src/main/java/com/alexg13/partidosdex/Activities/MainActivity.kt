package com.alexg13.partidosdex.Activities

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.alexg13.partidosdex.Adapter.PartidoAdapter
import com.alexg13.partidosdex.Entities.Partido
import com.alexg13.partidosdex.Fragments.ListFragmentActivity
import com.alexg13.partidosdex.Fragments.MainContentFragment
import com.alexg13.partidosdex.R
import com.alexg13.partidosdex.ViewModel.PartidoViewModel

class MainActivity : AppCompatActivity(),ListFragmentActivity.SearchNewPartidoListener {

    private lateinit var contentFragment: MainContentFragment
    private lateinit var mainFragment: ListFragmentActivity



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

    override fun manageLandscapeItemClick(partido: Partido) {
        contentFragment = MainContentFragment.newInstance(partido)
        changeFragment(R.id.land_main_cont_fragment,contentFragment)
    }

    fun initMainFragment(){
        mainFragment = ListFragmentActivity()
        val resource = if(resources.configuration.orientation== Configuration.ORIENTATION_PORTRAIT)
            R.id.main_fragment
        else{
            contentFragment = MainContentFragment.newInstance(Partido(0,"N/A","N/A",0,0,"N/A","N/A"))
            changeFragment(R.id.land_main_cont_fragment,contentFragment)
            R.id.land_main_fragment
        }
        changeFragment(resource,mainFragment)
    }



    private fun changeFragment(id: Int, frag: Fragment){ supportFragmentManager.beginTransaction().replace(id, frag).commit() }






}
