import chapter3.Cons
import chapter3.List
import chapter3.List.Companion.foldRight
import chapter3.List.Companion.init
import chapter3.List.Companion.sum
import chapter3.Nil
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Test {
    @Test
    fun `Test Simple`() {
        assert(true)
    }

    @Test
    fun `Create List`() {
        val list: List<Int> = Cons(1, Nil)
        assertThat(list).isNotNull
        assertThat(
            when (list) {
                is Nil -> false
                is Cons -> true
            }
        ).isTrue()
    }

    @Test
    fun `Init List`() {
        val list: List<Int> = Cons(1, Cons(2, Cons(3, Cons(4, Nil))))
        assertThat(sum(init(list))).isEqualTo(1 + 2 + 3)
    }

    @Test
    fun `FoldRight Sum List`() {
        val list: List<Int> = Cons(1, Cons(2, Cons(3, Cons(4, Nil))))
        val w = foldRight(list, 0)(){ a, b -> a + b}
        assertThat(w).isEqualTo(1 + 2 + 3 + 4)
    }

    @Test
    fun `FoldRight Product List`() {
        val list: List<Int> = Cons(1, Cons(2, Cons(3, Cons(4, Nil))))
        val w = foldRight(list, 1)(){ a, b -> a * b}
        assertThat(w).isEqualTo(1 * 2 * 3 * 4)

        // If list is (1, 0, 3, 4), and Z is 1.
        // 1 * foldRight(0, 3, 4, Nil)
        // 1 * 0 * foldRight(3, 4, Nil)
        // 1 * 0 * 3 * foldRight(4, Nil)
        // 1 * 0 * 3 * 4 * foldRight(Nil)
        // (1 * (0 * (3 * (4 * Z(1)))))
    }
}