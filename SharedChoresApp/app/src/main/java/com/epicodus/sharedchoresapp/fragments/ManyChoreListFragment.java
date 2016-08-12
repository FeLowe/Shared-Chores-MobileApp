package com.epicodus.sharedchoresapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.epicodus.sharedchoresapp.Constants;
import com.epicodus.sharedchoresapp.R;
import com.epicodus.sharedchoresapp.models.ChoreList;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.ButterKnife;


public class ManyChoreListFragment extends Fragment {
    private ListView mListView;
    private ListView  choreListLists;
    private TextView choreListTextView;
    private TextView ownerTextView;
    private DatabaseReference mDatabaseReference;
    private ValueEventListener mDatabaseReferenceListener;

    public ManyChoreListFragment() {

    }

    public static ManyChoreListFragment newInstance() {
        ManyChoreListFragment fragment = new ManyChoreListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /**
         * Initalize UI elements
         */
        View rootView = inflater.inflate(R.layout.fragment_many_chore_list, container, false);

        initializeScreen(rootView);

//        choreListLists = (ListView) rootView.findViewById(R.id.choreListLists);
        choreListTextView = (TextView) rootView.findViewById(R.id.choreListTextView);
        ownerTextView = (TextView) rootView.findViewById(R.id.ownerTextView);


        mDatabaseReference = FirebaseDatabase
                .getInstance().getReference()
                .child(Constants.FIREBASE_PROPERTY_LIST_NAME);

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("TAG", "DATA HAS CHANGED");
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    ChoreList newChoreList = snapshot.getValue(ChoreList.class);
                    choreListTextView.setText(newChoreList.getListName());
                    ownerTextView.setText(newChoreList.getOwner());


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return rootView;
    }




        /**
         * Set interactive bits, such as click events and adapters
         */
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });


    @Override
    public void onDestroy() {
        super.onDestroy();
        mDatabaseReference.removeEventListener(mDatabaseReferenceListener);
    }

    private void initializeScreen(View rootView) {
        choreListTextView = (TextView) rootView.findViewById(R.id.choreListTextView);
    }


}
