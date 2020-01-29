package chapter2

// 연습문제 2-5
// 함수 합성을 하는 함수를 구현
// 함수의 시그니처는 책에서 제공됨.
fun <A, B, C> compose(f: (A) -> B, g: (B) -> C): (A) -> C = { a -> g(f(a))}