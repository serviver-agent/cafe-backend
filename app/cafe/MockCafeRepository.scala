package cafe

import javax.inject.{Singleton, Inject}
import scala.concurrent.Future
import models._
import scala.concurrent.ExecutionContext

@Singleton
class MockCafeRepository @Inject()(
  implicit ec: ExecutionContext
) extends CafeRepository {

  override def findAll(): Future[Seq[Cafe]] = Future.successful {
    Cafe(
      id = 1,
      name = "BUoY Cafe",
      coodinate = Coodinate(BigDecimal("35.7435032"), BigDecimal("139.8000034")),
      rating = Rating(BigDecimal("4.5")),
      images = Nil
    ) ::
    Cafe(
      id = 2,
      name = "コメダ珈琲店 田端駅前店",
      coodinate = Coodinate(BigDecimal("35.7380439"), BigDecimal("139.7574194")),
      rating = Rating(BigDecimal("3.0")),
      images = Nil
    ) :: Nil
  }

  override def findById(id: Long): Future[Option[Cafe]] = findAll.map(_.find(_.id == id))
  
}