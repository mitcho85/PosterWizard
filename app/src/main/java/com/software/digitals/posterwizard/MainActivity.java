package com.software.digitals.posterwizard;

import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    // retreive the fragment, and get it's text view
                    setFragmentText("myFragment", R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    // retreive the fragment, and get it's text view
                    setFragmentText("myFragment", R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    // retreive the fragment, and get it's text view
                    setFragmentText("myFragment", R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    private void setFragmentText(String fragId, int strResId) {
        android.app.FragmentManager manager = getFragmentManager();
        MyFragment myFrag = (MyFragment) manager.findFragmentByTag(fragId);
        myFrag.setmTextMessage(strResId);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);

        // Set the on click listener for the bottom bar
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // go get the image
        Uri uri = Uri.parse("http://i.imgur.com/1DGw7dS.jpg");
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        draweeView.setImageURI(uri);

        // Create the fragment manager, add the fragment
        MyFragment mFragment = new MyFragment();
        android.app.FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.content, mFragment, "myFragment");
        transaction.commit();

        // TODO remove fragment on click.

    }

}
