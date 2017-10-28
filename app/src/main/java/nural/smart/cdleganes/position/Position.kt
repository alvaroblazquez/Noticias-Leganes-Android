package nural.smart.cdleganes.position

/**
* Created by alvaro on 26/10/17.
*/
data class Position (
            val position: Int,
            val teamName: String,
            val points: Int,
            val playedGames : Int,
            val wins        : Int,
            val draws       : Int,
            val losses      : Int
)