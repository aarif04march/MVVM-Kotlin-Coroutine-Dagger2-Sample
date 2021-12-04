package com.aarif.mvvmcoroutines.ui.friends

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aarif.mvvmcoroutines.R
import com.aarif.mvvmcoroutines.core.data.model.Friend
import com.aarif.mvvmcoroutines.core.data.model.Post
import com.aarif.mvvmcoroutines.databinding.ItemFriendsBinding
import com.aarif.mvvmcoroutines.databinding.ItemPostsBinding

class FriendsListAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var friendsList: List<Friend> = emptyList()

    inner class ItemViewHolder(var binding: ItemFriendsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(pos: Int) {
            val data = friendsList[pos]
            binding.apply {
                txtName.text = data.name
                txtEmail.text = data.email


                        /*val leg2 = it[1]
                        txtTime2.text = "${utils.getHoursFromDate(leg2.departureTime)} - ${utils.getHoursFromDate(leg2.arrivalTime)}"
                        txtFlight2.text = "${leg2.departureAirport}-${leg2.arrivalAirport}, ${leg2.airlineName}"
                        txtStop2.text = if(leg2.stops==0) "Direct" else if( leg2.stops>1) "${leg2.stops} Stops" else "1 Stop"
                        txtDuration2.text = "${utils.getDurationFromMinutes(leg2.durationMins)}"
                        Glide.with(context)
                            .load(imageUrl.replace("{id}", leg1.airlineId))
                            .into(imgCarrier2)*/



            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemFriendsBinding>(inflater, R.layout.item_friends, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            (holder as ItemViewHolder).bindData(position)
    }

    override fun getItemCount(): Int {
        return friendsList.size
    }



    fun refreshList(friendsList: List<Friend>) {
        this.friendsList =friendsList
        notifyDataSetChanged()
    }
}