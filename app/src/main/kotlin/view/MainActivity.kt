package view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import butterknife.bindView
import taskmoney.R


public class MainActivity : AppCompatActivity() {

    val toolbar: Toolbar? by bindView(R.id.toolbar)

    private val FG_REGISTRATION_TAG = "Registration"
    private val FG_CHAT_ROOM_TAG = "ChatRoom"

    override fun onCreate(savedInstanceState: Bundle?) {
        super<AppCompatActivity>.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        setSupportActionBar(toolbar)

        //set FirstFragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.flContainer, FirstFragment.newInstance(), FG_REGISTRATION_TAG).commit()

    }

    fun changeFragment(position: Int) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.flContainer, SecondFragment.newInstance(position), FG_CHAT_ROOM_TAG).commit()
    }

    override fun onBackPressed() {
        if (getSupportFragmentManager().findFragmentByTag(FG_CHAT_ROOM_TAG) != null) {
            getSupportFragmentManager().popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}
