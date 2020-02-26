package com.android.developer.news.presentation.mvp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.developer.news.R
import com.android.developer.news.common.MyApplication
import com.android.developer.news.presentation.mvp.view.fragment.FragmentDetail
import com.android.developer.news.presentation.mvp.view.fragment.FragmentNews
import com.android.developer.news.presentation.navigation.FragmentListener
import com.android.developer.news.presentation.navigation.FragmentNavigator

class MainActivity : AppCompatActivity(), FragmentListener {

    private lateinit var navigator: FragmentNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigator = MyApplication.component.getNavigator()

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
