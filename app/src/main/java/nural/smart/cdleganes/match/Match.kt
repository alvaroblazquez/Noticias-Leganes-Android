package nural.smart.cdleganes.match

/**
 * Created by alvaro on 13/10/17.
 */

enum class Status {
    OPENED, FINISHED
}

enum class Winner {
    HOME, AWAY, DRAW
}


data class Match(
        val date          : String?,
        val status        : Status?,
        val homeTeamName  : String = "",
        val awayTeamName  : String = "",
        val result        : Result?
    )

data class MatchList(val fixtures: List<Match>)

data class Result(val goalsHomeTeam : Int, val goalsAwayTeam: Int) {
    var winner: Winner = Winner.AWAY
        get() {
            if (this.goalsHomeTeam == this.goalsAwayTeam) {
                return Winner.DRAW
            }
            return if (this.goalsHomeTeam > this.goalsAwayTeam) Winner.HOME else Winner.AWAY
        }
}