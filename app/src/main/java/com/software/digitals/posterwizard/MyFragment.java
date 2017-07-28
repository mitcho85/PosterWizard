package com.software.digitals.posterwizard;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by mitch on 7/26/2017.
 */

public class MyFragment extends Fragment {
    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mTextView = (TextView) getView().findViewById(R.id.fragTextView);
        super.onViewCreated(view, savedInstanceState);
    }

    public void setmTextMessage(int strResId) {
        this.mTextView.setText(strResId);
    }

}
