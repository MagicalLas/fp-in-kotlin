package chapter2

// 연습문제 2-2
// 정렬 유무를 판별하는 함수를 구현. 함수의 시그니처는 책에서 제공됨.
fun <A> isSorted(array: List<A>, ordered: (A, A) -> Boolean): Boolean = when {
    array.size < 2 -> true
    !ordered(array.first(), array[1]) -> false
    else -> isSorted(array.drop(1), ordered)
}
