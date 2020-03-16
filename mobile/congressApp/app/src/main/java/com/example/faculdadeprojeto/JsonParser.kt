import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.faculdadeprojeto.DisciplinaActivity
import com.example.faculdadeprojeto.ParticipantsValue
import com.example.faculdadeprojeto.R
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class JsonParser {
    private lateinit var listView: ListView

    companion object {
        @JvmStatic
        fun fetchJson() {
            val url = "http://172.17.72.97:3333/api/participants-to-transfer"
            val request = Request.Builder().url(url).build()
            val client = OkHttpClient()

            client.newCall(request).enqueue(object: Callback {

                override fun onResponse(call: Call, response: Response) {
                    val body = response.body?.string()
                    val gson = GsonBuilder().create()
                    val resultJson = gson.fromJson(body, ParserResult::class.java).result
                  }

                override fun onFailure(call: Call, e: IOException) {
                    println("Deu merda")
                }
            })
        }
    }
}

class ParserResult(val result: List<ParticipantsValue>)
