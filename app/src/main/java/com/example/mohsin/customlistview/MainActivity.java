package com.example.mohsin.customlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Bananas (3 lbs.)", "Avocados (5 ct.)", "Member's Mark Ultra Premium Bath Tissue, 2-Ply Large Roll Toilet Paper(45 rolls)", "Member's Mark Vitamin D Whole Milk (1 gal.)", "Tomatoes on the Vine (3 lbs.)","all Advanced 4-in-1 (150 loads., 255 oz.)"};
    String mDescription[] = {"$1.39 \t \t", "$5.98 \t \t", "$19.88 \t \t", "$3.16 \t \t", "$4.48 \t \t","$15.82 \t \t"};
    int images[] = {R.drawable.banana, R.drawable.avacado, R.drawable.tissue, R.drawable.milk, R.drawable.tomato,R.drawable.laundry};
    // so our images and other things are set in array

    // now paste some images in drawable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);

//        // now set item click on list view
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (position ==  0) {
//                    Toast.makeText(MainActivity.this, "banana", Toast.LENGTH_SHORT).show();
//                }
//                if (position ==  0) {
//                    Toast.makeText(MainActivity.this, "avacado", Toast.LENGTH_SHORT).show();
//                }
//                if (position ==  0) {
//                    Toast.makeText(MainActivity.this, "Twitter Description", Toast.LENGTH_SHORT).show();
//                }
//                if (position ==  0) {
//                    Toast.makeText(MainActivity.this, "Instagram Description", Toast.LENGTH_SHORT).show();
//                }
//                if (position ==  0) {
//                    Toast.makeText(MainActivity.this, "Youtube Description", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        // so item click is done now check list view
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);

            if(position==0)
            {
                String text = rDescription[position] + "<font color =#ff0000>expiring in 4 days</font>";
                myDescription.setText(Html.fromHtml(text));

            }
           else if(position==1)
            {
                String text = rDescription[position] + "<font color =#ff0000>expiring in 2 days</font>";
                myDescription.setText(Html.fromHtml(text));

            }
           else if(position==3)
            {
                String text = rDescription[position] + "<font color =#ff0000>expiring in 7 days</font>";
                myDescription.setText(Html.fromHtml(text));

            }
            else if(position==4)
            {
                String text = rDescription[position] + "<font color =#ff0000>expiring in 5 days</font>";
                myDescription.setText(Html.fromHtml(text));

            }

            else{
                String text = rDescription[position] + "<font color =#ff0000>expiry: n/a</font>";
                myDescription.setText(Html.fromHtml(text));
            }





            return row;
        }
    }
}
