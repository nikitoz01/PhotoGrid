package kg.npml.core.common.model

/**
 * ui-модель фотографии
 */
data class Photo(
    val id: Long,
    val source: Source
)

data class Source(
    val original: String,
    val medium: String,
    val portrait: String,
)