package com.gwizz.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.gwizz.myapplication.databinding.RvpodcastlistRowBinding
import com.gwizz.myapplication.models.PodcastModel

class PodcastAdapter(private val podcastIdList : List<String>):
    RecyclerView.Adapter<PodcastAdapter.MyViewHolder>() {

    class MyViewHolder(private val binding: RvpodcastlistRowBinding): RecyclerView.ViewHolder(binding.root){
        //  bind data

        fun bindData(podcastID : String){
            // Fetching Docs
            FirebaseFirestore.getInstance().collection("podcasts").document(podcastID)
                .get().addOnSuccessListener {
                    val podcast = it.toObject(PodcastModel::class.java)
                    podcast?.apply {
                        binding.tvPodcastTitle.text = title
                        binding.tvPodcastSubtitle.text = subtitle
                    }
                }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RvpodcastlistRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return podcastIdList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(podcastIdList[position])
    }
}