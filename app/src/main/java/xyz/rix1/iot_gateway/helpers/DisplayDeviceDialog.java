package xyz.rix1.iot_gateway.helpers;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;

/**
 * Created by rikardeide on 15/03/16.
 * Class that displays nearby devices in a dialogfragment
 *
 */

public class DisplayDeviceDialog extends DialogFragment {


    static final String[] DEBUGDEVICES = new String[] {"Nordic_HRM", "Fitbit Square", "Philips IntelliTemp"};
    private final static String TAG = DisplayDeviceDialog.class.getSimpleName();

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setPositiveButton("Search", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                Activity activity = getActivity();
                if(activity instanceof DeviceAddedListener)
                    ((DeviceAddedListener)activity).handleDialogClose("YOP!");
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.setTitle("Pick endpoint")
                .setItems(DEBUGDEVICES, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG, "onClick device selected: " + which);
                    }
                });
        return builder.create();
    }
}