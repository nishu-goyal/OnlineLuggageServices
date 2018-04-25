package android.coolieinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Passenger_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_info);
    }

    public void Done_button(View view)
    {
        // Do something in response to button click
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Toast.makeText(this, "Request Completed", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,confirmation_page.class);
        startActivity(intent);
    }
}
