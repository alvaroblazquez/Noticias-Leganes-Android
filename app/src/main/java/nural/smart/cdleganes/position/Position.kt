package nural.smart.cdleganes.position

import com.google.gson.annotations.SerializedName

/**
* Created by alvaro on 26/10/17.
*/
data class Position (
            val position: Int,
            val team: Team,
            val points: Int,
            val playedGames : Int,
            val wins        : Int,
            val draws       : Int,
            val losses      : Int
)

data class Standings(
        val standings: List<Table>
)

data class Table(
        val type: String,
        val table: List<Position>
)

data class Team(
        val name: String = ""
)