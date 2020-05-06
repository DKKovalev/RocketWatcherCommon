import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp

actual val client: HttpClient = HttpClient(OkHttp) {
    engine {
        config {
            followRedirects(true)
        }
    }
}