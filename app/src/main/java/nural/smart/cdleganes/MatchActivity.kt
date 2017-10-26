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

