package nural.smart.cdleganes.position

import com.google.gson.Gson
import java.net.URL

/**
 * Created by alvaro on 29/10/17.
 */
class PositionRequest {
    companion object {
        private val URLAPI      = "http://api.football-data.org/v1"
        private val IDCOMPETITION   = "455"
        private val URLCOMPETITION    = "$URLAPI/competitions/$IDCOMPETITION/leagueTable"
    }

    fun execute(): PositionList {
        val jsonStr = URL(URLCOMPETITION).readText()
        return Gson().fromJson(jsonStr, PositionList::class.java)
    }
}