package chapter3

// 함수적 자료구조 구현체.
// Singly Linked List를 구현하였음
// fpinkotlin repository를 참고하여 구현함.
// 책 38페이지 하단, 목록 3.1에 나와있는 구현체를 kotlin으로 구현하였다.
sealed class List<out A> {
    companion object {
        fun sum(ints: List<Int>): Int =
            when (ints) {
                is Nil -> 0
                is Cons -> ints.head + sum(ints.tail)
            }

        fun product(ds: List<Double>): Double =
            when (ds) {
                is Nil -> 1.0
                is Cons -> ds.head * product(ds.tail)
            }

        fun <A> apply(vararg aa: A): List<A> = when {
            aa.isEmpty() -> Nil
            else -> Cons<A>(aa[0], apply(*aa.sliceArray(1 until aa.size)))
        }
    }
}

object Nil : List<Nothing>() {}

data class Cons<out A>(val head: A, val tail: List<A>) : List<A>()