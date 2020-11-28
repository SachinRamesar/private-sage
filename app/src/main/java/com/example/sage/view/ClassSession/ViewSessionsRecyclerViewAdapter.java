package com.example.sage.view.ClassSession;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sage.R;
import com.example.sage.model.Session;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class ViewSessionsRecyclerViewAdapter extends RecyclerView.Adapter<ViewSessionsRecyclerViewAdapter.MyViewHolder>{

    private Context context;
    private List<Session> classSessions;

    public ViewSessionsRecyclerViewAdapter(Context context, List<Session> classSessions) {
        this.context = context;
        this.classSessions = classSessions;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.cardview_view_sessions, parent,false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.sessionNum.setText(holder.sessionNum.getText().toString()+(position+1));
        holder.sessionStart.setText(classSessions.get(position).getStartDateTime().format(DateTimeFormatter.ofPattern("dd-mm-yy hh:mm a")));
        holder.sessionEnd.setText(classSessions.get(position).getEndDateTime().format(DateTimeFormatter.ofPattern("dd-mm-yy hh:mm a")));
        holder.sessionCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(classSessions.get(position).getZoomLink()));
                context.startActivity(intent);
            }
        });

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView sessionNum;
        TextView sessionStart;
        TextView sessionEnd;
        CardView sessionCardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            sessionNum = (TextView) itemView.findViewById(R.id.sessionNum);
            sessionStart = (TextView) itemView.findViewById(R.id.sessionStart);
            sessionEnd = (TextView) itemView.findViewById(R.id.sessionEnd);
            sessionCardView = (CardView) itemView.findViewById(R.id.sessionsCardView);
        }
    }


    @Override
    public int getItemCount() {
        return classSessions.size();
    }

    @Override
    public long getItemId(int position) {
        return classSessions.get(position).hashCode();
    }
}
