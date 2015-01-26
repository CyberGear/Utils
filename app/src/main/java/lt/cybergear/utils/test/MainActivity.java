package lt.cybergear.utils.test;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import lt.cybergear.utils.DecimalDigitsInputFilter;
import lt.cybergear.utils.FinishBroadcast;
import lt.cybergear.utils.Metrics;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FinishBroadcast.send(this);
        Metrics.dpToPx(10);
        DecimalDigitsInputFilter.get(2, 2);
    }
}
