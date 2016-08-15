package com.example.user.a2fit;

/**
 * Created by User on 1.8.2016 г..
 */
import android.app.ListFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MyListFragment extends ListFragment {

    String[] exercises = {
            "Abs",
            "Back",
            "Biceps",
            "Calves",
            "Chest",
            "Forearm",
            "Glutes",
            "Harmstrings",
            "Quads",
            "Neck",
            "Traps",
            "Triceps"
    };

    int[] imageId = {
            R.drawable.abs_rounded,
            R.drawable.back_rounded,
            R.drawable.biceps_rounded,
            R.drawable.calf_rounded,
            R.drawable.chest_rounded,
            R.drawable.forearm_rounded,
            R.drawable.glutes_rounded,
            R.drawable.harmstrings_rounded,
            R.drawable.quads_rounded,
            R.drawable.neck_rounded,
            R.drawable.traps_rounded,
            R.drawable.triceps_rounded

    };

    ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
    SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //MAP
        HashMap<String, String> map = new HashMap<String, String>();

        //FILL
        for(int i = 0; i< this.exercises.length; i++) {
            map = new HashMap<String, String>();
            map.put("Exercise", this.exercises[i]);
            map.put("Image", Integer.toString(imageId[i]));

            data.add(map);
        }

        //KEYS IN MAP
        String[] from = {"Exercise", "Image"};

        //IDS OF VIEWS
        int[] to =  { R.id.nameTxt, R.id.imageView1};

        //ADAPTER
        adapter= new SimpleAdapter(getActivity(),data, R.layout.model, from, to);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos, long id) {
                Toast.makeText(getActivity(), data.get(pos).get("Exercise"), Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(MyListFragment.this.getActivity(),WebActivity.class);
                myIntent.putExtra("key",pos);
                startActivity(myIntent);
            }
        });
    }

    /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
        }
    };

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Exercises, imageId);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
    }*/
}