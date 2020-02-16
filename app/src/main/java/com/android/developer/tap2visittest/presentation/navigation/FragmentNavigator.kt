package com.android.developer.tap2visittest.presentation.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class FragmentNavigator {

    //вычищаем backstack и добавлям новый фрагмент
    fun changeFragment(activity: FragmentActivity, fragment: Fragment, @IdRes id: Int) {
        val fm = activity.supportFragmentManager

        for (item in fm.fragments) {
            if (item != null) {
                fm.popBackStackImmediate()
            }
        }

        fm.transact {
            //setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            replace(id, fragment, fragment.javaClass.name)
        }
    }

    fun addFragment(activity: FragmentActivity, fragment: Fragment, @IdRes id: Int, animation: Boolean) {
        activity.supportFragmentManager.findFragmentById(id)?.onHiddenChanged(true)
        activity.supportFragmentManager.transact {
            if (animation) {
                //setCustomAnimations(R.anim.anim_in_fragment, R.anim.anim_out_fragment)
            }
            replace(id, fragment, fragment.javaClass.name)
            addToBackStack(fragment.javaClass.name)
        }
    }

    private inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
        beginTransaction().apply {
            action()
        }.commitAllowingStateLoss()
    }
}