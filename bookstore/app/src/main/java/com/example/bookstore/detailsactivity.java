package com.example.bookstore;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detailsactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_details);
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        Books deliveredbook = (Books) bundle.getSerializable("book");

        TextView bookname = findViewById(R.id.booktitledet);
        TextView bookcategory = findViewById(R.id.bookcatdet);
        ImageView bookimg = findViewById(R.id.imgdet);
        TextView bookprice = findViewById(R.id.bookprcdet);

        bookname.setText(deliveredbook.getBookname());
        bookcategory.setText(deliveredbook.getBookcategory());
        bookimg.setImageResource(deliveredbook.getBookPhoto());
        bookprice.setText(String.valueOf(deliveredbook.getBookPrice()));



    }
}