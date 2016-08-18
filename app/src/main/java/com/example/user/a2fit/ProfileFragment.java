package com.example.user.a2fit;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class ProfileFragment extends Fragment {

    User user = new User();
    private TextView name;
    private TextView age;
    private TextView weight;
    private TextView height;
    private TextView gender;

    private Button buttonEdit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        user.load(getActivity());

        SharedPreferences prefs = this.getActivity().getSharedPreferences("PREFS", 0);

        name = (TextView) view.findViewById(R.id.name_text);
        name.setText(prefs.getString("name", user.getName()));

        age = (TextView) view.findViewById(R.id.age_text);
        age.setText(prefs.getString("age", user.getAge()));

        weight = (TextView) view.findViewById(R.id.weight_text);
        weight.setText(prefs.getString("weight", user.getWeight()));

        height = (TextView) view.findViewById(R.id.height_text);
        height.setText(prefs.getString("height", user.getHeight()));

        gender = (TextView) view.findViewById(R.id.gender_text);
        gender.setText(prefs.getString("gender", user.getGender()));

        buttonEdit = (Button) view.findViewById(R.id.buttonEdit);

        buttonEdit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                EditFragment fragment = new EditFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,fragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
