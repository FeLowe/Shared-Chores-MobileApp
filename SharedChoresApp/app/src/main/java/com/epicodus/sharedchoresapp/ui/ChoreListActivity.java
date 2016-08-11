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
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseReference;
    private ValueEventListener mDatabaseReferenceListener;

    ArrayList<String> mGroups = new ArrayList<>();

    @Bind(R.id.addGroupButton)
    Button mAddGroupButton;
    @Bind(R.id.addGroupTextView)
    TextView mAddGroupTextView;
    @Bind(R.id.groupNameEditText)
    EditText mGroupNameEditText;
    @Bind(R.id.groupNameListView)
    ListView mGroupNameListView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chore_list);
        ButterKnife.bind(this);
        mAddGroupButton.setOnClickListener(this);

//        mDatabase = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_PROPERTY_GROUP_NAME);
//        public void showGroup() {

         adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mGroups);
        mGroupNameListView.setAdapter(adapter);

        mDatabaseReference = FirebaseDatabase
                .getInstance().getReference()
                .child(Constants.FIREBASE_CHILD_GROUPS);

         mDatabaseReferenceListener = mDatabaseReference.addValueEventListener(new ValueEventListener() {

//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                String groupName = dataSnapshot.getValue(String.class);
////                mGroupNameListView.setText(groupName);
//                mGroups.add(groupName);
////                adapter.notifyDataSetChanged();

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Log.d("TAG", "THE DATA HAS CHANGED");
//

                    String groupName = snapshot.getValue().toString();

//
                    mGroups.add(groupName);
                adapter.notifyDataSetChanged();
//                    mGroupNameListView.setText(groupName);
                }
            }

                @Override
                public void onCancelled (DatabaseError databaseError){
////
//            }
                }

//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//                String groupName = dataSnapshot.getValue(String.class);
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//                String groupName = dataSnapshot.getValue(String.class);
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }


        });
    }

    @Override
    public void onClick(View v) {
        if (v == mAddGroupButton) {
            addGroup();
//            showGroup();
        }

    }

    public void addGroup() {

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_CHILD_GROUPS);
        String groupName = mGroupNameEditText.getText().toString();
        ref.child(Constants.FIREBASE_PROPERTY_GROUP_NAME)
                .push()
                .setValue(groupName);

//        DatabaseReference pushRef = ref.push();
//        ref.setValue(groupName);
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

