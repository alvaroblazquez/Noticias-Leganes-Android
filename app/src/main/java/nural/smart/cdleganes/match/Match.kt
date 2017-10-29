package nural.smart.cdleganes.match

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by alvaro on 13/10/17.
 */

enum class Status {
    OPENED, FINISHED, TIMED, SCHEDULED
}

enum class Winner {
    HOME, AWAY, DRAW
}


data class Match(
        val date          : String?,
        val status        : Status = Status.OPENED,
        val homeTeamName  : String = "",
        val awayTeamName  : String = "",
        val result        : Result = Result(0, 0)
    ) {
    var dateFormatted: String = ""
        get() {
            var dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            dateFormat.timeZone = TimeZone.getTimeZone("Etc/GMT")
            val dateMatch = dateFormat.parse(this.date)

            dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")
            return dateFormat.format(dateMatch)
        }
}

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