package api.integration


import io.micronaut.core.async.annotation.SingleResult
import io.micronaut.http.HttpHeaders.*
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Headers
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client
import org.reactivestreams.Publisher
import java.util.concurrent.Flow

@Client(id = "chatgpt")
@Headers(
    Header(name = USER_AGENT, value = "Micronaut HTTP Client"),
    Header(name = CONTENT_TYPE, value = "application/json"),
    Header(name = AUTHORIZATION, value = "Bearer \${chatgpt.token}")
)
interface ChatgptApiClient {

    @Post("chat/completions")
    @SingleResult
    fun fetchPrompt(@Body text: String): Publisher<ChatgptResponse>
}