package android.onlinecooliesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Estimated_Fare_Trolley extends AppCompatActivity {

    TextView txt_trolley_fare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimated__fare__trolley);

        txt_trolley_fare = (TextView) findViewById(R.id.txt_fare_trolley);

        double priceForFG;
        int price;

        Globals g = (Globals) getApplication();
        price = g.getTrolley_fare();
        priceForFG = g.getPrice_for_F_G();

        //calculating the total price
        double total_price = price * priceForFG;
        String T_price = Double.toString(total_price);

        //setting the value of textview to total value
        txt_trolley_fare.setText(T_price);
    }

    public void On_confirm_trolley_fare(View view)
    {
        // Do something in response to button click
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Intent it=new Intent(this, trolley_booking_confirmed.class);
        startActivity(it);
        Toast.makeText(this, "Booking Confirmed", Toast.LENGTH_SHORT).show();
    }
    public void On_cancel_cancel_fare(View view)
    {
        // Do something in response to button click
        Globals globals=(Globals) getApplication();
        int nmbr =globals.getNmbr_of_trolleys();
        globals.setNmbr_of_trolleys(nmbr++);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Intent it=new Intent(this, Catalog.class);
        startActivity(it);
        Toast.makeText(this, "Trolley Booking Cancelled", Toast.LENGTH_SHORT).show();
    }
}
