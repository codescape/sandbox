#!/usr/bin/env groovy

@Grab('org.mortbay.jetty:jetty-embedded:6.1.26')
import org.mortbay.jetty.Server
import org.mortbay.jetty.servlet.*
import groovy.servlet.*

def startJetty() {
    def jetty = new Server(9090)
    def context = new Context(jetty, '/', Context.SESSIONS) // Allow sessions.
    context.resourceBase = '.' // Look in current dir for Groovy scripts.
    context.addServlet(GroovyServlet, '*.groovy') // All files ending with .groovy will be served.
    jetty.start()
}

println "Starting Jetty, press Ctrl+C to stop."
startJetty()
