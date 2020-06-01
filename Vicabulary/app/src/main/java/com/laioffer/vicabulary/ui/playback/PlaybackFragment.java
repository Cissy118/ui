package com.laioffer.vicabulary.ui.playback;

import android.app.AlertDialog;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
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
public class PlaybackFragment<FragmentPlaybackBinding> extends Fragment implements MediaPlayer.OnCompletionListener {

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
        vw.setOnCompletionListener(this);
        videolist.add(R.raw.moana);
        videolist.add(R.raw.widow);
        setVideo(videolist.get(0));
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

//        vw.setMediaController(new MediaController(getActivity()));
//        vw.setOnCompletionListener(this);
//        videolist.add(R.raw.moana);
//        videolist.add(R.raw.widow);
//        setVideo(videolist.get(0);
    }


    public void onCompletion(MediaPlayer mediapalyer) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Playback Finished!");
        builder.setMessage("Want to replay or play next video?");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setPositiveButton(R.string.restart, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (id == -1) {
                    vw.seekTo(0);
                    vw.start();
                }
            }
        });


        builder.setNegativeButton(R.string.next, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                ++currvideo;
                if (currvideo == videolist.size())
                    currvideo = 0;
                setVideo(videolist.get(currvideo));
            }

        });
        builder.create().show();


//    class MyListener implements DialogInterface.OnClickListener {
//        public void onClick(DialogInterface dialog, int which)
//        {
//            if (which == -1) {
//                vw.seekTo(0);
//                vw.start();
//            }
//            else {
//                ++currvideo;
//                if (currvideo == videolist.size())
//                    currvideo = 0;
//                setVideo(videolist.get(currvideo));
//            }
//        }
//    }


    }
}