package nural.smart.cdleganes.match.commands

import nural.smart.cdleganes.domain.commands.Command
import nural.smart.cdleganes.match.MatchList
import nural.smart.cdleganes.match.MatchRequest

/**
 * Created by alvaro on 22/10/17.
 */
class RequestMatchCommand : Command<MatchList> {

    override fun execute(): MatchList {
        val matchRequest = MatchRequest()
        return matchRequest.execute()
    }
}