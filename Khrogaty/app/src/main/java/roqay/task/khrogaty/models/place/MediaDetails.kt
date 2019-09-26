package roqay.task.khrogaty.models.place

data class MediaDetails(
    val `file`: String,
    val height: Int,
    val image_meta: ImageMeta,
    val sizes: Sizes,
    val width: Int
)