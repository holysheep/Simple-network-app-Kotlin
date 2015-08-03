package taskmoney

import kotlinx.android.synthetic.main.*
import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.taskmoney.R

public class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        customText.setText("Test")
        toast("This is test message")
    }

    fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, duration).show()
    }
}
