package com.example.digitallibary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitallibary.R;

import java.util.ArrayList;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.myViewHlder>
{
    private Context myContext;
    private ArrayList<String> titlelist;
    private CustomItemClickListner clickListner;

    public TitleAdapter(Context myContext, ArrayList <String> titlelist, CustomItemClickListner clickListner)
    {
        this.myContext = myContext;
        this.titlelist = titlelist;
        this.clickListner = clickListner;
    }

    @NonNull
    @Override
    public myViewHlder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(myContext).inflate(R.layout.item_show,viewGroup,false);
        final myViewHlder viewHlder= new myViewHlder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                clickListner.onClickItem(v,viewHlder.getPosition());
            }
        });
        return viewHlder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHlder myViewHlder, int i) {

        myViewHlder.titleText.setText(titlelist.get(i).replace("_"," "));

    }

    @Override
    public int getItemCount() {
        return titlelist.size();
    }

    public class myViewHlder extends RecyclerView.ViewHolder
    {
        TextView titleText;


        public myViewHlder(@NonNull View itemView) {
            super(itemView);
            titleText = (TextView) itemView.findViewById(R.id.bookname);
        }
    }

}