package view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import butterknife.bindView
import taskmoney.R
import yandexMoney.ApiController


public class MainActivity : AppCompatActivity() {

    val toolbar: Toolbar? by bindView(R.id.toolbar)
    val F_START = "StartKey"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        setSupportActionBar(toolbar)
        fetchData()
        //fragment
        //        val firstFragment : FirstFragment = FirstFragment?.Companion.newInstance()
        //        getSupportFragmentManager().beginTransaction().add(R.id.flContainer, firstFragment, F_START).commit()
    }

    fun fetchData() {
        Thread(Runnable {
            ApiController.restApi.getCategories()
            //            Handler().post(Runnable {
            //                val adapter = (recyclerView.getAdapter() as TreeAdapter)
            //                adapter.categories =
            //            })
        })
    }

}
