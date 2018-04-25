package android.onlinecooliesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Estimated_Fare extends AppCompatActivity {

    TextView txt_fare;
    Button btn_confirm;
    Button btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimated__fare);

        //get the id's of all text views
        txt_fare=(TextView) findViewById(R.id.txt_fare_coolie);
        btn_confirm =(Button) findViewById(R.id.fare_confirm_btn);
        btn_cancel =(Button) findViewById(R.id.fare_cancel_btn);

        int price;
        double price_f_g;
        int wt_KG;

        Globals g = (Globals) getApplication();
        price = g.getRate();
        price_f_g = g.getPrice_for_F_G();
        wt_KG = g.getWt_in_KGs();

        //calculating the total price
        double total_price = price * price_f_g * wt_KG;
        String T_price = Double.toString(total_price);

        //setting the value of textview to total value
        txt_fare.setText(T_price);
    }

    public void On_confirm_fare(View view)
    {
        // Do something in response to button click
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Intent it=new Intent(this, coolie_booking_confirmed.class);
        startActivity(it);
        Toast.makeText(this, "Booking Confirmed", Toast.LENGTH_SHORT).show();
    }

    public void On_cancel_fare(View view)
    {
        // Do something in response to button click
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Intent it=new Intent(this, Catalog.class);
        startActivity(it);
        Toast.makeText(this, "Booking Cancelled", Toast.LENGTH_SHORT).show();
    }
}
