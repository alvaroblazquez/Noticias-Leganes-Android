package nural.smart.cdleganes.domain.commands

/**
 * Created by alvaro on 22/10/17.
 */
interface Command <out T> {
    fun execute(): T
}