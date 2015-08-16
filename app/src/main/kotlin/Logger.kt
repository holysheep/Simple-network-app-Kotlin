import android.app.Activity
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.util.Log
import view.TreeAdapter

public fun Activity.log (tag: String, message: String) {
    Log.i(tag, message)
}

public fun Fragment.log (tag: String, message: String) {
    Log.i(tag, message)
}

public fun RecyclerView.Adapter<TreeAdapter.ViewHolder>.log (tag: String, message: String) {
    Log.i(tag, message)
}