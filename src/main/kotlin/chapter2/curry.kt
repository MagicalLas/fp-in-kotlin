package chapter2


// 연습문제 2-3
// currying을 적용하는 함수를 구현
// 함수의 시그니처는 책에서 제공됨.
fun <A, B, C> curry(f: (A, B) -> C): (A) -> (B) -> C = { a -> { b -> f(a, b)} }


// 연습문제 2-4
// currying을 해제하는 함수를 구현
// 함수의 시그니처는 책에서 제공됨.
fun <A, B, C> uncurry(f: (A) -> (B) -> C): (A, B) -> C = {a, b -> f(a)(b)}