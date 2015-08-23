package view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import butterknife.bindView
import taskmoney.R
import view.fragments.FirstFragment
import view.fragments.SecondFragment


public class MainActivity : AppCompatActivity(), TreeAdapter.AdapterCallback {

    val toolbar: Toolbar? by bindView(R.id.toolbar)

    private val FG_MAINFRAG = "Main Page"
    private val FG_SECONDFRAG = "Second Page"

    override fun onCreate(savedInstanceState: Bundle?) {
        super<AppCompatActivity>.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        setSupportActionBar(toolbar)

        //set FirstFragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.flContainer, FirstFragment.newInstance(), FG_MAINFRAG).commit()
    }

    override fun onMethodCallback(position: Int) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.flContainer, SecondFragment.newInstance(position), FG_SECONDFRAG).commit()
    }

    override fun onBackPressed() {
        if (getSupportFragmentManager().findFragmentByTag(FG_SECONDFRAG) != null) {
            getSupportFragmentManager().popBackStack()
        } else {
            super<AppCompatActivity>.onBackPressed()
        }
    }
}
