package com.pangli.drag;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.pangli.drag.adapter.MyAdapterRecyclerView;
import com.pangli.drag.adapter.MyItemTouchHelperCallback;
import com.pangli.drag.interfaces.CallbackItemTouch;
import com.pangli.drag.model.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CallbackItemTouch {

    private RecyclerView mRecyclerView; // RecyclerVIew
    private MyAdapterRecyclerView myAdapterRecyclerView; //The Adapter for RecyclerVIew
    private List<Item> mList; // My List the object 'Item'.

    // Array images
    private int images[] = new int[]{
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i
    };

    // Array names
    private String names[] = new String[]{
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I"
    };

    // Description text
    private String textDescription = "Subtitle description,lorem ipsum text generic etc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        initList(); //call method

    }

    /**
     * Add data to the List
     */
    private void initList() {
        // Adds data to List of Objects Item
        mList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            mList.add(new Item(images[i], names[i], textDescription));
        }
        Collections.shuffle(mList);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)); // Set LayoutManager in the RecyclerView
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        myAdapterRecyclerView = new MyAdapterRecyclerView(mList); // Create Instance of MyAdapterRecyclerView
        mRecyclerView.setAdapter(myAdapterRecyclerView); // Set Adapter for RecyclerView
        ItemTouchHelper.Callback callback = new MyItemTouchHelperCallback(this);// create MyItemTouchHelperCallback
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback); // Create ItemTouchHelper and pass with
        // parameter the MyItemTouchHelperCallback
        touchHelper.attachToRecyclerView(mRecyclerView); // Attach ItemTouchHelper to RecyclerView
    }

    @Override
    public void itemTouchOnMove(int oldPosition, int newPosition) {
        mList.add(newPosition, mList.remove(oldPosition));// change position data
        myAdapterRecyclerView.notifyItemMoved(oldPosition, newPosition); //notifies changes in adapter, in this case
        //myAdapterRecyclerView.notifyDataSetChanged();
        // use the notifyItemMoved
    }
}
