package example.com.fabanimation;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton Share, Msg, Map, Info;

    Animation open, close, clock, anti_clock;

    boolean b = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Share = (FloatingActionButton)findViewById(R.id.share);
        Msg = (FloatingActionButton)findViewById(R.id.msg);
        Map = (FloatingActionButton)findViewById(R.id.map);
        Info = (FloatingActionButton)findViewById(R.id.info);

        open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);

        clock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        anti_clock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);

        Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!b){
                    Msg.startAnimation(open);
                    Msg.setClickable(true);
                    Map.startAnimation(open);
                    Map.setClickable(true);
                    Info.startAnimation(open);
                    Info.setClickable(true);
                    Share.startAnimation(clock);
                    b=true;
                }else{
                    Msg.startAnimation(close);
                    Msg.setClickable(false);
                    Map.startAnimation(close);
                    Map.setClickable(false);
                    Info.startAnimation(close);
                    Info.setClickable(false);
                    Share.startAnimation(anti_clock);
                    b=false;
                }
            }
        });

        Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Open Maps", Toast.LENGTH_SHORT).show();
            }
        });
        Msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Open Messages", Toast.LENGTH_SHORT).show();
            }
        });
        Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Open Device Info", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
