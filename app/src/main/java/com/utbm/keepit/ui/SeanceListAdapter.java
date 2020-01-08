package com.utbm.keepit.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.utbm.keepit.R;
import com.utbm.keepit.backend.entity.Seance;

import java.util.List;

public class SeanceListAdapter extends RecyclerView.Adapter<SeanceListAdapter.ViewHolder> {
    private List<Seance> seances;

    public SeanceListAdapter(Context context,List<Seance> seances) {
        this.seances = seances;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(seances.get(position).getName());
        holder.duration.setText(seances.get(position).getDuration());
        holder.intensity.setText(seances.get(position).getIntensity());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, AfficherSeanceExerciseActivity.class);
                intent.putExtra("seanceid",seances.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return seances.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,intensity,duration;
        View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;
            name=itemView.findViewById(R.id.seance_name);
            intensity=itemView.findViewById(R.id.seance_intensity);
            duration = itemView.findViewById(R.id.seance_duration);

        }
    }
}
