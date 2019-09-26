package roqay.task.khrogaty.models.restaurant

data class MediaDetails(
    val `file`: String,
    val height: Int,
    val image_meta: ImageMeta,
    val sizes: Sizes,
    val width: Int
)