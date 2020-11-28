package com.example.sage.view.Class;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sage.R;
import com.example.sage.model.Class;
import com.example.sage.model.Subject;
import com.example.sage.view.ClassSession.ViewSessions;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ViewClassesRecyclerViewAdapter extends RecyclerView.Adapter<ViewClassesRecyclerViewAdapter.MyViewHolder>{

    private Context context;
    private List<Class> classes;

    public ViewClassesRecyclerViewAdapter(Context context, List<Class> classes) {
        this.context = context;
        this.classes = classes;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.cardview_view_classes, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Subject subj = classes.get(position).getSubject();
        String cName = subj.getName();

        holder.className.setText(cName);
        holder.sessionsAmt.setText( String.valueOf(classes.get(position).getNumSessions()) );
        holder.studentAmt.setText( String.valueOf(classes.get(position).getClassSize()) );
        holder.numSeatsAvailable.setText( String.valueOf(classes.get(position).getClassCapacity()-classes.get(position).getClassSize()) );
        holder.classDescription.setText(classes.get(position).getClassDescription());
        holder.price.setText(String.format("%.2f", (classes.get(position).getPrice())));

        holder.enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "You have enrolled", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        holder.classesCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ViewSessions.class);
                intent.putExtra("classId",classes.get(position).getClassId());
                context.startActivity(intent);
            }
        });

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView className;
        TextView sessionsAmt;
        TextView studentAmt;
        TextView numSeatsAvailable;
        TextView classDescription;
        TextView price;
        CardView classesCardView;
        Button enroll;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            className = (TextView) itemView.findViewById(R.id.className);
            sessionsAmt = (TextView) itemView.findViewById(R.id.sessionsAmt);
            studentAmt = (TextView) itemView.findViewById(R.id.studentAmt);
            numSeatsAvailable = (TextView) itemView.findViewById(R.id.numSeatsAvailable);
            classDescription = (TextView) itemView.findViewById(R.id.classDescription);
            price = (TextView) itemView.findViewById(R.id.price);
            classesCardView = (CardView) itemView.findViewById(R.id.classesCardView);
            enroll = (Button) itemView.findViewById(R.id.enroll);
        }
    }


    @Override
    public int getItemCount() {
        return classes.size();
    }

    @Override
    public long getItemId(int position) {
        return classes.get(position).hashCode();
    }
}
