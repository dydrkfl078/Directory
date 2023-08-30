package com.example.directory

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.directory.databinding.FavoriteItemViewBinding
import com.example.directory.databinding.ItemViewBinding

class MyRecyclerViewAdapter(private var mItems: MutableList<ContactList>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    init {
        mItems.sortBy {it.isFavorite}
        mItems.reverse()
        notifyDataSetChanged()
    }

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    val itemClick: ItemClick? = null

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        when (mItems[position].isFavorite) {
            true ->{
                (holder as FavoriteViewHolder).bind(mItems[position])
                holder.isFavorite.setImageResource(R.drawable.fill_heart_120)
            }

            false -> {
                (holder as RegularViewHolder).bind(mItems[position])
                holder.isFavorite.setImageResource(R.drawable.heart_120)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ItemViewType.FAVORITE -> {
                FavoriteViewHolder(
                    FavoriteItemViewBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> {
                RegularViewHolder(
                    ItemViewBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (mItems[position].isFavorite){
              ItemViewType.FAVORITE
        }else{
             ItemViewType.REGULAR
        }
    }

}

class RegularViewHolder(binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
    val userIconImageView = binding.listUserIcon
    val userName = binding.tvUserName
    val userNumber = binding.tvUserContactNumber
    val isFavorite = binding.favoriteIcon
    fun bind(item: ContactList) {
        userName.text = item.mName
        userNumber.text = item.mNumber
        userIconImageView.setImageResource(item.mImage)

    }
}

class FavoriteViewHolder(binding: FavoriteItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
    val userIconImageView = binding.favoriteListUserIcon
    val userName = binding.favoriteTvUserName
    val userNumber = binding.favoriteTvUserContactNumber
    val isFavorite = binding.favoriteFavoriteIcon
    fun bind(item: ContactList) {
        userName.text = item.mName
        userNumber.text = item.mNumber
        userIconImageView.setImageResource(item.mImage)

    }
}
