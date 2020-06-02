package com.laioffer.vicabulary.ui.playback;
import androidx.annotation.Nullable;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import android.widget.MediaController;

import android.widget.VideoView;

import androidx.fragment.app.DialogFragment;
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
public class PlaybackFragment<FragmentPlaybackBinding> extends Fragment
        implements MediaPlayer.OnCompletionListener {

    VideoView vw;

    private ArrayList<Integer> videolist = new ArrayList<>();
    private int currvideo = 0;
    private FragmentPlaybackBinding binding;


    public PlaybackFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vw = (VideoView) view.findViewById(R.id.vidvw);
        vw.setMediaController(new MediaController(getActivity()));
        videolist.add(R.raw.moana);
        videolist.add(R.raw.widow);
        vw.setOnCompletionListener(this);
        setVideo(videolist.get(0));
    }

    public void onCompletion(MediaPlayer mp) {
        Log.d("PlaybackFragment","~~~~~~~~~~~~~~~~~~~onCompletion");
//        DialogFragment df = FinishDialog.newInstance(R.id.vidvw);
//        df.show(getFragmentManager(), "dialog");
        DialogFragment df = WordDialog.newInstance(R.id.vidvw);
        df.show(getFragmentManager(), "dialog");
    }
    private void setContentView(int activity_main) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setVideo(Integer id) {
        String uriPath = "android.resource://" + getActivity().getPackageName() + "/" + id;
        Log.d("~~~~Playback Fragment", "URi path: " + uriPath);
        Uri uri = Uri.parse(uriPath);
        vw.setVideoURI(uri);
        vw.start();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_playback, container, false);
    }
}