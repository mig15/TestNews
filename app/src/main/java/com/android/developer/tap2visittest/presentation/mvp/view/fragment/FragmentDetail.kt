package com.android.developer.tap2visittest.presentation.mvp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.developer.tap2visittest.R
import kotlinx.android.synthetic.main.fragment_detail.*

class FragmentDetail : Fragment() {

    private var url: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        url = arguments?.getString("key")

        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webview.settings.javaScriptEnabled = true
        webview.loadUrl(url)
    }
}