package xyz.rix1.iot_gateway;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity  {

    private Toolbar mToolbar;

    private CoordinatorLayout coordinatorLayout;
    private Button btnSimpleSnackbar, btnActionCallback, btnCustomView;
    private ImageButton fab;

    static final String[] DEVICES = new String[] { "ECG Sensor", "Temperature", "Step Counter"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLayout);

        fab = (ImageButton) findViewById(R.id.fab);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, DEVICES);
        ListView lv = (ListView)findViewById(android.R.id.list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> a, View v,int position, long id)
            {
                Toast.makeText(getBaseContext(), "Click", Toast.LENGTH_LONG).show();
            }
        });

        setSupportActionBar(mToolbar);

        btnSimpleSnackbar = (Button) findViewById(R.id.btnSimpleSnackbar);
        btnActionCallback = (Button) findViewById(R.id.btnActionCallback);
        btnCustomView = (Button) findViewById(R.id.btnCustomSnackbar);

        fab.setOnClickListener(new ImageButton.OnClickListener(){

            @Override
            public void onClick(View v) {

                addDevice();
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Penger penger pang pang pang", Snackbar.LENGTH_SHORT);

                snackbar.show();
            }
        });

        btnSimpleSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Welcome to AndroidHive", Snackbar.LENGTH_LONG);

                snackbar.show();
            }
        });

        btnActionCallback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Message is deleted", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "Message is restored!", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });

                snackbar.show();
            }
        });

        btnCustomView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "No internet connection!", Snackbar.LENGTH_LONG)
                        .setAction("RETRY", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        });

                // Changing message text color
                snackbar.setActionTextColor(Color.RED);

                // Changing action button text color
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);

                snackbar.show();
            }
        });
    }

    public void addDevice(){
        Intent intent = new Intent(this, NewDevice.class);
//        EditText editText = (EditText) findViewById(R.id.edit_message);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}

