package cn.edu.sicnu.guoxiangyu2024110511.bookmanager.model

data class Book(
    val title: String,
    val author: String,
    val publisher: String,
    val price: Double
) {
    companion object {
        fun sortByPriceAsc(books: Array<Book>) {
            books.sortBy { it.price }
        }
    }
}
