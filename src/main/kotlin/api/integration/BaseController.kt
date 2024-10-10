package api.integration

import io.micronaut.core.async.annotation.SingleResult
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.reactive.asPublisher
import org.reactivestreams.Publisher


@Controller
class ChatgptController(private val chatgptApiClient: ChatgptApiClient) {

    private fun getJson(prompt:String = "How to make car sharing app?") = """{
        "model": "gpt-3.5-turbo",
        "messages": [
           {
               "role": "user",
               "content": "$prompt"
           }
       ]
    }""".trimIndent()

    @Get("/sendPrompt")
    @Header(MediaType.TEXT_HTML)
    @SingleResult
    fun releasesWithLowLevelClient(): Publisher<String> = chatgptApiClient
        .fetchPrompt(getJson()).asFlow().map { chatgptResponse ->
            chatgptResponse.choices.first().message.content
        }.asPublisher()
}
