package com.laioffer.vicabulary.ui.playback;

import android.app.AlertDialog;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.media.TimedText;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
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

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.CountedCompleter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaybackFragment<FragmentPlaybackBinding> extends Fragment implements MediaPlayer.OnTimedTextListener,
        MediaPlayer.OnCompletionListener {
    private static final String TAG = "TimedTextTest";
    VideoView vw;
    private TextView txtDisplay;
    private static Handler handler = new Handler();


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
        //videolist.add(R.raw.moana);
        //videolist.add(R.raw.widow);
        //setVideo(videolist.get(0));
        setVideo(R.id.subtitle);
        txtDisplay = (TextView) getActivity().findViewById(R.id.subtitle);
        MediaPlayer player = MediaPlayer.create(getContext(), R.raw.video);
        player.setVolume(0,0);
        try {
            player.addTimedTextSource(getSubtitleFile(R.raw.sub),
                    MediaPlayer.MEDIA_MIMETYPE_TEXT_SUBRIP);
            MediaPlayer.TrackInfo[] trackInfos = player.getTrackInfo();

            if (trackInfos != null && trackInfos.length > 0) {
                for (int i = 0; i < trackInfos.length; i++) {
                    final MediaPlayer.TrackInfo info = trackInfos[i];
                    Log.w(TAG, "TrackInfo:" + info.getTrackType() + " " + info.getLanguage());
                    if (info.getTrackType() == MediaPlayer.TrackInfo.MEDIA_TRACK_TYPE_AUDIO) {

                    }
                    else if (info.getTrackType() == MediaPlayer.TrackInfo.MEDIA_TRACK_TYPE_TIMEDTEXT) {
                        player.selectTrack(i);
                    }
                }

            }

            player.setOnTimedTextListener(this);
            vw.start();
            player.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getSubtitleFile(int resId) {
        String fileName = getResources().getResourceEntryName(resId);
        File subtitleFile = getActivity().getFileStreamPath(fileName);
        if (subtitleFile.exists()) {
            Log.d(TAG, "Subtitle already exists");
            return subtitleFile.getAbsolutePath();
        }
        Log.d(TAG, "Subtitle does not exists, copy it from res/raw");

        // Copy the file from the res/raw folder to your app folder on the
        // device
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = getResources().openRawResource(resId);
            outputStream = new FileOutputStream(subtitleFile, false);
            copyFile(inputStream, outputStream);
            return subtitleFile.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStreams(inputStream, outputStream);
        }
        return "";
    }

    private void closeStreams(Closeable...closeables) {
        if (closeables != null) {
            for (Closeable stream : closeables) {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void copyFile(InputStream inputStream, OutputStream outputStream) throws IOException {
        final int BUFFER_SIZE = 1024;
        byte[] buffer = new byte[BUFFER_SIZE];
        int length = -1;
        while ((length = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
        }
    }


    private void setContentView(int activity_main) {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private void setVideo(Integer id) {
        String uriPath = "android.resource://" + getActivity().getPackageName() + "/" + id;
        Log.d("~~~~Playback Fragment","URi path: " + uriPath);
        Uri uri = Uri.parse(uriPath);
        vw.setVideoURI(uri);
        //vw.start();
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


    public void onCompletion(MediaPlayer mediapalyer)
    {
        AlertDialog.Builder obj = new AlertDialog.Builder(getActivity());
        obj.setTitle("Playback Finished!");
//        obj.setTitle("catloaf");
        obj.setIcon(R.mipmap.ic_launcher);
        MyListener m = new MyListener();
        obj.setPositiveButton("Replay", m);
        obj.setNegativeButton("Next", m);
        obj.setMessage("Want to replay or play next video?");
//        obj.setMessage("A cat loaf is your cat resembling a loaf of bread");
        obj.show();
    }

    @Override
    public void onTimedText(final MediaPlayer mp, final TimedText text) {
        if (text != null) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    int seconds = mp.getCurrentPosition() / 1000;

                    txtDisplay.setText("[" + secondsToDuration(seconds) + "] "
                            + text.getText());
                }
            });
        }
    }

    private String secondsToDuration(int seconds) {
        return String.format("%02d:%02d:%02d", seconds / 3600,
                (seconds % 3600) / 60, (seconds % 60), Locale.US);
    }

    class MyListener implements DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which)
        {
            if (which == -1) {
                vw.seekTo(0);
                vw.start();
            }
            else {
                ++currvideo;
                if (currvideo == videolist.size())
                    currvideo = 0;
                setVideo(videolist.get(currvideo));
            }
        }
    }


}

