package com.gidsor.bookstore.data.network

import android.os.AsyncTask
import com.gidsor.bookstore.data.api.HTTPRequestAPI
import org.json.JSONObject

class AddToLibraryTask : AsyncTask<String, Void, JSONObject>() {
    override fun doInBackground(vararg params: String): JSONObject {
        return HTTPRequestAPI.addToLibrary(params[0], params[1], params[2])
    }
}