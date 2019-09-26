package roqay.task.khrogaty.models.restaurant

data class BetterFeaturedImage(
    val alt_text: String,
    val caption: String,
    val description: String,
    val id: Int,
    val media_details: MediaDetails,
    val media_type: String,
    val post: Int,
    val source_url: String
)