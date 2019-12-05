package com.example.mvvmpattern.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvvmpattern.R;
import com.example.mvvmpattern.adapter.UserAdapter;
import com.example.mvvmpattern.model.User;
import com.example.mvvmpattern.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {


    MainActivityViewModel mainActivityViewModel;

    private EditText editText1, editText2;
    private Button button1;

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connect main activity view model
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        recyclerView = findViewById(R.id.recyView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        mainActivityViewModel.getAllUserData().observe(this, new Observer<User[]>() {
            @Override
            public void onChanged(User[] users) {
                //users[0].getAvatarUrl();

                recyclerView.setAdapter(new UserAdapter(users));
            }
        });

        /*editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        button1 = findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mainActivityViewModel.additionFunction(editText1.getText().toString(), editText2.getText().toString())
                        .observe(MainActivity.this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {

                        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();

                    }
                });

            }
        });*/


    }
}
