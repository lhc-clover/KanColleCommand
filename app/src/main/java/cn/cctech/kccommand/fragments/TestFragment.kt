package cn.cctech.kccommand.fragments

import android.os.Bundle
import android.widget.TextView

import cn.cctech.kccommand.R
import cn.cctech.kccommand.fragments.base.LazyFragment

class TestFragment : LazyFragment() {

    private var mIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mIndex = arguments?.getInt(ARG_INDEX) ?: 0
    }

    override fun onCreateViewLazy(savedInstanceState: Bundle) {
        super.onCreateViewLazy(savedInstanceState)
        setContentView(R.layout.fragment_test)

        val indexTextView = findViewById(R.id.tv_test_index) as TextView
        indexTextView.text = mIndex.toString()
    }

    companion object {

        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_INDEX = "index"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param index Index of this fragment
         * @return A new instance of fragment TestFragment.
         */
        fun newInstance(index: Int): TestFragment {
            val fragment = TestFragment()
            val args = Bundle()
            args.putInt(ARG_INDEX, index)
            fragment.arguments = args
            return fragment
        }
    }

}
