package com.genral9ledge_pro_app.genral9ledge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.genral9ledge_pro_app.genral9ledge.Interfaces.itemClickListerner;
import com.genral9ledge_pro_app.genral9ledge.Model.personModel;
import com.genral9ledge_pro_app.genral9ledge.R;
import com.genral9ledge_pro_app.genral9ledge.databinding.PersonItemBinding;

import java.util.ArrayList;

public class personAdapter extends RecyclerView.Adapter<personAdapter.myViewHolder> {

    private static final int ITEM_TYPE_COUNTRY = 0;
    private static final int ITEM_TYPE_BANNER_AD = 1;

    private Context context;
    private ArrayList<personModel> arrayList;
    private itemClickListerner clickListerner;

    public personAdapter(Context context, ArrayList<personModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new myViewHolder(LayoutInflater.from(context).inflate(R.layout.person_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        personModel personModel = arrayList.get(position);

        holder.binding.positionCount.setText(personModel.getFirst_secondNumber());
        holder.binding.myProfile.setImageResource(personModel.getGetImage());

        holder.binding.name.setText(personModel.getName());
        holder.binding.kabSeKabTak.setText(personModel.getKab_se_kab_tak());
        holder.binding.kitaneSal.setText(personModel.getKitane_din());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        private PersonItemBinding binding;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = PersonItemBinding.bind(itemView);
        }
    }

}
