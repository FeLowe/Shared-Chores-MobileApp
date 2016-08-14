package com.epicodus.sharedchoresapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epicodus.sharedchoresapp.Constants;
import com.epicodus.sharedchoresapp.R;
import com.epicodus.sharedchoresapp.models.ChoreList;
import com.epicodus.sharedchoresapp.ui.MainActivity;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;

/**
 * Created by flowe on 8/12/16.
 */
public class FirebaseChoreListAdapter extends RecyclerView.ViewHolder implements View.OnClickListener{

    View mView;
    Context mContext;

    public FirebaseChoreListAdapter(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindChoreList(final ChoreList choreList) {
        TextView listName = (TextView) mView.findViewById(R.id.addedChoreTextView);
        TextView owner = (TextView) mView.findViewById(R.id.ownerTextView);

        listName.setText(choreList.getListName());
        owner.setText(choreList.getOwner());

        mView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        final ArrayList<ChoreList> choreListArrayList = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_PROPERTY_LIST_NAME);

        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    choreListArrayList.add(snapshot.getValue(ChoreList.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, MainActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("ChoreList", Parcels.wrap(choreListArrayList));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
