package roqay.task.khrogaty.models.restaurant

data class ImageMeta(
    val aperture: String,
    val camera: String,
    val caption: String,
    val copyright: String,
    val created_timestamp: String,
    val credit: String,
    val focal_length: String,
    val iso: String,
    val keywords: List<Any>,
    val orientation: String,
    val shutter_speed: String,
    val title: String
)