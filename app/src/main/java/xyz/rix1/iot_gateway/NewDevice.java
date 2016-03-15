package xyz.rix1.iot_gateway;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.bluetooth.BluetoothClass;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import xyz.rix1.iot_gateway.helpers.DeviceAddedListener;
import xyz.rix1.iot_gateway.helpers.DisplayDeviceDialog;

public class NewDevice extends AppCompatActivity implements OnItemSelectedListener, DeviceAddedListener{

    static final String[] ENDPOINTS = new String[] { "ECG Sensor", "Temperature", "Step Counter"};
    private final static String TAG = NewDevice.class.getSimpleName();
    private Button activate, addDevice;
    private boolean deviceAdded, endpointAdded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_device);

        deviceAdded = endpointAdded = false;

        Log.d(TAG, "onCreate device added: " + deviceAdded + " : " + endpointAdded);

        activate = (Button) findViewById(R.id.btn_activate);
        addDevice = (Button) findViewById(R.id.btn_addDevice);

        activate.setEnabled(false);

        Spinner spinner = (Spinner) findViewById(R.id.endpoint_spinner);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_dropdown_item, ENDPOINTS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        addDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanDevices();
            }
        });

    }

    public void scanDevices(){
        DialogFragment newFragment = new DisplayDeviceDialog();
        newFragment.show(getFragmentManager(), "devicescan");
        deviceAdded = true;
        checkCompleted();
    }

    @Override
    public void handleDialogClose(String msg) {
        Log.d(TAG, "Dialog dismissed.....!!! COMS");
    }


    public void checkCompleted(){
        activate.setEnabled(deviceAdded && endpointAdded);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_device, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG, "Spinner was activated: " + position);
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.d(TAG, "Spinner is DEACTIVATED:");
    }


    public Context getActivity() {
        return getApplicationContext();
    }
}
