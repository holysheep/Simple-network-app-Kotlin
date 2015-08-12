package view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.bindView
import com.taskmoney.R

public class FirstFragment : Fragment() {

    companion object {
        fun newInstance(): FirstFragment = FirstFragment()
    }

    val recyclerView: RecyclerView by bindView(R.id.categoriesList)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_first, container, false)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter: TreeAdapter = TreeAdapter()
        recyclerView.setAdapter(adapter)

        val layoutManager = LinearLayoutManager(getActivity()) //? this
        recyclerView.setLayoutManager(layoutManager)
    }
}
