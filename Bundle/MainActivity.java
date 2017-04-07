package com.bmpl.usingbundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText nameEditText, mobileEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)//--saving the state of activity
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        nameEditText = (EditText)findViewById(R.id.nameEditText);
        mobileEditText = (EditText)findViewById(R.id.mobileEditText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Bundle can be used for passing data between activities
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                Bundle bundle = new Bundle();

                bundle.putString("name", nameEditText.getText().toString());
                bundle.putString("mobile", mobileEditText.getText().toString());

                intent.putExtras(bundle);

                startActivity(intent);

                //intent.putExtra("name", nameEditText.getText().toString());
            }
        });
    }
}
