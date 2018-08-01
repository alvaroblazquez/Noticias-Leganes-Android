package nural.smart.cdleganes.match

import com.google.gson.annotations.SerializedName
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
        @SerializedName("utcDate")
        private val date  : String?,
        val status        : Status = Status.OPENED,
        val homeTeam  : Team,
        val awayTeam  : Team,
        val score        : Score
    ) {
    var dateFormatted: String = ""
        get() {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())

            dateFormat.timeZone = TimeZone.getTimeZone("Etc/GMT-1")
            val dateMatch = dateFormat.parse(this.date)

            return DateFormat.
                    getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.FRANCE).
                    format(dateMatch)
        }
}

data class MatchList(
        @SerializedName("matches")
        val fixtures: List<Match>
)

data class Team(
        val name: String = ""
)

data class Score (
        @SerializedName("fullTime")
        val result        : Result

)



data class Result(@SerializedName("homeTeam")
                    val goalsHomeTeam : Int,
                  @SerializedName("awayTeam")
                  val goalsAwayTeam: Int) {
    /*var winner: Winner = Winner.AWAY
        get() {
            if (this.goalsHomeTeam == this.goalsAwayTeam) {
                return Winner.DRAW
            }
            return if (this.goalsHomeTeam > this.goalsAwayTeam) Winner.HOME else Winner.AWAY
        }*/
}