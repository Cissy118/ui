package com.laioffer.vicabulary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Test test test
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    BottomNavigationView navView = findViewById(R.id.nav_view);
    NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
            .findFragmentById(R.id.nav_host_fragment);
    navController =navHostFragment.getNavController();
       NavigationUI.setupWithNavController(navView,navController);
       NavigationUI.setupActionBarWithNavController(this,navController);
}

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }

}
//
//
//// Manyuan
//package com.example.vicabulary;
//
//        import androidx.appcompat.app.AlertDialog;
//        import androidx.appcompat.app.AppCompatActivity;
//
//        import android.content.DialogInterface;
//        import android.media.MediaPlayer;
//        import android.net.Uri;
//        import android.os.Bundle;
//        import android.widget.MediaController;
//        import android.widget.VideoView;
//
//        import java.util.ArrayList;
//        import java.util.List;
//
//public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {
//    VideoView vw;
//    ArrayList<Integer> videolist = new ArrayList<>();
//    int currvideo = 0;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        vw = (VideoView)findViewById(R.id.vidvw);
//        vw.setMediaController(new MediaController(this));
//        vw.setOnCompletionListener(this);
//        videolist.add(R.raw.moana);
//        videolist.add(R.raw.widow);
//        setVideo(videolist.get(0));
//    }
//    public void setVideo(int id){
//        String uriPath = "android.resource://" + getPackageName() +"/" + id ;
//        Uri uri = Uri.parse(uriPath);
//        vw.setVideoURI(uri);
//        vw.start();
//    }
//    public void onCompletion(MediaPlayer mediapalyer) {
//        AlertDialog.Builder obj = new AlertDialog.Builder(this);
//        obj.setTitle("Playback Finished!");
//        obj.setIcon(R.mipmap.ic_launcher);
//        MyListener m = new MyListener();
//        obj.setPositiveButton("Replay", m);
//        obj.setNegativeButton("Next", m);
//        obj.setMessage("Want to replay or play next video?");
//        obj.show();
//    }
//
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
//}
