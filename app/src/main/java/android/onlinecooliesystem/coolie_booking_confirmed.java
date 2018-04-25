package android.onlinecooliesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class coolie_booking_confirmed extends AppCompatActivity {

    TextView CoolieName;
    TextView CoolieId;
    TextView Cooliephn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coolie_booking_confirmed);

        //get the id's of all text views
        CoolieName = (TextView) findViewById(R.id.txt_coolie_name);
        CoolieId = (TextView) findViewById(R.id.txt_id);
        Cooliephn = (TextView) findViewById(R.id.txt_coolie_phn);

        String[] c_name = {"Raju","Shyam","Rahul","abc","Sawant","Ravi","Mohinder","Kaka"};
        String[] c_phn = {"9078563412","9087654321","7458961230","1234567891","8697549345","6068383937","7895046376","9775849429"};
        String[] c_id = {"3","4","2","1","5","6","7","8"};

        int c_name_length = c_name.length;

        int ran = (int) (Math.random() * c_name_length);

        //setting the text for textviews
        CoolieName.setText(c_name[ran]);
        CoolieId.setText(c_id[ran]);
        Cooliephn.setText(c_phn[ran]);
    }
    public void done_btn(View view)
    {
        //on done button click do this
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Toast.makeText(this, "Booking Confirmed", Toast.LENGTH_SHORT).show();
    }
    public void exit_btn(View view)
    {
        //on exit button click we exit from our app
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);

        Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show();
    }
}
