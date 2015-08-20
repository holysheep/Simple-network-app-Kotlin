package view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import taskmoney.R

public class SecondFragment : Fragment() {

    companion object {
        private val ARG_USERNAME = "arg_username"

        fun newInstance(position: Int): FirstFragment {
            val fragment = FirstFragment()
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

        if (getArguments() != null) {
            getArguments().getString(ARG_USERNAME)
        } else {
            IllegalAccessError("No username found")
        }
    }
}
