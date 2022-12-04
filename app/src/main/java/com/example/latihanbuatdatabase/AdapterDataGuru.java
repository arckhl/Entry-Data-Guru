package com.example.latihanbuatdatabase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDataGuru extends RecyclerView.Adapter<AdapterDataGuru.myViewHolder> {
    Context context;
    ArrayList<ModelDataGuru> dataguruArrayList;

    public AdapterDataGuru(Context context, ArrayList<ModelDataGuru> dataguruArrayList) {
        this.context = context;
        this.dataguruArrayList = dataguruArrayList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.format_tampilan_guru,parent,false);
        return new AdapterDataGuru.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.cnip.setText(dataguruArrayList.get(position).nip);
        holder.cnama.setText(dataguruArrayList.get(position).nama);
        holder.cstatus.setText(dataguruArrayList.get(position).status);
        holder.calamat.setText(dataguruArrayList.get(position).alamat);
        holder.ckota.setText(dataguruArrayList.get(position).kota);
        holder.klick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(),update_data_guru.class);
                intent.putExtra("nip",dataguruArrayList.get(position).nip);
                intent.putExtra("nama",dataguruArrayList.get(position).nama);
                intent.putExtra("status",dataguruArrayList.get(position).status);
                intent.putExtra("alamat",dataguruArrayList.get(position).alamat);
                intent.putExtra("kota",dataguruArrayList.get(position).kota);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataguruArrayList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView cnip,cnama,cstatus,calamat,ckota;
        RelativeLayout klick;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            cnip = itemView.findViewById(R.id.nipguru);
            cnama = itemView.findViewById(R.id.namaguru);
            cstatus = itemView.findViewById(R.id.statusguru);
            calamat = itemView.findViewById(R.id.alamatguru);
            ckota = itemView.findViewById(R.id.kotaguru);
            klick = itemView.findViewById(R.id.rela01);
        }
    }
}
