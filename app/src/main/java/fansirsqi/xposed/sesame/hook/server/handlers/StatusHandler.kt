package fansirsqi.xposed.sesame.hook.server.handlers

import fansirsqi.xposed.sesame.hook.ModuleStatusReporter
import fi.iki.elonen.NanoHTTPD.IHTTPSession
import fi.iki.elonen.NanoHTTPD.Response

class StatusHandler(secretToken: String) : BaseHandler(secretToken) {

    override fun onGet(session: IHTTPSession): Response {
        val snapshot = ModuleStatusReporter.getStatusSnapshot(refresh = true, reason = "http_status")
        return ok(snapshot)
    }
}

