package android.app.com.leftrightmind.HomePage

import android.app.com.leftrightmind.Adapter.CustomAdapter
import android.app.com.leftrightmind.Global.LoginPref
import android.app.com.leftrightmind.Global.showToast
import android.app.com.leftrightmind.Login.LoginPresenter
import android.app.com.leftrightmind.Model.DashData
import android.app.com.leftrightmind.Model.DashResponse
import android.app.com.leftrightmind.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*







class MainActivity : AppCompatActivity(),HomeView {


    private lateinit var adapter: CustomAdapter
    private var itemList = arrayListOf<DashData>()
    private lateinit var presenter: HomePresenter
    private var loadmore = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Home Page"
        presenter = HomePresenter(this)
        println("${LoginPref.getAccessToken(this,"accessToken")} -- ")

        adapter = CustomAdapter(this@MainActivity, itemList, {
            println("Click ${it.lifelineDocuments[0]}")
        })
        recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        getAllData()

        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val lastVisiblePosition = layoutManager.findLastVisibleItemPosition()
                if (lastVisiblePosition == recyclerView.childCount) {
                    if (loadmore) {
                        loadmore = false
                        loadMore()
                    }
                }
            }
        })
    }
    private fun loadMore(){
        println("Load More")
        presenter.getDataListing("Bearer "+LoginPref.getAccessToken(this,"accessToken"),itemList.size)
    }
    private fun getAllData(){
        println("Token ${LoginPref.getAccessToken(this,"accessToken")}")
        presenter.getDataListing("Bearer "+LoginPref.getAccessToken(this,"accessToken"),0)
    }



    override fun responseError(msg: String) {
        showToast(msg)
    }

    override fun onSuccess(dashResponse: DashResponse) {
        itemList.addAll(dashResponse.data)
        adapter.notifyDataSetChanged()
        loadmore = true
    }
}
