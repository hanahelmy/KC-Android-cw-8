package com.example.bookstore;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BooksAdapter extends ArrayAdapter {
    List<Books> booksList;
    public BooksAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        booksList = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        Books currentbook = booksList.get(position);

        TextView nametxt = view.findViewById(R.id.name);
        TextView pricetxt = view.findViewById(R.id.txtprice);
        TextView cattxt = view.findViewById(R.id.txtcategory);
        ImageView plantimg = view.findViewById(R.id.img);

        nametxt.setText(currentbook.getBookname());
        cattxt.setText(currentbook.getBookcategory());
        plantimg.setImageResource(currentbook.getBookPhoto());
        pricetxt.setText(currentbook.getBookPrice() + " KD");


        ImageView delete = view.findViewById(R.id.delete);
            delete.setOnClickListener(new View.OnClickListener() {

                Books removedbook = booksList.get(position);


                @Override
                public void onClick(View view)
                {
                    AlertDialog.Builder bilder = new AlertDialog.Builder(getContext()).setMessage("Are you sure you want to remove this book from your reading list?").setTitle("Confirmation").setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            booksList.remove(removedbook);
                            notifyDataSetChanged();
                        }
                    }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });

                    bilder.show();


                }
            });



        return view;
    }

}