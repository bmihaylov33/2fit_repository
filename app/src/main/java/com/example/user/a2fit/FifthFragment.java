package com.example.user.a2fit;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;

public class FifthFragment extends Fragment {

    User user = new User();
    private EditText name;
    private EditText age;
    private EditText weight;
    private EditText height;
    private String gender = null;
    private Button bt_cancel;
    private Button bt_ok;

    private RadioGroup radioGroupOne;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        user.load(getActivity());

        View view = inflater.inflate(R.layout.fragment_edit, container, false);

        bt_ok= (Button) view.findViewById(R.id.okButton);
        bt_ok.setOnClickListener(saveButtonListener);

        SharedPreferences prefs = this.getActivity().getSharedPreferences("PREFS", 0);
        name = (EditText) view.findViewById(R.id.name);
        name.setText(prefs.getString("name", user.getName()));

        age = (EditText) view.findViewById(R.id.age);
        age.setText(prefs.getString("age", user.getAge()));

        weight = (EditText) view.findViewById(R.id.weight);
        weight.setText(prefs.getString("weight", user.getWeight()));

        height = (EditText) view.findViewById(R.id.height);
        height.setText(prefs.getString("height", user.getHeight()));

        bt_cancel= (Button) view.findViewById(R.id.cancelButton);
        bt_cancel.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Fragment fragment = new ProfileFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                switch(checkedId) {
                    case R.id.radio_1:
                            gender=("Male");
                        Toast.makeText(getActivity(),
                                gender, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio_2:
                            gender=("Female");
                        Toast.makeText(getActivity(),
                                gender, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        Log.d("Profile", "edit: \t" + user.toString());

        return view;

    }

    public View.OnClickListener saveButtonListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {

                User user = new User();
                user.setName(name.getText().toString());
                user.setAge(age.getText().toString());
                user.setWeight(weight.getText().toString());
                user.setHeight(height.getText().toString());
                user.setGender((null == gender ? "" : gender.toString()));

                List<String> errors = user.validate();
                if (errors.size() > 0) {
                    String errorLabel = "";
                    Iterator<String> errorsIter = errors.iterator();
                    while (errorsIter.hasNext()) {
                        errorLabel += errorsIter.next() + "\r\n";
                    }
                    Toast.makeText(getActivity(), errorLabel, Toast.LENGTH_LONG).show();
                } else {
                    //..go to My Profile
                    user.save(getActivity());
                    ProfileFragment fragment = new ProfileFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction =
                            getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container,fragment);
                    fragmentTransaction.commit();

                }
        }
    };


}
