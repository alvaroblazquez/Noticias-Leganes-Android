package nural.smart.cdleganes

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import nural.smart.cdleganes.match.adapters.MatchListAdapter
import nural.smart.cdleganes.match.commands.RequestMatchCommand
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

/**
* Created by alvaro on 22/10/17.
*/

class MatchActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {

    lateinit var swipeView: SwipeRefreshLayout
    lateinit var progressBar: ProgressBar
    lateinit var matchList: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)

        swipeView   = find(R.id.swipeMatch)
        progressBar = find(R.id.progressBarMatch)
        matchList   = find(R.id.listMatch)
        matchList.layoutManager = LinearLayoutManager(this)


        swipeView.setOnRefreshListener(this)

        loadData()


    }

    fun loadData() {

        doAsync() {
            val result = RequestMatchCommand().execute()
            uiThread {
                matchList.adapter = MatchListAdapter(result)
                progressBar.visibility = View.GONE
                swipeView.isRefreshing = false
            }
        }

    }


    override fun onRefresh() {
        swipeView.isRefreshing = true
        loadData()
    }
}

