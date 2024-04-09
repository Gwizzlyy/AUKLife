package com.gwizz.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.gwizz.myapplication.databinding.RvpodcastlistRowBinding
import com.gwizz.myapplication.models.FactalkModel


class FactalkAdapter(private val factalkIdList : List<String>):
    RecyclerView.Adapter<FactalkAdapter.MyViewHolder>() {

    class MyViewHolder(private val binding: RvpodcastlistRowBinding): RecyclerView.ViewHolder(binding.root){
        //  bind data

        fun bindData(factalkID : String){
            // Fetching Docs
            FirebaseFirestore.getInstance().collection("factalks").document(factalkID)
                .get().addOnSuccessListener {
                    val factalk = it.toObject(FactalkModel::class.java)
                    factalk?.apply {
                        binding.tvPodcastTitle.text = title
                        binding.tvPodcastSubtitle.text = subtitle
                    }
                }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RvpodcastlistRowBinding.inflate(LayoutInflater.from(parent.context), parent,
            false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return factalkIdList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(factalkIdList[position])
    }


}