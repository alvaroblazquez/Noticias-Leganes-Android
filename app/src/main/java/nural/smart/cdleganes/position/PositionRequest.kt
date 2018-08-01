package nural.smart.cdleganes.position

import com.google.gson.Gson
import nural.smart.cdleganes.match.MatchList
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by alvaro on 29/10/17.
 */
class PositionRequest {
    companion object {
        private val URLAPI      = "http://api.football-data.org/v2"
        private val IDCOMPETITION   = "2014"
        private val URLCOMPETITION    = "$URLAPI/competitions/$IDCOMPETITION/standings/"
    }

    fun execute(): Standings {
        val jsonStr = URL(URLCOMPETITION)

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
                return Gson().fromJson(response.toString(), Standings::class.java)
            }
        }
    }
}