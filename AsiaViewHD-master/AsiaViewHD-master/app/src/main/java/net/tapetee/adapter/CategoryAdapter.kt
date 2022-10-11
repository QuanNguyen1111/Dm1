package net.tapetee.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import net.tapetee.ListPostActivity
import net.tapetee.R
import net.tapetee.model.category.Category

class CategoryAdapter(private var context: Context, private var listCate: Collection<Category>) :

    RecyclerView.Adapter<CategoryHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        return CategoryHolder(LayoutInflater.from(context).inflate(R.layout.category, parent, false))
    }

    override fun getItemCount(): Int {
        return listCate.size
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        var category: Category = listCate.elementAt(position)
        holder.tvTitle.text = (category.name)
        holder.tvCount.text = (String.format(context.getString(R.string.album), category.count))

        holder.itemView.setOnClickListener {

            val intent = Intent(context, ListPostActivity::class.java)
            intent.putExtra("catId", category.id.toString())
            intent.putExtra("title", category.name)
            context.startActivity(intent)
        }
    }
}


class CategoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)

    val tvCount: TextView = itemView.findViewById(R.id.tvCount)


}
