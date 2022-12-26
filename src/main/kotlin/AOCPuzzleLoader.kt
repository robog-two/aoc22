import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import java.io.File

val client = HttpClient()
val session = File("./session.txt").readLines()[0]

suspend fun loadPuzzle(day: Int): String {
    val httpResponse: HttpResponse = client.get("https://adventofcode.com/2022/day/$day/input") {
        headers {
            append(HttpHeaders.Cookie, "session=$session")
        }
    }
    return httpResponse.body()
}