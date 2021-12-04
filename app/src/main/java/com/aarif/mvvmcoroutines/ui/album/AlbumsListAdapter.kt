package com.aarif.mvvmcoroutines.ui.album

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aarif.mvvmcoroutines.R
import com.aarif.mvvmcoroutines.core.data.model.Album
import com.aarif.mvvmcoroutines.core.data.model.Post
import com.aarif.mvvmcoroutines.databinding.ItemAlbumsBinding

class AlbumsListAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var albumsList: List<Album> = emptyList()

    inner class ItemViewHolder(var binding: ItemAlbumsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(pos: Int) {
            val data = albumsList[pos]
            binding.apply {
                txtAlbumName.text = data.title

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
        val binding = DataBindingUtil.inflate<ItemAlbumsBinding>(inflater, R.layout.item_albums, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            (holder as ItemViewHolder).bindData(position)
    }

    override fun getItemCount(): Int {
        return albumsList.size
    }



    fun refreshList(albumsList: List<Album>) {
        this.albumsList =albumsList
        notifyDataSetChanged()
    }
}