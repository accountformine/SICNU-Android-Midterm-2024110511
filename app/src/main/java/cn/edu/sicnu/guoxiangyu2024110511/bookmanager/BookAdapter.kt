package cn.edu.sicnu.guoxiangyu2024110511.bookmanager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.edu.sicnu.guoxiangyu2024110511.bookmanager.model.Book

class BookAdapter(
    private val books: Array<Book>,
    private val onBookClick: (Book) -> Unit
) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvBookTitle)
        val tvMeta: TextView = itemView.findViewById(R.id.tvBookMeta)
        val tvPrice: TextView = itemView.findViewById(R.id.tvBookPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = books.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = books[position]
        val context = holder.itemView.context
        holder.tvTitle.text = book.title
        holder.tvMeta.text = context.getString(R.string.book_meta_format, book.author, book.publisher)
        holder.tvPrice.text = context.getString(R.string.book_price_format, book.price)
        holder.itemView.setOnClickListener {
            val adapterPos = holder.bindingAdapterPosition
            if (adapterPos != RecyclerView.NO_POSITION) {
                onBookClick(books[adapterPos])
            }
        }
    }
}
