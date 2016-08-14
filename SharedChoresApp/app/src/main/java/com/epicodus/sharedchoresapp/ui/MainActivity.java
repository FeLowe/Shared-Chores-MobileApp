package com.epicodus.sharedchoresapp.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.sharedchoresapp.Constants;
import com.epicodus.sharedchoresapp.R;
import com.epicodus.sharedchoresapp.adapters.FirebaseChoreListAdapter;
import com.epicodus.sharedchoresapp.fragments.AddChoreListDialogFragment;
import com.epicodus.sharedchoresapp.models.ChoreList;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseReference mChoreListReference;
    private FirebaseListAdapter mFirebaseAdapter;
    private String mListName;
    ArrayList<String> mChoreListArray = new ArrayList<>();


    @Bind(R.id.addChoreListButton)
    Button mAddChoreListButton;
    //    @Bind(R.id.buttonSave) Button mButtonSave;
    @Bind(R.id.listView)
    TextView mListView;
//    @Bind(R.id.choreListNameEditText) EditText mChoreListNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mAddChoreListButton.setOnClickListener(this);

        mChoreListReference = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_CHORE_LIST);

            mChoreListReference.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        ChoreList newChoreList = dataSnapshot.getValue(ChoreList.class);
                        mListView.setText(newChoreList.getListName());
                    }
//                    if (mChoreListArray.size() > 0) {
//                        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, mChoreListArray);
//                        mListView.setAdapter(adapter);
//                        adapter.notifyDataSetChanged();
//                    } else {
//                        Toast.makeText(MainActivity.this, "No Data", Toast.LENGTH_SHORT).show();
                }
                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });
        }

    @Override
    public void onClick(View view) {
        if (view == mAddChoreListButton) {
            showChoreListDialog();
        }
    }


    private void showChoreListDialog() {
//
        DialogFragment dialog = AddChoreListDialogFragment.newInstance();
        dialog.show(MainActivity.this.getSupportFragmentManager(), "AddChoreListDialogFragment");
    }


//                // Use the Builder class for convenient dialog construction
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                // Get the layout inflater
//                LayoutInflater inflater = MainActivity.this.getLayoutInflater();
//                View rootView = inflater.inflate(R.layout.input_dialog, null);
//                mChoreListNameEditText = (EditText) rootView.findViewById(R.id.choreListNameEditText);
//
//                builder.setView(rootView)
//                /* Add action buttons */
//                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                            // do something
//                            @Override
//                            public void onClick(DialogInterface dialog, int id) {
//
//                            }
//                        })
//                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                            // Do nothing
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                            }
//                        });
//
//                return builder.create();
//            }
//
//                mButtonSave.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        addChoreList2();
//                        setUpFirebaseAdapter();
//                    }
//                });
//                builder.create();
//            }
//
//            public void addChoreList2() {
//
//                String listName = mChoreListNameEditText.getText().toString();
//                String owner = "Fernanda";
//
//                ChoreList newChoreList = new ChoreList(listName, owner);
//                newChoreList.getListName();
//                newChoreList.getOwner();
//
//                mChoreListReference.child(Constants.FIREBASE_PROPERTY_LIST_NAME)
//                        .push().setValue(newChoreList);
//            }

    //        DialogFragment dialog = AddChoreListDialogFragment.newInstance();
//        dialog.show(MainActivity.this.getSupportFragmentManager(), "AddChoreListDialogFragment");




}


