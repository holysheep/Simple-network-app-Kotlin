package view.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.bindView
import taskmoney.R
import view.TreeAdapter
import yandexMoney.model.Category
import java.util.ArrayList

public class SecondFragment : Fragment() {

    val recyclerView: RecyclerView by bindView(R.id.categoriesList)
    var adapter: TreeAdapter? = null

    companion object {
        private val ARG_USERNAME = "arg_username"
        var categories: List<Category> = ArrayList<Category>()

        fun newInstance(position: Int): SecondFragment {
            val fragment = SecondFragment()
            val args = Bundle()
            args.putInt(ARG_USERNAME, position)
            fragment.setArguments(args)
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(getActivity())
        recyclerView.setLayoutManager(layoutManager)

        adapter = TreeAdapter(getActivity())
        recyclerView.setAdapter(adapter)

        if (getArguments() != null) {
            getArguments().getInt(ARG_USERNAME)
        } else {
            IllegalAccessError("No username found")
        }
    }
}
