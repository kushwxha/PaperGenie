package com.example.papergenie;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class paperAdapter extends RecyclerView.Adapter<paperAdapter.PaperViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;

    // we are storing all the papers in a list
    private List<Paper> paperList;

    public paperAdapter(Context mCtx, List<Paper> paperList){
        this.mCtx = mCtx;
        this.paperList = paperList;
    }

    @Override
    public PaperViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.papercards_layout,null);
        return new PaperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PaperViewHolder holder, int position){
        position = holder.getAdapterPosition();
        //getting the product of the specified position
        final Paper paper = paperList.get(position);

        //binding the data with the viewholder views

        holder.textViewTitle.setText(paper.getTitle());
        holder.timeTextview.setText(paper.getTime());
        holder.markTextview.setText(paper.getMarks());
        holder.noOfQuestxt.setText(paper.getQuestions());

        int finalPosition = position;
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),pdf.class);
                Log.d("PaperAdapter","Link: "+ paperList.get(finalPosition).getLink());

                i.putExtra("link",paperList.get(finalPosition).getLink());
                mCtx.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount(){
        return paperList.size();
    }


    public static class PaperViewHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle,timeTextview,markTextview,noOfQuestxt;
        CardView cardView;
        public PaperViewHolder(View itemView){
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            timeTextview = itemView.findViewById(R.id.timeTextview);
            markTextview = itemView.findViewById(R.id.markTextview);
            noOfQuestxt = itemView.findViewById(R.id.noOfQuestxt);
        }
    }
}
