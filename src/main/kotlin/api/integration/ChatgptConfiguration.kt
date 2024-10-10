package api.integration

import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.context.annotation.Requires

@ConfigurationProperties(ChatgptConfiguration.PREFIX)
@Requires(property = ChatgptConfiguration.PREFIX)
class ChatgptConfiguration {
    var orgkey: String? = null
    var token: String? = null
    var url: String? = null

    companion object {
        const val PREFIX = "chatgpt"
    }
}
