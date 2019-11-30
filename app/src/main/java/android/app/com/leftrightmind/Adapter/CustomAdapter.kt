package android.app.com.leftrightmind.Adapter

import android.app.com.leftrightmind.Model.DashData
import android.app.com.leftrightmind.R
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.custom_item_list.view.*

class CustomAdapter(private val mContext: Context, private val catList: List<DashData>, private val onItemClick:(DashData)->Unit) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        /*var title: TextView
        var image: ImageView

        init {
            title = view.findViewById(R.id.title)
            image = view.findViewById(R.id.image) as ImageView
        }*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.custom_item_list, parent, false)

        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, p1: Int) {

        val item = catList[p1]
        holder.itemView.name.text = item.name
        holder.itemView.mobileNo.text = item.mobileNumber
        if(item.lifelineDocuments!=null){
            if(item.lifelineDocuments.size!=0){
                val imageUrl = item.lifelineDocuments[0]
                    Glide
                        .with(mContext)
                        .load(imageUrl)


                        .error(R.drawable.ic_placeholder)
                        .centerCrop()
                        .circleCrop()
                        .into(holder.itemView.imageView)
            }
        }

        holder.itemView.setOnClickListener {
            onItemClick(item)

        }

    }

    override fun getItemCount(): Int {
        return catList.size
    }
}