package cn.edu.sicnu.guoxiangyu2024110511.bookmanager

import cn.edu.sicnu.guoxiangyu2024110511.bookmanager.model.Book
import org.junit.Assert.assertEquals
import org.junit.Test

class BookManagerUnitTest {

    @Test
    fun sortByPriceAsc_ordersBooksFromLowestToHighest() {
        val books = arrayOf(
            Book("Book A", "Author A", "Publisher A", 99.0),
            Book("Book B", "Author B", "Publisher B", 35.5),
            Book("Book C", "Author C", "Publisher C", 62.0)
        )

        Book.sortByPriceAsc(books)

        assertEquals(35.5, books[0].price, 0.001)
        assertEquals(62.0, books[1].price, 0.001)
        assertEquals(99.0, books[2].price, 0.001)
        assertEquals("Book B", books[0].title)
    }
}
