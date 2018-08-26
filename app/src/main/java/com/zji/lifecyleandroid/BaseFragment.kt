package com.zji.lifecyleandroid

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment() {
    private fun tag() = "ZHENLEI"
    private fun reference(): String = "FRAGMENT: " + hashCode()

    // region Lifecycle

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.e(tag(), reference() + " onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(tag(), reference() + " onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e(tag(), reference() + " onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.e(tag(), reference() + " onViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.e(tag(), reference() + " onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        Log.e(tag(), reference() + " onViewStateRestored")
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onStart() {
        Log.e(tag(), reference() + " onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.e(tag(), reference() + " onResume")
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
        Log.e(tag(), reference() + " onPause")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e(tag(), reference() + " onSaveInstanceState")
    }

    override fun onStop() {
        super.onStop()
        Log.e(tag(), reference() + " onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(tag(), reference() + " onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(tag(), reference() + " onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e(tag(), reference() + " onDetach")
    }

    // endregion

    // region Methods

    protected fun startActivity() {
        startActivity(Intent(requireContext(), MainActivity::class.java))
    }

    protected fun startTransparentActivity() {
        startActivity(Intent(requireContext(), TransparentMainActivity::class.java))
    }

    protected fun startDialog() {
        AlertDialog.Builder(requireContext()).create()
            .apply {
                setTitle("hi")
                setMessage("this is my app")
                setButton(Dialog.BUTTON_POSITIVE, "Ok") { dialog, which -> dialog?.dismiss() }
                show()
            }

    }

    protected fun startDialogFragment() {
        BaseActivity.MyAlertDialogFragment.newInstance("Dialog fragment")
            .show(childFragmentManager, "MyAlertDialogFragment")
    }

    // endregion
}