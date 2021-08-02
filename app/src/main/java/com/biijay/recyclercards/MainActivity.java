package com.biijay.recyclercards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ExampleItem> exampleList;
    private Button buttonAdd, buttonDelete;
    private EditText editTextAdd, editTextDelete;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateFakeData();
        recyclerViewCongfig();

        buttonAdd = findViewById(R.id.buttonadd);
        buttonDelete = findViewById(R.id.buttondelete);

        editTextAdd = findViewById(R.id.edittextadd);
        editTextDelete = findViewById(R.id.edittextdelete);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo: make sure user is not allowed to submit empty form
                int position = Integer.parseInt(editTextAdd.getText().toString());
                addCard(position);
               // adapter.notifyDataSetChanged();
                adapter.notifyItemInserted(position);
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextDelete.getText().toString());
                deleteCard(position);
                adapter.notifyItemRemoved(position);

            }
        });

    }

    public void generateFakeData() {

        exampleList = new ArrayList<>();

        exampleList.add(new ExampleItem(R.drawable.node, "Clicked at Studio"));
        exampleList.add(new ExampleItem(R.drawable.oner, "Clicked at Italy"));
        exampleList.add(new ExampleItem(R.drawable.twor, "Clicked at Rome"));
        exampleList.add(new ExampleItem(R.drawable.threer, "Clicked at Greece"));
        exampleList.add(new ExampleItem(R.drawable.fourr, "Clicked at Rome"));
        exampleList.add(new ExampleItem(R.drawable.fiver, "Clicked at Nepal"));
        exampleList.add(new ExampleItem(R.drawable.sixr, "Clicked at India"));
    }

    public void recyclerViewCongfig() {
        //9
        // Config for Rv
        recyclerView = findViewById(R.id.recyclerView);
        //performance
        recyclerView.setHasFixedSize(true);
        //performance closed
        layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void addCard(int position){
        exampleList.add(position,new ExampleItem(R.drawable.node,"new card added"));

    }

    public void deleteCard(int position){
        exampleList.remove(position);

    }

}
