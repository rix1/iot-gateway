package xyz.rix1.iot_gateway.helpers;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import xyz.rix1.iot_gateway.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rikardeide on 16/03/16.
 *
 */
public class BTDeviceAdapter extends ArrayAdapter<BluetoothDevice> {
    /**
     * Constructor
     *
     * @param context  The current context.
     * @param resource The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     * @param objects  The objects to represent in the ListView.
     */

    private int resource;
    private LayoutInflater inflater;
    private Context context;
    ArrayList<BluetoothDevice> devices;

    public BTDeviceAdapter(Context context, int resource, List<BluetoothDevice> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.devices = (ArrayList<BluetoothDevice>) objects;
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = (RelativeLayout) inflater.inflate(resource, null);

        return null;
    }
}
