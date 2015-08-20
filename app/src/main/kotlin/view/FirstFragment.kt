package view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.bindView
import log
import retrofit.Callback
import retrofit.RetrofitError
import retrofit.client.Response
import taskmoney.R
import yandexMoney.ApiController
import yandexMoney.model.Category


public class FirstFragment : Fragment() {

    companion object {
        fun newInstance(): FirstFragment = FirstFragment()
    }

    val recyclerView: RecyclerView by bindView(R.id.categoriesList)
    val adapter: TreeAdapter = TreeAdapter(getActivity())


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(getActivity())
        recyclerView.setLayoutManager(layoutManager)
        recyclerView.setAdapter(adapter)
        fetchData()
    }

    fun fetchData() {
        ApiController.restApi.getCategories(object : Callback<List<Category>> {
            override fun success(t: List<Category>?, response: Response?) {
                adapter.categories = t as List<Category>
                adapter.notifyDataSetChanged()
                log("f1", "success")
            }

            override fun failure(error: RetrofitError?) {
                log("main fragment", "callback failure")
            }
        })
    }
}
