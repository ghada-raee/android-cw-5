package com.example.books;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter {

    ArrayList<Book> mArray;
    Context context;
    final LinearLayout ll1;

    public BookAdapter(ArrayList<Book> mArray, Context context,LinearLayout ll1) {
        this.mArray = mArray;
        this.context = context;
        this.ll1 = ll1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //connecting to book item xml
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).title.setText(mArray.get(position).getTitle()+"");
        ((ViewHolder) holder).author.setText(mArray.get(position).getAuthor()+"");
        ((ViewHolder) holder).genre.setText(mArray.get(position).getGenre()+"");
        ((ViewHolder) holder).rate.setText(mArray.get(position).getRate()+"");
        ((ViewHolder) holder).img.setImageResource(mArray.get(position).getImg());



        ((ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,Details.class);
                i.putExtra("book",mArray.get(position));
                context.startActivity(i);
            }
        });


        ((ViewHolder) holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book b = mArray.get(position);
                mArray.remove(position);
                notifyDataSetChanged();
                Snackbar.make(ll1,"Hello user",Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mArray.add(position,b);
                        notifyDataSetChanged();
                    }
                }).show();
            }
        });

        /*final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        ((ViewHolder) holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Delete");
                builder.setMessage("Are you sure you want to delete this item?");
                builder.setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mArray.remove(position);
                        notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog ad = builder.create();
                ad.show();


            }
        });
*/


    }

    @Override
    public int getItemCount() {
        return mArray.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView img;
        public TextView title;
        public TextView author;
        public TextView rate ;
        public TextView genre ;
        public View view;
        public ImageView delete;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView; //important
            img = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.titletxt);
            author = itemView.findViewById(R.id.authortxt);
            rate = itemView.findViewById(R.id.ratetxt);
            genre = itemView.findViewById(R.id.genretxt);
            delete = itemView.findViewById(R.id.delete);

        }
    }
}
