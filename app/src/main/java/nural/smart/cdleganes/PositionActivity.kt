package nural.smart.cdleganes

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import nural.smart.cdleganes.position.adapters.PositionListAdapter
import nural.smart.cdleganes.position.commands.RequestPositionCommand
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

/**
 * Created by alvaro on 18/11/17.
 */
class PositionActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var swipeView: SwipeRefreshLayout
    private lateinit var progressBar: ProgressBar
    private lateinit var positionList: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_position)

        swipeView   = find(R.id.swipePosition)
        progressBar = find(R.id.progressBarPosition)
        positionList   = find(R.id.listPosition)
        positionList.layoutManager = LinearLayoutManager(this)


        swipeView.setOnRefreshListener(this)

        loadData()


    }

    private fun loadData() {

        doAsync {
            val result = RequestPositionCommand().execute()
            uiThread {
                positionList.adapter = PositionListAdapter(result)
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