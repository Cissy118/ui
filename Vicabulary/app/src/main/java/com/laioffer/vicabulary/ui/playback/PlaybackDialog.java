package com.laioffer.vicabulary.ui.playback;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.laioffer.vicabulary.R;

public class PlaybackDialog extends DialogFragment {
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

//        builder.setMessage(R.string.dialog_message)
//                .setTitle(R.string.dialog_title);
        builder.setMessage("catloaf is a loaf of cat")
                .setTitle("catloaf");
       builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });
        // Create the AlertDialog object and return it
        return builder.create();
    }
    public void capture() {
        DialogFragment newFragment = new PlaybackDialog();
        newFragment.show(getFragmentManager(), "missiles");
    }
    private class dialog_content{
        String dialog_message;
        String dialog_title;
    }


}
