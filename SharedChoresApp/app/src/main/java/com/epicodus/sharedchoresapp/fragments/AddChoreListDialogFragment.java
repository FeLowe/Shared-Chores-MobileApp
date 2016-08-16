package com.epicodus.sharedchoresapp.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.sharedchoresapp.Constants;
import com.epicodus.sharedchoresapp.R;
import com.epicodus.sharedchoresapp.models.ChoreList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddChoreListDialogFragment extends DialogFragment {

    EditText mChoreListNameEditText;
    EditText mOwnerNameEditText;


    /**
     * Public static constructor that creates fragment and
     * passes a bundle with data into it when adapter is created
     */
    public static AddChoreListDialogFragment newInstance() {
        AddChoreListDialogFragment choreListDialogFragment = new AddChoreListDialogFragment();
        Bundle bundle = new Bundle();
        choreListDialogFragment.setArguments(bundle);
        return choreListDialogFragment;
    }

    /**
     * Initialize instance variables with data from bundle
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    /**
     * Open the keyboard automatically when the dialog fragment is opened
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View rootView = inflater.inflate(R.layout.input_dialog, null);
        mChoreListNameEditText = (EditText) rootView.findViewById(R.id.choreListNameEditText);
//        mOwnerNameEditText = (EditText) rootView.findViewById(R.id.ownerNameEditText);


        /**
         * Call addShoppingList() when user taps "Done" keyboard action
         */
        mChoreListNameEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE || keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    addChoreList();
                }
                return true;
            }
        });
//
//        mOwnerNameEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
//                if (actionId == EditorInfo.IME_ACTION_DONE || keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
//                    addChoreList();
//                }
//                return true;
//            }
//        });

        /* Inflate and set the layout for the dialog */
        /* Pass null as the parent view because its going in the dialog layout*/
        builder.setView(rootView)
                /* Add action buttons */
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    // do something
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        addChoreList();
//                        setUpFirebaseAdapter();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    // Do nothing
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        return builder.create();
    }

    public void addChoreList() {

        DatabaseReference choreListRef = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_CHILD_CHORE_LIST).push();
        String listName = mChoreListNameEditText.getText().toString().trim();

        /* Build the shopping list */
        ChoreList newChoreList = new ChoreList(listName, "created by: Fernanda");
        String pushId = choreListRef.getKey();
        newChoreList.setChoreListId(pushId);
        choreListRef.setValue(newChoreList);
//        choreListRef.push()
//
//
//                .setValue(newChoreList);

        HashMap<String, Object> choreListMap = (HashMap<String, Object>)
                new ObjectMapper().convertValue(newChoreList, Map.class);

//        DatabaseReference pushRef = ref.push();
//        String choreId = pushRef.getKey();
//        mChoreList.setChoreListId(choreId);
//        pushRef.setValue(mChoreList);

    }

}



