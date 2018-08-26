package com.zji.lifecyleandroid

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu

abstract class BaseActivity : AppCompatActivity() {
    private fun tag() = "ZHENLEI"
    private fun reference(): String = "ACTIVITY: " + hashCode()

    // region Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(tag(), reference() + " onCreate")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(tag(), reference() + " onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.e(tag(), reference() + " onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e(tag(), reference() + " onResume")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e(tag(), reference() + " onRestoreInstanceState")
    }

    override fun onPostResume() {
        super.onPostResume()
        Log.e(tag(), reference() + " onPostResume")
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.e(tag(), reference() + " onAttachedToWindow")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
        Log.e(tag(), reference() + " onCreateOptionsMenu")
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        return super.onPrepareOptionsMenu(menu)
        Log.e(tag(), reference() + " onPrepareOptionsMenu")
    }

    override fun onPause() {
        Log.e(tag(), reference() + " onPause")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        Log.e(tag(), reference() + " onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onStop() {
        Log.e(tag(), reference() + " onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.e(tag(), reference() + " onDestroy")
        super.onDestroy()
    }
    // endregion

    // region Methods

    protected fun startActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    protected fun startTransparentActivity() {
        startActivity(Intent(this, TransparentMainActivity::class.java))
    }

    protected fun startFragment(contentId: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(contentId, MainFragment(), reference())
            .addToBackStack(null)
            .commit()
    }

    protected fun startRetainFragment(contentId: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(contentId, RetainMainFragment(), reference())
            .addToBackStack(null)
            .commit()
    }

    protected fun startDialog() {
        AlertDialog.Builder(this).create()
            .apply {
                setTitle("hi")
                setMessage("this is my app")
                setButton(Dialog.BUTTON_POSITIVE, "Ok") { dialog, which -> dialog?.dismiss() }
                show()
            }

    }

    protected fun startDialogFragment() {
        MyAlertDialogFragment.newInstance("Dialog fragment")
            .show(supportFragmentManager, "MyAlertDialogFragment")
    }

    // endregion

    class MyAlertDialogFragment : DialogFragment() {
        companion object {
            fun newInstance(title: String): MyAlertDialogFragment {
                val dialogFrag = MyAlertDialogFragment()
                dialogFrag.arguments = Bundle()
                    .apply {
                        putString("title", title)
                    }
                return dialogFrag
            }
        }

        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
            AlertDialog.Builder(requireContext())
                .setTitle(arguments?.getString("title"))
                .setMessage("Are you sure?")
                .setPositiveButton(
                    "OK"
                ) { dialog, _ -> dialog?.dismiss() }
                .setNegativeButton(
                    "Cancel"
                ) { dialog, _ -> dialog?.dismiss() }
                .create()
    }
}