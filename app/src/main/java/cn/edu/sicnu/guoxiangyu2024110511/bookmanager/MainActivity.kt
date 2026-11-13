package cn.edu.sicnu.guoxiangyu2024110511.bookmanager

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.edu.sicnu.guoxiangyu2024110511.bookmanager.model.Book

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_AUTHOR = "extra_author"
        const val EXTRA_PUBLISHER = "extra_publisher"
        const val EXTRA_PRICE = "extra_price"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val books = arrayOf(
            Book("第一行代码（第3版）", "郭霖", "人民邮电出版社", 99.00),
            Book("Kotlin编程权威指南", "Josh Skeen", "人民邮电出版社", 69.00),
            Book("Android编程权威指南（第4版）", "Bill Phillips", "清华大学出版社", 108.00),
            Book("深入理解Kotlin协程", "霍丙乾", "电子工业出版社", 59.00),
            Book("Android开发艺术探索", "任玉刚", "电子工业出版社", 79.00),
            Book("Kotlin从入门到精通", "明日科技", "清华大学出版社", 49.80),
            Book("算法图解", "Aditya Bhargava", "人民邮电出版社", 49.00)
        )

        Book.sortByPriceAsc(books)

        val recyclerView = findViewById<RecyclerView>(R.id.rvBooks)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = BookAdapter(books) { selectedBook ->
            val intent = Intent(this, BookDetailActivity::class.java).apply {
                putExtra(EXTRA_TITLE, selectedBook.title)
                putExtra(EXTRA_AUTHOR, selectedBook.author)
                putExtra(EXTRA_PUBLISHER, selectedBook.publisher)
                putExtra(EXTRA_PRICE, selectedBook.price)
            }
            startActivity(intent)
        }
    }
}
