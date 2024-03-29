package cafe

import cafe.models._
import play.api.data.Form
import play.api.data.Forms._

case class CafeAddForm(
    name: String,
    latitude: BigDecimal,
    longitude: BigDecimal,
    ratingOpt: Option[BigDecimal],
    images: Seq[String]
)

object CafeAddForm {

  val form: Form[CafeAddForm] = Form(
    mapping(
      "name" -> nonEmptyText(maxLength = 32),
      "latitude" -> bigDecimal
        .verifying("latitude must be greater than 0", _ >= Coordinate.MinLatitudeValue)
        .verifying("latitude must be less than 90", _ <= Coordinate.MaxLatitudeValue),
      "longitude" -> bigDecimal
        .verifying("longitude must be greater than 0", _ >= Coordinate.MinLongitudeValue)
        .verifying("longitude must be less than 90", _ <= Coordinate.MaxLongitudeValue),
      "star" -> optional(bigDecimal)
        .verifying("star must be greater than 0", _.fold(true)(_ >= Rating.MinValue))
        .verifying("star must be less than 90", _.fold(true)(_ <= Rating.MaxValue)),
      "images" -> seq(nonEmptyText)
    )(CafeAddForm.apply)(CafeAddForm.unapply)
  )

}
