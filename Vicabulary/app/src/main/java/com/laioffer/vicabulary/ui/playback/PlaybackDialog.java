package com.laioffer.vicabulary.ui.playback;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.laioffer.vicabulary.R;

public class PlaybackDialog extends DialogFragment {
    String url;
    String dialog_message;
    String dialog_title;
    DatabaseHelper db;


    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        db = MainActivity.videoDb;
//        builder.setMessage(R.string.dialog_message)
//                .setTitle(R.string.dialog_title);
        builder.setMessage("catloaf is a loaf of cat")
                .setTitle("catloaf");
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                public void saveWord(String word, String explanation, String path){
                     if(db.getWord(word).getWord() == null) {
                    int time = vw.getCurrentPosition();
                    db.insertWord(word, time, explanation, path);
            }

    }
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

    private String dictionaryEntries(String input) {
        final String language = "en-gb";
        final String word = input;
        final String fields = "definitions";
        final String strictMatch = "false";
        final String word_id = word.toLowerCase();
        return "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/" + word_id + "?" + "fields=" + fields + "&strictMatch=" + strictMatch;
    }


    public void getDefinition(String input) {
//        DictionaryRequest dR = new DictionaryRequest(this, showDef);
        DictionaryRequest dR = new DictionaryRequest(input, dialog_message);
        url = dictionaryEntries(input);
        dR.execute(url);
        Log.i("result :", dialog_message);
    }


}
