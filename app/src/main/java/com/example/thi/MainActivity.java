package com.example.thi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.thi.ListViewAdapter;
import com.example.thi.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewStub stubList;
    private ListView listView;
    private ListViewAdapter listViewAdapter;
    private List<Product> productList;
    private int currentViewMode = 0;
    static final int VIEW_MODE_LISTVIEW = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stubList = (ViewStub) findViewById(R.id.stub_list);
        stubList.inflate();
        listView = (ListView) findViewById(R.id.myListView);
        getProductList();
        SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
        currentViewMode = sharedPreferences.getInt("currentViewMode", VIEW_MODE_LISTVIEW);
        listView.setOnItemClickListener(onItemClick);
        stubList.setVisibility(View.VISIBLE);
        listViewAdapter = new ListViewAdapter(this, R.layout.list_item, productList);
        listView.setAdapter(listViewAdapter);



    }
    public List<Product> getProductList(){
        //pseudo code to get product, replace your code to get real product here
        productList = new ArrayList<>();
        productList.add(new Product(R.drawable.icon_avatar_remove,"Phạm Tiến Long"));
        productList.add(new Product(R.drawable.icon_avatar_remove,"Văn Hoàng"));
        productList.add(new Product(R.drawable.icon_avatar_remove,"Văn Đức"));
        productList.add(new Product(R.drawable.icon_avatar_remove,"Văn Toàn"));
        productList.add(new Product(R.drawable.icon_avatar_remove,"Tiến Dũng"));
        productList.add(new Product(R.drawable.icon_avatar_remove,"Jack Sparow"));
        productList.add(new Product(R.drawable.icon_avatar_remove,"Harry Potter"));
        productList.add(new Product(R.drawable.icon_avatar_remove,"Hoàng Anh"));
        productList.add(new Product(R.drawable.icon_avatar_remove,"Quang Long"));
        productList.add(new Product(R.drawable.icon_avatar_remove,"Hải Phan"));
        return productList;
    }
    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Do any thing when user click to item
            Intent intent = new Intent(MainActivity.this, Profile.class);
            startActivity(intent);
        }
    };
}






















