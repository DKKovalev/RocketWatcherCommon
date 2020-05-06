import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.Url
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

expect val client: HttpClient

class Api {

    fun call(urlString: String, callback: (String) -> Unit) {
        val url = Url(urlString)
        GlobalScope.apply {
            launch(Dispatcher) {
                val result = client.get<String>(url)
                callback(result)
            }
        }
    }
}