package com.techcrunch.crunchynews.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.techcrunch.crunchynews.R
import com.techcrunch.crunchynews.model.ApiService
import com.techcrunch.crunchynews.model.ArticlesModel
import com.techcrunch.crunchynews.model.Network
import com.techcrunch.crunchynews.model.ResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class NewsActivity : AppCompatActivity(), ItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var progressBar: ProgressBar
    private var articlesList: List<ArticlesModel> = ArrayList<ArticlesModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)
        setAdapter()
        callApi()
    }

    private fun setAdapter() {
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        newsAdapter = NewsAdapter(articlesList, this)
        recyclerView.adapter = newsAdapter
    }

    private fun callApi() {
        val apiService = Network.getRetrofitInstance().create(ApiService::class.java)
        apiService.getNewsData().enqueue(object : Callback<ResponseModel> {
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                progressBar.visibility = GONE
                newsAdapter.updateData(response.body()?.articles as List<ArticlesModel>)
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Toast.makeText(
                    applicationContext, "Failed to fetch the data!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    override fun onItemClicked(model: ArticlesModel, position: Int) {
        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("url", model.url)
        startActivity(intent)
        // Open news in browser
        // startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(model.url)))
    }
}