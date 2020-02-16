package com.android.developer.tap2visittest.presentation.mvp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.developer.tap2visittest.R
import com.android.developer.tap2visittest.presentation.mvp.view.fragment.FragmentDetail
import com.android.developer.tap2visittest.presentation.mvp.view.fragment.FragmentNews
import com.android.developer.tap2visittest.presentation.navigation.FragmentListener
import com.android.developer.tap2visittest.presentation.navigation.FragmentNavigator

class MainActivity : AppCompatActivity(), FragmentListener {

    private val navigator = FragmentNavigator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigator.changeFragment(this, FragmentNews(), R.id.container)
    }

    override fun openDetail(url: String) {
        val bundle = Bundle()
        bundle.putString("key", url)

        val detailFragment = FragmentDetail()
        detailFragment.arguments = bundle
        navigator.addFragment(this, detailFragment, R.id.container, false)
    }
}
