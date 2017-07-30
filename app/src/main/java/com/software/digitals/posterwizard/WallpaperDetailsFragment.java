package com.software.digitals.posterwizard;

/**
 * Created by mitch on 7/29/2017.
 */

import android.app.WallpaperManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class WallpaperDetailsFragment extends Fragment {
    private static final String ARGUMENT_IMAGE_RES_ID = "imageResId";
    private static final String ARGUMENT_NAME = "name";
    private static final String ARGUMENT_URL = "url";
    //2
    private WallpaperListFragment.OnWallpaperSelected mListener;

    public static WallpaperDetailsFragment newInstance(int imageResId, String name, String url) {

        final Bundle args = new Bundle();
        args.putInt(ARGUMENT_IMAGE_RES_ID, imageResId);
        args.putString(ARGUMENT_NAME, name);
        args.putString(ARGUMENT_URL, url);
        final WallpaperDetailsFragment fragment = new WallpaperDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    //3
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_wallpaper_details, container, false);
        final ImageView imageView = (ImageView) view.findViewById(R.id.wallpaper_image);
        final TextView nameTextView = (TextView) view.findViewById(R.id.wallpaper_name);

        final Bundle args = getArguments();
        imageView.setImageResource(args.getInt(ARGUMENT_IMAGE_RES_ID));
        nameTextView.setText(args.getString(ARGUMENT_NAME));

        // set the onClick listener for pressing the apply button to the wallpaper
        Button button = (Button) view.findViewById(R.id.apply_wallpaper);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setWallpaper();
            }
        });

        return view;
    }


    public void setWallpaper() {
        // get the args and context for this wallpaper
        Bundle args = getArguments();
        Context context = getContext();

        // set the wallpaper
        WallpaperManager myWallpaperManager
                = WallpaperManager.getInstance(context);
        try {
            myWallpaperManager.setResource(args.getInt(ARGUMENT_IMAGE_RES_ID));
            Toast.makeText(context, "Wallpaper applied!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
