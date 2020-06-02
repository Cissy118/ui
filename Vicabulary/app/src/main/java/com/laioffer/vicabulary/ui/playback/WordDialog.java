package com.laioffer.vicabulary.ui.playback;

import android.app.Dialog;
import android.content.DialogInterface;

import android.os.Bundle;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.laioffer.vicabulary.R;
import com.laioffer.vicabulary.database.DatabaseHelper;

public class WordDialog extends DialogFragment {
    VideoView vw;
    String url;
    String explanation;

    public static WordDialog newInstance(int videoViewId) {
        WordDialog wd = new WordDialog();
        Bundle args = new Bundle();
        args.putInt("video_view_id", videoViewId);
        wd.setArguments(args);
        return wd;
        //TODO : stop video when capture a word
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int vwId = getArguments().getInt("video_view_id");
        vw = getActivity().findViewById(vwId);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
        builder.setTitle("Message");
        builder.setIcon(R.mipmap.ic_launcher);
        //TODO : Capture word as a title
        builder.setTitle("pudding");
        //TODO : put your explanation in setMessage
        getDefinition("pudding");
        builder.setMessage(explanation);

        builder.setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                //TODO : save to word database
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
    private String dictionaryEntries(String input) {
        final String language = "en-gb";
        final String word = input;
        final String fields = "definitions";
        final String strictMatch = "false";
        final String word_id = word.toLowerCase();
        return "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/"
                + word_id + "?" + "fields=" + fields + "&strictMatch=" + strictMatch;
    }

    public void getDefinition(String input) {
        DictionaryRequest dR = new DictionaryRequest(input, explanation);
        url = dictionaryEntries(input);
        dR.execute(url);
    }



}
