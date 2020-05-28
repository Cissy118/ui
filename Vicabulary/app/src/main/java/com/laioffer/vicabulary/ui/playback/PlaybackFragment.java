package com.laioffer.vicabulary.ui.playback;

import android.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.laioffer.vicabulary.R;

import java.util.ArrayList;
import java.util.concurrent.CountedCompleter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaybackFragment<FragmentHomeBinding> extends Fragment implements MediaPlayer.OnCompletionListener {

    VideoView vw;
    private ArrayList<Integer> videolist = new ArrayList<>();
    private int currvideo = 0;
    private FragmentHomeBinding binding;


    public PlaybackFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vw = (VideoView) vw.findViewById();
        vw.setMediaController(new MediaController(this));
        vw.setOnCompletionListener(this);
        videolist.add(R.raw.moana);
        videolist.add(R.raw.widow);
        setVideo(videolist.get(0));
    }

    private void setContentView(int activity_main) {
    }

    private void setVideo(Integer id) {
        String uriPath = "android.resource:" + getPackageName() + "/" + id;
        Uri uri = Uri.parse(uriPath);
        vw.setVideoURI(uri);
        vw.start();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        CountedCompleter binding = FragmentHomeBinding.inflate(inflater, container, false);
             return binding.getRoot();
    }


}

