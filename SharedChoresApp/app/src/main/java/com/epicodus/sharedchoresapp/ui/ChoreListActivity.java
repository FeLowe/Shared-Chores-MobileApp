package com.epicodus.sharedchoresapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.epicodus.sharedchoresapp.Constants;
import com.epicodus.sharedchoresapp.R;
import com.epicodus.sharedchoresapp.models.ChoreList;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ChoreListActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference mDatabaseReference;
    private ValueEventListener mDatabaseReferenceListener;

    ArrayList<String> mChoreList = new ArrayList<>();

    @Bind(R.id.addChoreListButton)
    Button mAddChoreListButton;
    @Bind(R.id.addChoreListTextView)
    TextView mAddChoreListTextView;
    @Bind(R.id.listNameEditText)
    EditText mlistNameEditText;
    @Bind(R.id.listNameListView)
    ListView mListNameListView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chore_list);
        ButterKnife.bind(this);
        mAddChoreListButton.setOnClickListener(this);


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mChoreList);
        mListNameListView.setAdapter(adapter);

        mDatabaseReference = FirebaseDatabase
                .getInstance().getReference()
                .child(Constants.FIREBASE_CHILD_CHORE_LIST);

        mDatabaseReferenceListener = mDatabaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Log.d("TAG", "THE DATA HAS CHANGED");

                    ChoreList choreList = snapshot.getValue(ChoreList.class);
                    mChoreList.add(choreList.getListName());
                    mChoreList.add(choreList.getOwner());
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });
    }

    @Override
    public void onClick(View v) {
        if (v == mAddChoreListButton) {
            addChoreList();
        }

    }

    public void addChoreList() {

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_CHILD_CHORE_LIST);
        String listName = mlistNameEditText.getText().toString();
        ChoreList choreList = new ChoreList(listName, "Fernandas List");
        ref.child(Constants.FIREBASE_PROPERTY_LIST_NAME)
                .push()
                .setValue(choreList);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDatabaseReference.removeEventListener(mDatabaseReferenceListener);
    }

}



//mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//@Override
//public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//        }
//        });

