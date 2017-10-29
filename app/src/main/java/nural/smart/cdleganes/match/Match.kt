package nural.smart.cdleganes.match

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
* Created by alvaro on 13/10/17.
*/

enum class Status {
    OPENED, FINISHED, TIMED, SCHEDULED
}

/*enum class Winner {
    HOME, AWAY, DRAW
}*/


data class Match(
        private val date          : String?,
        val status        : Status = Status.OPENED,
        val homeTeamName  : String = "",
        val awayTeamName  : String = "",
        val result        : Result = Result(0, 0)
    ) {
    var dateFormatted: String = ""
        get() {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())

            dateFormat.timeZone = TimeZone.getTimeZone("Etc/GMT")
            val dateMatch = dateFormat.parse(this.date)

            return DateFormat.
                    getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.FRANCE).
                    format(dateMatch)
        }
}

data class MatchList(val fixtures: List<Match>)

data class Result(val goalsHomeTeam : Int, val goalsAwayTeam: Int) {
    /*var winner: Winner = Winner.AWAY
        get() {
            if (this.goalsHomeTeam == this.goalsAwayTeam) {
                return Winner.DRAW
            }
            return if (this.goalsHomeTeam > this.goalsAwayTeam) Winner.HOME else Winner.AWAY
        }*/
}