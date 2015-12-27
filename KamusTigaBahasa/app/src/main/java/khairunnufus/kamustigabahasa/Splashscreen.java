package khairunnufus.kamustigabahasa;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;




public class Splashscreen extends Activity {

    protected boolean _active = true;

    protected int _splashTime = 9000;



    /** Called when the activity is first created. */

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_splashscreen);



        // thread for displaying the SplashScreen

        Thread splashTread = new Thread() {

            @Override

            public void run() {

                try {

                    int waited = 0;

                    while(_active && (waited < _splashTime)) {

                        sleep(100);

                        if(_active) {

                            waited += 100;

                        }

                    }

                } catch(InterruptedException e) {

                    // do nothing

                } finally {

                    finish();

                    Intent newIntent=new Intent(Splashscreen.this,MainActivity.class);

                    startActivityForResult(newIntent,0);

                }

            }

        };

        splashTread.start();

    }



    @Override

    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            _active = false;

        }

        return true;

    }

}