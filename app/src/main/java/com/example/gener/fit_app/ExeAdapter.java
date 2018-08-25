package com.example.gener.fit_app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gener on 24/08/2018.
 */

public class ExeAdapter  extends RecyclerView.Adapter<ExeAdapter.ExeViewHolder> {
    private Context mCtx;
    private List<Exe_struct> exeList;

    public ExeAdapter(Context mCtx, List<Exe_struct> exeList) {
        this.mCtx = mCtx;
        this.exeList = exeList;
    }



    @Override
    public ExeAdapter.ExeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_view_exe, null);
        ExeAdapter.ExeViewHolder holder = new ExeAdapter.ExeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ExeAdapter.ExeViewHolder holder, int position) {

        Exe_struct mus = exeList.get(position);
        holder.tv_name_exe.setText(mus.getName());
        holder.tv_desc_exe.setText(mus.getDescription()
        );

    }

    @Override
    public int getItemCount() {
        return exeList.size();
    }

    public class ExeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView tv_name_exe;
        TextView tv_desc_exe;
        public ExeViewHolder(View itemViem)
        {
            super(itemViem);
            ArrayList<Exe_struct> exe = new ArrayList<>();
            itemView.setOnClickListener(this);
            tv_name_exe = itemViem.findViewById(R.id.tv_name_exe);
            tv_desc_exe = itemViem.findViewById(R.id.tv_desc_exe);


        }

        @Override
        public void onClick(View v)
        {
            int position = getAdapterPosition();
            Exe_struct mus = exeList.get(position);
            Intent intent = new Intent(mCtx, Exe.class);
            mCtx.startActivity(intent);

        }
    }
}
