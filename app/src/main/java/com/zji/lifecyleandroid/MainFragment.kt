package com.zji.lifecyleandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniOnClicks()
    }

    private fun iniOnClicks() {
        mStartActivityButton.setOnClickListener { startActivity() }
        mStartTransparentActivityButton.setOnClickListener { startTransparentActivity() }
        mStartDialogButton.setOnClickListener { startDialog() }
        mStartFragmentDialogButton.setOnClickListener { startDialogFragment() }
    }
}