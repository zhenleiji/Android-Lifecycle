package com.zji.lifecyleandroid

import android.os.Bundle
import android.view.View
import com.zji.lifecyleandroid.R.id.mFragmentContentFrameLayout

class TransparentMainActivity : BaseActivity() {

    fun onStartActivity(view: View) {
        startActivity()
    }

    fun onStartTransparentActivity(view: View) {
        startTransparentActivity()
    }

    fun onStartFragment(view: View) {
        startFragment(mFragmentContentFrameLayout)
    }

    fun onStartRetainFragment(view: View) {
        startRetainFragment(mFragmentContentFrameLayout)
    }

    fun onStartDialog(view: View) {
        startDialog()
    }

    fun onStartDialogFragment(view: View) {
        startDialogFragment()
    }

    // region Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}