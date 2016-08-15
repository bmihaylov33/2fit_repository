package com.example.user.a2fit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;

public class SignUp extends Activity {

    private String gender = null;
    private EditText name = null;
    private EditText age = null;
    private EditText weight = null;
    private EditText height = null;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_sign_up);

        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        weight = (EditText) findViewById(R.id.weight);
        height = (EditText) findViewById(R.id.height);

        button= (Button) findViewById(R.id.okButton);
        button.setOnClickListener(saveButtonListener);

    }

    public void onRadioButtonClicked(View view) {
        //Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        //Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_1:
                if (checked)
                    gender=("Male");
                Toast.makeText(SignUp.this,
                        gender, Toast.LENGTH_SHORT).show();
                    break;
            case R.id.radio_2:
                if (checked)
                    gender=("Female");
                    Toast.makeText(SignUp.this,
                            gender, Toast.LENGTH_SHORT).show();
                    break;
        }
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
                Toast.makeText(getBaseContext(), errorLabel, Toast.LENGTH_LONG).show();
            } else {
                user.save(SignUp.this);
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
            Log.d("Button", "in");
//            Log.d("Button", "Name val: " + name.getText().toString());
//            Log.d("Button", "Age val: " + age.getText().toString());
//            Log.d("Button", "Weight val: " + weight.getText().toString());
//            Log.d("Button", "Hight val: " + hight.getText().toString());
//            Log.d("Button", "Gender val: " + gender);
        }
    };


}
