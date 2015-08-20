package view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.bindView
import taskmoney.R
import yandexMoney.model.Category
import java.util.ArrayList

class TreeAdapter(context: Context) : RecyclerView.Adapter<TreeAdapter.ViewHolder>() {

    //    interface for clicks
    public interface OnClickEvent {
        public fun onClick(v: View, position: Int)
    }

    val context = context
    var categories: List<Category> = ArrayList<Category>()
    var clickEvent: OnClickEvent? = null


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val category = categories.get(position)
        holder?.title?.setText(category.title)

        holder?.itemView?.setOnClickListener { v ->
            clickEvent?.onClick(v, position)
            if (context is MainActivity)
                context.changeFragment(position)
        }
    }

    override fun getItemCount(): Int = categories.size()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        val view = LayoutInflater.from(parent?.getContext()).inflate(R.layout.row, parent, false)
        return ViewHolder(view)
    }

    public class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        public val title: TextView by bindView(R.id.categoryTitle)
    }
}
