package chapter2

// 연습문제가 아님
fun <A, B, C> partial1(a: A, f: (A, B) -> C): (B) -> C = { b: B -> f(a, b)}