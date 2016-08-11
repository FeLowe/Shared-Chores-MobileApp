package com.epicodus.sharedchoresapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.epicodus.sharedchoresapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.addChoreButton) Button mAddChoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAddChoreButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v == mAddChoreButton) {
            Intent intent = new Intent(MainActivity.this, ChoreListActivity.class);
            startActivity(intent);
        }
    }
}
