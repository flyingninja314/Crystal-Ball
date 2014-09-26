package android.wrightd.crystalball;
/*
wow look at all these things to import
also these commented "w"'s look weird
how do you spell "w"?
double-yoo?
anyways, these imports show the android. whatever that are needed for functions and such
 */
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.FloatMath;
import android.widget.TextView;
import android.widget.Toast;
import android.media.MediaPlayer;


public class CrystalBall extends Activity {

    private TextView answerText;

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private float acceleration;
    private float currentAcceleration;
    private float previousAcceleration;

    private final SensorEventListener sensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            /*
            wow physics this is cool
            i love doing this on paper but it's even cooler that i can teach my computer to do this
             */
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            previousAcceleration = currentAcceleration;
            currentAcceleration = FloatMath.sqrt(x * x + y * y + z * z);
            float delta = currentAcceleration - previousAcceleration;
            acceleration = 0.9f + delta;

            if(acceleration > 15){
                /*
                if i knew how to run this on the tablet I would know what Toast is, but i don't...i should ask now
                 */
                Toast toast = Toast.makeText(getApplication(), "Device has shaken", Toast.LENGTH_SHORT);
                toast.show();
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.crystal_ball);
                mediaPlayer.start();
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
/*
    nothing coded in milestone 17 video
    it was literally just a chart and explaining how an app is run
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crystal_ball);

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
/*
whoo hoo setting up gravity situations and such so we can know if the device has been shaken or not
 */
        acceleration = 0.0f;
        currentAcceleration = SensorManager.GRAVITY_EARTH;
        previousAcceleration = SensorManager.GRAVITY_EARTH;

                /*
                    yaay getting the predictions
                 */
        answerText = (TextView) findViewById(R.id.answerText);
        answerText.setText(Predictions.get().getPrediction());
    }

    @Override
    protected void onResume() {
        /*
        every time the device starts the app -> begins sensor to tell if shaken or not
         */
        super.onResume();
        sensorManager.registerListener(sensorListener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        /*
        dont waste battery -> stop sensor
         */
        super.onPause();
        sensorManager.unregisterListener(sensorListener);
    }
}
/*
okay i hope this is what you meant by commenting because this is how i have als
 */