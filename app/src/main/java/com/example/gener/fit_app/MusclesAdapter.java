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

public class MusclesAdapter  extends RecyclerView.Adapter<MusclesAdapter.MusclesViewHolder> {

    private Context mCtx;
    private List<Muscles_struct> musclesList;

    public MusclesAdapter(Context mCtx, List<Muscles_struct> musclesList)
    {
        this.mCtx = mCtx;
        this.musclesList = musclesList;
    }

    @Override
    public MusclesViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_view, null);
        MusclesViewHolder holder = new MusclesViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MusclesViewHolder holder, int position)
    {
        Muscles_struct mus = musclesList.get(position);
        holder.tv_name.setText(mus.getName());
    }

    @Override
    public int getItemCount() {
        return musclesList.size();
    }

    public class MusclesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView tv_name;
        public MusclesViewHolder(View itemViem)
        {
            super(itemViem);
            ArrayList<Muscles_struct> muscles = new ArrayList<>();
            itemView.setOnClickListener(this);
            tv_name = itemViem.findViewById(R.id.tv_name);

        }

        @Override
        public void onClick(View v)
        {
            int position = getAdapterPosition();
            Muscles_struct mus = musclesList.get(position);
            Intent intent = new Intent(mCtx, Exe.class);
            intent.putExtra("id",mus.getMuscle_id());
            mCtx.startActivity(intent);

        }
    }
}
