package com.example.interviewch2

import android.app.AlertDialog
import android.net.ParseException
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_first.*
import okhttp3.*
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            fetchJsonFromUrl()

        }
    }
    private fun fetchJsonFromUrl() {
        println("Im in fetchJson")
        val url = "https://capi.stage.9c9media.com/destinations/tsn_ios/platforms/iPad/contents/69585"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()

        val res = client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                println("Error")
            }
            override fun onResponse(call: Call, response: Response) {
                val body = response.body()?.string()
                //println(body)
                val topic = Gson().fromJson(body, Json4Kotlin_Base::class.java)
                val imt = topic.LastModifiedDateTime
                //println(imt)
                val format =
                    SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                try {
                    val date: Date = format.parse(imt)
                    val strDate = date.toString()
                    activity?.runOnUiThread{

                        textview_first.text = strDate
                    }
                    Handler(Looper.getMainLooper()).post {
                        textview_first.text = strDate

                        AlertDialog.Builder(activity).setTitle("Last Modified Date Time").setMessage(strDate).show()
                    }
                    //str = date.toString()

                } catch (e: ParseException) {
                    // TODO Auto-generated catch block
                    e.printStackTrace()
                }
            }
        })


    }
}
