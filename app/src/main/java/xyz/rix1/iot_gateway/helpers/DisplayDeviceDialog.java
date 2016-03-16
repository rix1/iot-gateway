package xyz.rix1.iot_gateway.helpers;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.ArrayAdapter;
import xyz.rix1.iot_gateway.NewDevice;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by rikardeide on 15/03/16.
 * Class that displays nearby devices in a dialogfragment
 *
 */

public class DisplayDeviceDialog extends DialogFragment {


    private ArrayList<BluetoothDevice> deviceList = new ArrayList<>();

    private final static String TAG = DisplayDeviceDialog.class.getSimpleName();
    private ArrayAdapter<BluetoothDevice> adapter;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        Bundle bundle = getArguments();
        if(bundle != null)
        {
            deviceList = bundle.getParcelableArrayList("devices");
//            adapter.setAdapter(new MusicBaseAdapter(getActivity(), listMusics));
        }

        adapter = new ArrayAdapter<BluetoothDevice>(getActivity(), android.R.layout.simple_list_item_1, deviceList);

//        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, deviceList);
//        ArrayList test = getArguments().getParcelableArrayList("endpoint");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setPositiveButton("Search", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button

//                Activity activity = getActivity();
//                if(activity instanceof DeviceAddedListener)
//                    ((DeviceAddedListener)activity).handleDialogClose("YOP!");
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.setTitle("Pick endpoint")
                .setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("FRAGMENT", "SOMEthing klicked :" + which);
                        ((NewDevice)getActivity()).setDevice(which);
                    }
                });

        return builder.create();
    }

    public void update(ArrayList<BluetoothDevice> dev){
        deviceList = dev;
        adapter.notifyDataSetChanged();
    }
}