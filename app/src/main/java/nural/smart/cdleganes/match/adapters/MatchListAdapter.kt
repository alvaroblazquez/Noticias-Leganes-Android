package nural.smart.cdleganes.match.adapters

/**
 * Created by alvaro on 22/10/17.
 */

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import nural.smart.cdleganes.R
import nural.smart.cdleganes.match.Match
import nural.smart.cdleganes.match.MatchList
import org.jetbrains.anko.find

class MatchListAdapter(val matchList: MatchList)
    : RecyclerView.Adapter<MatchListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bindMatch(matchList.fixtures[position])
    }

    override fun getItemCount(): Int = matchList.fixtures.size

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val homeTeamName = view.find<TextView>(R.id.homeTeamName)
        private val awayTeamName = view.find<TextView>(R.id.awayTeamName)

        fun bindMatch(match: Match) {
                homeTeamName.text = match.homeTeamName
                awayTeamName.text = match.awayTeamName
        }
    }
}