package io.github.sds100.keymapper.nativelib

import android.system.Os
import android.util.Log
import kotlin.system.exitProcess

/**
 * See demo/service/UserService.java in the Shizuku-API repository for how a Shizuku user service
 * is set up.
 */
class EvdevService : IEvdevService.Stub() {

    /**
     * A native method that is implemented by the 'nativelib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'nativelib' library on application startup.
        init {
            System.loadLibrary("nativelib")
        }
    }

    private val TAG: String = "EvdevService"

    override fun destroy() {
        Log.i(TAG, "destroy")
        exitProcess(0)
    }

    override fun sendEvent(): String {
        Log.e(TAG, "UID = ${Os.getuid()}")
        return stringFromJNI()
    }
}
