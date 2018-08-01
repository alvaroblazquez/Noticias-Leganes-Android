package nural.smart.cdleganes

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import nural.smart.cdleganes.position.Standings
import nural.smart.cdleganes.position.adapters.PositionListAdapter
import nural.smart.cdleganes.position.commands.RequestPositionCommand
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

/**
 * Created by alvaro on 18/11/17.
 */
class PositionFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var swipeView: SwipeRefreshLayout
    private lateinit var progressBar: ProgressBar
    private lateinit var positionList: RecyclerView


    companion object {
        fun newInstance(): PositionFragment {
            return PositionFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState:Bundle?):View? {
        val view = inflater!!.inflate(R.layout.activity_position, container, false)

        swipeView   = view.find(R.id.swipePosition)
        progressBar = view.find(R.id.progressBarPosition)
        positionList   = view.find(R.id.listPosition)
        positionList.layoutManager = LinearLayoutManager(this.context)


        swipeView.setOnRefreshListener(this)

        loadData()

        return view
    }

    private fun loadData() {

        doAsync {
            val result = RequestPositionCommand().execute()
            uiThread {
                val table = result.standings.first { it.type == "TOTAL" }
                positionList.adapter = PositionListAdapter(table)
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