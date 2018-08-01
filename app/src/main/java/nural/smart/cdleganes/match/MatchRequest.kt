package nural.smart.cdleganes.match

import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

/**
* Created by alvaro on 22/10/17.
*/


class MatchRequest {
    companion object {
        private val URLAPI     = "http://api.football-data.org/v2"
        private val IDTEAM     = "745"
        private val URLMATCHES = "$URLAPI/teams/$IDTEAM/matches/"
    }

    fun execute(): MatchList {
        val jsonStr = URL(URLMATCHES)

        with(jsonStr.openConnection() as HttpURLConnection) {
            requestMethod = "GET"
            addRequestProperty("X-Auth-Token", "297271fd514843ddaa3147f75a8fc12b")

            BufferedReader(InputStreamReader(inputStream)).use {
                val response = StringBuffer()

                var inputLine = it.readLine()
                while (inputLine != null) {
                    response.append(inputLine)
                    inputLine = it.readLine()
                }
                return Gson().fromJson(response.toString(), MatchList::class.java)
            }
        }
    }
}