package lt.cybergear.utils;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by Marius Kavoliūnas on 14.10.6.
 *
 * Util to help finish left behind activities, if you wish to restart app ect.
 *
 * Usage:
 * <pre>
 *      public class MainActivity extends Activity {
 *
 *          private FinishBroadcast.Receiver finishReceiver;
 *
 *          @Override
 *          protected void onCreate(Bundle savedInstanceState) {
 *              super.onCreate(savedInstanceState);
 *              finishReceiver = new FinishBroadcast.Receiver(this);
 *              finishReceiver.register();
 *              ...
 *          }
 *
 *          ...
 *
 *          @Override
 *          protected void onDestroy() {
 *              finishReceiver.unregister();
 *              super.onDestroy();
 *          }
 *
 *      }
 * </pre>
 *
 * colling unregister on onDestroy method ensure that paused activities would be finished too
 *
 * when you want to finish activities just call
 * <pre>
 *     FinishBroadcast.send(Context context);
 * </pre>
 *
 */
public class FinishBroadcast {

    private static final String ACTION_FINISH = "lt.markav.libs.util.ACTION_FINISH";

    public static void send(Context context){
        Intent intent = new Intent(ACTION_FINISH);
        context.sendBroadcast(intent);
    }

    public static class Receiver extends BroadcastReceiver {

        private Activity activity;

        public Receiver(Activity activity) {
            this.activity = activity;
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            activity.finish();
        }

        private IntentFilter getIntentFilter(){
            return new IntentFilter(ACTION_FINISH);
        }

        public void register(){
            activity.registerReceiver(this, getIntentFilter());
        }

        public void unregister(){
            activity.unregisterReceiver(this);
        }

    }
}
