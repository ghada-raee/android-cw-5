package com.example.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle b = getIntent().getExtras();
        Book bo = (Book) b.getSerializable("book");

        ImageView img = findViewById(R.id.imageView4);
        TextView title = findViewById(R.id.dtitle);
        TextView isbn = findViewById(R.id.disbn);
        TextView series = findViewById(R.id.dseries);
        TextView des = findViewById(R.id.ddes);

        img.setImageResource(bo.getImg());
        title.setText(bo.getTitle());
        isbn.setText(bo.getIsbn());
        series.setText(bo.getSeries());
        des.setText(bo.getDes());

    }
}