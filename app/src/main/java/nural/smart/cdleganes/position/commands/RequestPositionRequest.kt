package nural.smart.cdleganes.position.commands

import nural.smart.cdleganes.domain.commands.Command
import nural.smart.cdleganes.position.PositionList
import nural.smart.cdleganes.position.PositionRequest

/**
 * Created by alvaro on 18/11/17.
 */
class RequestPositionCommand : Command<PositionList> {

    override fun execute(): PositionList {
        val positionRequest = PositionRequest()
        return positionRequest.execute()
    }
}