package com.epicodus.sharedchoresapp.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.epicodus.sharedchoresapp.Constants;
import com.epicodus.sharedchoresapp.R;
import com.epicodus.sharedchoresapp.fragments.AddChoreListDialogFragment;
import com.epicodus.sharedchoresapp.models.ChoreList;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ChoreListActivity extends AppCompatActivity {

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        /**
//         * Create Firebase references
//         */
//        mUserRef = new Firebase(Constants.FIREBASE_URL_USERS).child(mEncodedEmail);
//
//        /**
//         * Link layout elements from XML and setup the toolbar
//         */
//        initializeScreen();
//
//        /**
//         * Add ValueEventListeners to Firebase references
//         * to control get data and control behavior and visibility of elements
//         */
//        mUserRefListener = mUserRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//                User user = snapshot.getValue(User.class);
//
//                /**
//                 * Set the activity title to current user name if user is not null
//                 */
//                if (user != null) {
//                    /* Assumes that the first word in the user's name is the user's first name. */
//                    String firstName = user.getName().split("\\s+")[0];
//                    String title = firstName + "'s Lists";
//                    setTitle(title);
//                }
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//                Log.e(LOG_TAG,
//                        getString(R.string.log_error_the_read_failed) +
//                                firebaseError.getMessage());
//            }
//        });
//
//    }
//
//
//    /**
//     * Override onOptionsItemSelected to use main_menu instead of BaseActivity menu
//     *
//     * @param menu
//     */
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        /* Inflate the menu; this adds items to the action bar if it is present. */
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    /**
//     * Override onOptionsItemSelected to add action_settings only to the MainActivity
//     *
//     * @param item
//     */
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        /**
//         * Open SettingsActivity with sort options when Sort icon was clicked
//         */
//        if (id == R.id.action_sort) {
//            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        mUserRef.removeEventListener(mUserRefListener);
//    }
//
//    /**
//     * Link layout elements from XML and setup the toolbar
//     */
//    public void initializeScreen() {
//        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
//        setSupportActionBar(toolbar);
//        /**
//         * Create SectionPagerAdapter, set it as adapter to viewPager with setOffscreenPageLimit(2)
//         **/
//        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
//        viewPager.setOffscreenPageLimit(2);
//        viewPager.setAdapter(adapter);
//        /**
//         * Setup the mTabLayout with view pager
//         */
//        tabLayout.setupWithViewPager(viewPager);
//    }
//
//    /**
//     * Create an instance of the AddList dialog fragment and show it
//     */
//    public void showAddListDialog(View view) {
//        /* Create an instance of the dialog fragment and show it */
//        DialogFragment dialog = AddListDialogFragment.newInstance(mEncodedEmail);
//        dialog.show(MainActivity.this.getFragmentManager(), "AddListDialogFragment");
//
//        FragmentManager fm  = getSupportFragmentManager();
////            AddChoreListDialogFragment choreListDialogFragment = new AddChoreListDialogFragment();
//
////            choreListDialogFragment.show(fm, "MyFragment");
//    }
//
//    /**
//     * Create an instance of the AddMeal dialog fragment and show it
//     */
//    public void showAddMealDialog(View view) {
//        /* Create an instance of the dialog fragment and show it */
//        DialogFragment dialog = AddMealDialogFragment.newInstance();
//        dialog.show(MainActivity.this.getFragmentManager(), "AddMealDialogFragment");
//    }


}



