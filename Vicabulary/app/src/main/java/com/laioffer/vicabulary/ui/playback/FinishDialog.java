package com.laioffer.vicabulary.ui.playback;

import android.app.Dialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.laioffer.vicabulary.R;

public class FinishDialog extends DialogFragment {
    VideoView vw;
    public static FinishDialog newInstance(int videoViewId) {
        FinishDialog fd = new FinishDialog();
        Bundle args = new Bundle();
        args.putInt("video_view_id", videoViewId);
        fd.setArguments(args);
        return fd;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int vwId = getArguments().getInt("video_view_id");
        vw = getActivity().findViewById(vwId);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
        builder.setTitle("Message");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Want to watch again?")
                .setTitle("Video Finished!");
        builder.setPositiveButton(R.string.restart, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                vw.seekTo(0);
                vw.start();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                if(id == -1) {
                    getDialog().dismiss();
                }
            }
        });
        final AlertDialog dialog = builder.create();
        return dialog;
    }


}