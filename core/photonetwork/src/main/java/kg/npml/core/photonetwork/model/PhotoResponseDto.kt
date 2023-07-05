package kg.npml.core.photonetwork.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoResponseDto(
    @SerialName("total_results")
    val totalResults: Int,
    val page: Int,
    @SerialName("per_page")
    val perPage: Int,
    val photos: List<PhotoDto>
)
