package gis2018.udacity.pomodoro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String LOG_TAG = "pomodoro Issue-1 Test";
    private static final long TIME_PERIOD = 5000; // Time Period is 5 seconds
    private static final long TIME_INTERVAL = 1000; // Time Interval is 1 second
    private static final String COUNTDOWN_FINISHED_MESSAGE = "CountDown Finished";

    @BindView(R.id.settings_button_main)
    Button settingsButton;
    @BindView(R.id.task_change_button_main)
    Button changeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        settingsButton.setOnClickListener(this);
        changeButton.setOnClickListener(this);

        Intent serviceIntent = new Intent(this, CountDownTimerService.class);
        serviceIntent.putExtra("time_period", TIME_PERIOD);
        serviceIntent.putExtra("time_interval", TIME_INTERVAL);
        startService(serviceIntent);
    }

    @Override
    public void onClick(View v) {
        // switch case to handle different button clicks
        switch (v.getId()) {
            // Settings button is clicked
            case R.id.settings_button_main:
                // launch SettingsActivity
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.task_change_button_main:
                // Todo: Define on task change
                break;
            default:

        }
    }
}
