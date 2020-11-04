import arrow.*
import arrow.core.*
import arrow.core.Const.Companion.just
import arrow.core.extensions.const.functor.map
import arrow.core.extensions.list.apply.map2
import arrow.typeclasses.*

fun simple() {
    // l: List[Int]
    val l: List<Int> = listOf(1, 2, 3, 4, 5)
    // def map[Int](f: Int -> String): List[String]
    l.map { a -> a.toString() }

    // ont: Option[Int]
    val one: Option<Int> = Some(1)
    // def map[Int](f: Int -> String): Option[String]
    one.map { a -> a.toString() }

    // r: Either[Boolean, Int]
    val r: Either<Boolean, Int> = Right(1)
    // def map[Boolean, Int](f: Int -> String): Either[Boolean, String]
    r.map { a -> a.toString() }

    // c: Const[Int]
    val c: Const<Int, Nothing> = 2.const()
    // def map[Int, Nothing](f: Int -> String): Const[String]
    c.map { a -> a.toString() }

    // def map[F[T]](f: T -> K): F[K]
    // def map[F, T](f: T -> K): F[K]
}
