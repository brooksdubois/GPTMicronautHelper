package api.integration

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Message(
    val role: String,
    val content: String,
    val refusal: String?
)

@Serdeable
data class Choice(
    val index: Int,
    val message: Message,
    val logprobs: String?,
    val finish_reason: String
)

@Serdeable
data class CompletionTokensDetails(
    val reasoning_tokens: Int
)

@Serdeable
data class Usage(
    val prompt_tokens: Int,
    val completion_tokens: Int,
    val total_tokens: Int,
    val completion_tokens_details: CompletionTokensDetails
)

@Serdeable
data class ChatgptResponse(
    val id: String,
    val `object`: String,
    val created: Int,
    val model: String,
    val choices: List<Choice>,
    val usage: Usage,
    val system_fingerprint: String?
)