package nural.smart.cdleganes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import nural.smart.cdleganes.match.adapters.MatchListAdapter
import nural.smart.cdleganes.match.commands.RequestMatchCommand
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

/**
 * Created by alvaro on 22/10/17.
 */

class MatchActivity : AppCompatActivity() {

    private val listItems = listOf (
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)
        val matchList: RecyclerView = find(R.id.match_list)
        matchList.layoutManager = LinearLayoutManager(this)

        doAsync() {
            val result = RequestMatchCommand().execute()
            uiThread {
                matchList.adapter = MatchListAdapter(result)
                }
            }
    }
}

