package android.coolieinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Request extends AppCompatActivity {
    TextView textView;
    Button accept,reject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        textView = (TextView) findViewById(R.id.req_msg);
        accept = (Button) findViewById(R.id.Caccpet);
        reject = (Button) findViewById(R.id.Ccancel);

        //String[] arr = {"A New Request Is There","No Request"};
        String[] arr = {"A New Request Is There"};
        int arr_len = arr.length;
        int ran = (int) (Math.random() * arr_len);

        textView.setText(arr[ran]);
        if(ran==1)
        {
            accept.setVisibility(View.GONE);
            reject.setVisibility(View.GONE);
        }
    }

    public void Caccept_button(View view)
    {
        // Do something in response to button click
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Toast.makeText(this, "Request Accepted", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Passenger_info.class);
        startActivity(intent);
    }

    public void Ccancel_btn(View view)
    {
        // Do something in response to button click
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
        Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show();
    }
}
