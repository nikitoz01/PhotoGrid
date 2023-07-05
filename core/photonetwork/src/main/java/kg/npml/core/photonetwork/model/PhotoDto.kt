package kg.npml.core.photonetwork.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoDto (
    val id: Long,
    @SerialName("src")
    val sourceDto: SourceDto
)

@Serializable
data class SourceDto(
    val original: String,
    val medium: String,
    val portrait: String,
)