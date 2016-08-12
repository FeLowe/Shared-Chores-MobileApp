package com.epicodus.sharedchoresapp.ui;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.TableLayout;

import com.epicodus.sharedchoresapp.R;
import com.epicodus.sharedchoresapp.fragments.AddChoreListDialogFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

@Bind(R.id.addChoreListButton)Button mAddChoreListButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAddChoreListButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v == mAddChoreListButton) {
            showChoreListDialog();
        }

    }

    public void showChoreListDialog() {

        DialogFragment dialog = AddChoreListDialogFragment.newInstance();
        dialog.show(MainActivity.this.getSupportFragmentManager(), "AddChoreListDialogFragment");

    }

}



