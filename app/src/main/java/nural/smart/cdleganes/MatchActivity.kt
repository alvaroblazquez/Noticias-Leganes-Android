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
import nural.smart.cdleganes.match.adapters.MatchListAdapter
import nural.smart.cdleganes.match.commands.RequestMatchCommand
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

/**
* Created by alvaro on 22/10/17.
*/

class MatchFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var swipeView: SwipeRefreshLayout
    private lateinit var progressBar: ProgressBar
    private lateinit var matchList: RecyclerView

    companion object {
        fun newInstance(): MatchFragment {
            return MatchFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                                     savedInstanceState:Bundle?):View? {
        val view = inflater!!.inflate(R.layout.activity_match, container, false)

        swipeView   = view.find(R.id.swipeMatch)
        progressBar = view.find(R.id.progressBarMatch)
        matchList   = view.find(R.id.listMatch)
        matchList.layoutManager = LinearLayoutManager(this.context)


        swipeView.setOnRefreshListener(this)

        loadData()

        return view
    }

    private fun loadData() {

        doAsync {
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

