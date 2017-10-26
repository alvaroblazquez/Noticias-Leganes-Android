package nural.smart.cdleganes.match

import com.google.gson.Gson
import java.net.URL

/**
 * Created by alvaro on 22/10/17.
 */


class MatchRequest () {
    companion object {
        private val URLAPI      = "http://api.football-data.org/v1"
        private val IDTEAM   = "745"
        //static let IdLeague = "455"
        private val URLMATCHES    = URLAPI + "/teams/" + IDTEAM + "/fixtures"
    }

    fun execute(): MatchList {
        val jsonStr = URL(URLMATCHES).readText()
        return Gson().fromJson(jsonStr, MatchList::class.java)
    }


}