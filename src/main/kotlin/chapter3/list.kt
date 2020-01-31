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
            else -> Cons(aa[0], apply(*aa.sliceArray(1 until aa.size)))
        }

        // 연습문제 3-2
        // 책 45p에 나와있는 문제.
        // List의 첫 요소를 제거하는 함수를 구현하였다.
        fun <T> tail(list: List<T>): List<T> = when (list) {
            is Nil -> Nil
            is Cons -> list.tail
        }

        // 연습문제 3-3
        // 문제 3-2 아래에 있다.
        // List의 첫 요소를 다른 값으로 대체하는 함수를 구현하였다.
        fun <T> setHead(list: List<T>, head: T): List<T> = when (list) {
            is Nil -> Cons(head, Nil)
            is Cons -> Cons(head, list.tail)
        }

        // 연습문제 3-4
        // tail을 일반화 하여서 처음 n개의 요소를 제거하는 함수를 구현하였다.
        // 이 함수의 실행시간은 n에 비례한다.
        fun <T> drop(list: List<T>, n: Int): List<T> = when (n) {
            1 -> tail(list)
            else -> drop(tail(list), n - 1)
        }

        // 연습문제 3-5
        // 앞 요소들을 제거하는 함수를 구현하였다.
        fun <T> dropWhile(list: List<T>, f: (T) -> Boolean): List<T> = when (list) {
            f -> dropWhile(tail(list), f)
            else -> list
        }

        fun <T> append(a1: List<T>, a2: List<T>): List<T> = when (a1) {
            is Nil -> a2
            is Cons -> Cons(a1.head, append(a1.tail, a2))
        }

        // 연습문제 3-6
        // 마지막 요소를 제외한 모든 요소로 이루어진 List를 반환한다.
        fun <T> init(l: List<T>): List<T> = when (l) {
            is Nil -> Nil
            is Cons -> when (l.tail) {
                is Nil -> Nil
                is Cons -> Cons(l.head, init(tail(l)))
            }
        }

        // 목록 3-2를 구현하였다.
        // sum과 product를 일반화 시킨 버전이다.
        // 꼬리재귀가 아니기 때문에 Stack Overflow가 발생할 수 있다.
        fun <T, V> foldRight(l: List<T>, z: V): (f: (T, V) -> V) -> V = { f ->
            when (l) {
                is Nil -> z
                is Cons -> f(l.head, foldRight(l.tail, z)(f))
            }
        }
    }

}

object Nil : List<Nothing>()

data class Cons<out A>(val head: A, val tail: List<A>) : List<A>()