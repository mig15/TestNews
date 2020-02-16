package com.android.developer.tap2visittest.presentation.mvp.view.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.developer.tap2visittest.R
import com.android.developer.tap2visittest.common.MyApplication
import com.android.developer.tap2visittest.presentation.list.adapter.SingleRecyclerAdapter
import com.android.developer.tap2visittest.presentation.list.adapter.addPaginationListener
import com.android.developer.tap2visittest.presentation.list.items.AdapterItem
import com.android.developer.tap2visittest.presentation.list.renderer.RendererTopUSNews
import com.android.developer.tap2visittest.presentation.mvp.presenter.PresenterNews
import com.android.developer.tap2visittest.presentation.mvp.view.activity.MainActivity
import com.android.developer.tap2visittest.presentation.mvp.view.base.NewsMvp
import com.android.developer.tap2visittest.presentation.navigation.FragmentListener
import kotlinx.android.synthetic.main.fragment_news.*

class FragmentNews : Fragment(), NewsMvp {

    private lateinit var presenter: PresenterNews
    private lateinit var adapter: SingleRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = MyApplication.component.getPresenter()

        adapter = SingleRecyclerAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this)

        val mainActivity = activity as MainActivity

        mainActivity.setSupportActionBar(toolbar)
        mainActivity.supportActionBar?.title = "Top news"

        setHasOptionsMenu(true)

        recycler.adapter = adapter
        val layoutManager = LinearLayoutManager(context!!)
        recycler.layoutManager = layoutManager
        adapter.registerRenderer(RendererTopUSNews())
        recycler.addPaginationListener(layoutManager) {
            presenter.pagination()
        }

        presenter.viewReady()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.category_menu, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_all-> {
                presenter.reset()
                presenter.getNews(null)
                true
            }
            R.id.action_business -> {
                presenter.reset()
                presenter.getNews("business")
                true
            }
            R.id.action_entertainment -> {
                presenter.reset()
                presenter.getNews("entertainment")
                true
            }
            R.id.action_general -> {
                presenter.reset()
                presenter.getNews("general")
                true
            }
            R.id.action_health -> {
                presenter.reset()
                presenter.getNews("health")
                true
            }
            R.id.action_science -> {
                presenter.reset()
                presenter.getNews("science")
                true
            }
            R.id.action_sports -> {
                presenter.reset()
                presenter.getNews("sports")
                true
            }
            R.id.action_technology -> {
                presenter.reset()
                presenter.getNews("technology")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showNews(list: List<AdapterItem>) {
        adapter.notifyData(list)
    }

    override fun showAlert(title: String, msg: String) {
        val builder = AlertDialog.Builder(context!!)
        builder.setTitle(title)
        builder.setMessage(msg)
        builder.setPositiveButton("Ok") { dialog, id -> }
        builder.create().show()
    }

    override fun loading(loading: Boolean) {
        if (loading) progress.visibility = View.VISIBLE else progress.visibility = View.GONE
    }

    override fun addNews(list: List<AdapterItem>) {
        adapter.getData().addAll(list)
        adapter.notifyItemRangeInserted(adapter.getData().size, list.size)
    }

    override fun openDetail(url: String) {
        (activity as FragmentListener).openDetail(url)
    }

    override fun onDestroy() {
        presenter.unsubscribe()
        presenter.detachView()

        super.onDestroy()
    }
}