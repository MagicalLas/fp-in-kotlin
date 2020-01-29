package chapter2

// 연습문제 2-1
// 피보나치를 구하는 함수 구현. 꼬리재귀를 사용해서 구현할 것.
// 함수의 시그니처는 책에서 제공됨.
fun fibonacci(acc: Int, n1: Int, n2: Int, c: Int): Int {
    if (c == 0) {
        return acc
    }
    return fibonacci(n1 + n2, n2, n1 + n2, c - 1)
}