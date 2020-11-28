package com.example.sage.view.subjectsMenu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.sage.R;
import com.example.sage.model.CapeSubject;
import com.example.sage.model.CsecSubject;
import com.example.sage.model.Subject;
import com.example.sage.view.Class.ViewClasses;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private Context context;
    private List<Subject> subjects;

    public RecyclerViewAdapter(Context context, List<Subject> subjects) {
        this.context = context;
        this.subjects = subjects;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view=inflater.inflate(R.layout.cardview_item_subject,parent,false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.subjectName.setText(subjects.get(position).getName());
        //holder.subjectImage.setImageResource(csecSubjects.get(position).getImage());
        Glide
                .with(context)
                .load(subjects.get(position).getImage())
                .into(holder.subjectImage);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subjectType="";
                if(subjects.get(position) instanceof CsecSubject){
                    subjectType="CSEC";
                } else if(subjects.get(position) instanceof CapeSubject) {
                    subjectType="CAPE";
                }
                Intent intent = new Intent(context, ViewClasses.class);
                intent.putExtra("subject",holder.subjectName.getText().toString());
                intent.putExtra("subjectType",subjectType);
                context.startActivity(intent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return subjects.size();
    }




    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView subjectName;
        ImageView subjectImage;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            subjectName=(TextView) itemView.findViewById(R.id.subjectTextView);
            subjectImage=(ImageView) itemView.findViewById(R.id.subjectImageView);
            cardView = (CardView) itemView.findViewById(R.id.subjectCardView);
        }
    }

    @Override
    public long getItemId(int position) {
        return subjects.get(position).hashCode();
    }
}



