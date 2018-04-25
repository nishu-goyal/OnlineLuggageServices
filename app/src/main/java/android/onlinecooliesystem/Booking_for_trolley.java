package android.onlinecooliesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;


public class Booking_for_trolley extends AppCompatActivity {

    Spinner spin_come_go;
    Spinner spin_trolley_loc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_for_trolley);

        spin_come_go = (Spinner) findViewById(R.id.spin_come_go_trolley);

        //on selecting the item of spin_come_go
        spin_come_go.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin_trolley_loc = (Spinner) findViewById(R.id.spin_loc_trolley);

        //on selecting the item of spin_trolley_loc
        spin_trolley_loc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spin_trolley_loc.getSelectedItem().equals("Front Gate")){
                    Globals globals=(Globals) getApplication();
                    double priceForFrontBack=1.5;
                    globals.setPrice_for_F_G(priceForFrontBack);
                }
                else if(spin_trolley_loc.getSelectedItem().equals("Back Gate")){
                    Globals globals=(Globals) getApplication();
                    double priceForFrontBack=1;
                    globals.setPrice_for_F_G(priceForFrontBack);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void trolley_done_btn(View view)
    {
        //on click of done button to the following
        Globals globals=(Globals) getApplication();
        int nmbr =globals.getNmbr_of_trolleys();
        if(nmbr !=0)
        {
            globals.setNmbr_of_trolleys(nmbr--);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Intent it=new Intent(this, Estimated_Fare_Trolley.class);
            startActivity(it);
            Toast.makeText(this, "Estimated Fare For Trolley", Toast.LENGTH_SHORT).show();
        }
    }
}

