package view

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.bindView
import com.taskmoney.R
import yandexMoney.model.Category
import java.util.ArrayList

class TreeAdapter() : RecyclerView.Adapter<TreeAdapter.ViewHolder>() {

    var categories: List<Category> = ArrayList<Category>()

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val category = categories.get(position)
        holder?.title?.setText(category.title)
        holder?.view?.setOnClickListener { view ->
            val context = view.getContext()

        // Create fragment and give it an argument specifying the category it should show
            val receiverFragment = SecondFragment()
            val args = Bundle()
            args.putInt("extra_position", position)
            receiverFragment.setArguments(args)

            val tran: FragmentTransaction = FirstFragment().getFragmentManager().beginTransaction() // ?
            tran.replace(R.id.flContainer, receiverFragment).addToBackStack(null).commit()

            //            val intent = Intent(context, javaClass<>)
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
