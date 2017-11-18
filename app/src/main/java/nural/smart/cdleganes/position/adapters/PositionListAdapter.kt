package nural.smart.cdleganes.position.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import nural.smart.cdleganes.R
import nural.smart.cdleganes.position.Position
import nural.smart.cdleganes.position.PositionList
import org.jetbrains.anko.find

/**
 * Created by alvaro on 18/11/17.
 */
class PositionListAdapter(val positionList: PositionList)
    : RecyclerView.Adapter<PositionListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_position, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindMatch(positionList.standing[position])
    }

    override fun getItemCount(): Int = positionList.standing.size

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val position = view.find<TextView>(R.id.position)
        private val teamName = view.find<TextView>(R.id.teamName)
        private val points = view.find<TextView>(R.id.points)
        private val playedGames = view.find<TextView>(R.id.playedGames)
        private val wins = view.find<TextView>(R.id.wins)
        private val draws = view.find<TextView>(R.id.draws)
        private val losses = view.find<TextView>(R.id.losses)

        fun bindMatch(positionModel: Position) {
            position.text = positionModel.position.toString()
            teamName.text = positionModel.teamName
            points.text = positionModel.points.toString()
            playedGames.text = positionModel.playedGames.toString()
            wins.text = positionModel.wins.toString()
            draws.text = positionModel.draws.toString()
            losses.text = positionModel.losses.toString()
        }
    }
}