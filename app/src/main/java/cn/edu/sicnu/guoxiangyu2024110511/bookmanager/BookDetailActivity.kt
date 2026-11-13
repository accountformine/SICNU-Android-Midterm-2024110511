package cn.edu.sicnu.guoxiangyu2024110511.bookmanager

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BookDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val title = intent.getStringExtra(MainActivity.EXTRA_TITLE) ?: ""
        val author = intent.getStringExtra(MainActivity.EXTRA_AUTHOR) ?: ""
        val publisher = intent.getStringExtra(MainActivity.EXTRA_PUBLISHER) ?: ""
        val price = intent.getDoubleExtra(MainActivity.EXTRA_PRICE, 0.0)

        findViewById<TextView>(R.id.tvDetailTitle).text = getString(R.string.detail_title_format, title)
        findViewById<TextView>(R.id.tvDetailAuthor).text = getString(R.string.detail_author_format, author)
        findViewById<TextView>(R.id.tvDetailPublisher).text = getString(R.string.detail_publisher_format, publisher)
        findViewById<TextView>(R.id.tvDetailPrice).text = getString(R.string.detail_price_format, price)

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
