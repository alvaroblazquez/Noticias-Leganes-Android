package nural.smart.cdleganes.position.commands

import nural.smart.cdleganes.domain.commands.Command
import nural.smart.cdleganes.position.PositionRequest
import nural.smart.cdleganes.position.Standings

/**
 * Created by alvaro on 18/11/17.
 */
class RequestPositionCommand : Command<Standings> {

    override fun execute(): Standings {
        val positionRequest = PositionRequest()
        return positionRequest.execute()
    }
}