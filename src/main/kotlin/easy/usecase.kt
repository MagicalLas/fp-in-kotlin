package easy

import arrow.core.*
import arrow.core.extensions.either.apply.map2

data class AD(val id: Int, val title: String)


class Repository {
    fun save(ad: AD): Option<Unit> {
        // Some Great Code!!!
        // if raise error, return none()
        return Some(Unit)
    }

    fun save2(ad: AD): Either<Exception,Unit> {
        // Some Great Code!!!
        // if raise error, return Left(Exception("some error"))
        return Right(Unit)
    }

    fun get(id: Int): Either<Exception, AD> {
        // Some Great Code!!!
        // if raise error, return Left(Exception("some error"))
        return Right(AD(1, "LAS"))
    }
}

fun likeMain() {
    val repository: Repository = Repository()

    val ad = repository.get(10)
    val result = ad.map { x -> x.title }
        .map { x -> x.contains("las", ignoreCase = true) }
        .map { x -> """{"result": ${x}}""" }

    val jsonString = when (result) {
        is Either.Left -> """{"error": ${result.a.toString()}}"""
        is Either.Right -> result.b
    }

    // Either[Exception, String]
    val result2 = repository.get(6)
        .map { x -> AD(x.id, x.title + " is cute") }
        .map { x -> repository.save2(x) }
        .map { x -> x.map { Right("""{"status": "굿"}""") } }
        .map { x -> x.map { xx -> xx.right() } }
        .map { x -> x.getOrElse { "las" } }

    // String
    val result3 = repository.get(6)
        .map { x -> AD(x.id, x.title + " is cute") }
        .flatMap { x -> repository.save2(x) }
        .flatMap { _ -> Right("""{"status": "퍼펙트"}""") }
        .getOrElse { "las" }



    val ad1 = repository.get(10)
    val ad2 = repository.get(10)
    

    val w = ad1.map2(ad2) {(a, b) -> 3}
    w.map { a -> a + 3 }

}
