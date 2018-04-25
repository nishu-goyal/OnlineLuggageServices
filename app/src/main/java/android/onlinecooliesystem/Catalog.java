package android.onlinecooliesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Catalog extends AppCompatActivity {
    private Spinner city;
    private Spinner station;
    private RadioButton rb_coolie,rb_trolley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        city = (Spinner) findViewById(R.id.City_spinner);
        station = (Spinner) findViewById(R.id.Station_name_spinner);
        rb_coolie = (RadioButton) findViewById(R.id.Coolie_radio_button);
        rb_trolley = (RadioButton) findViewById(R.id.Trolley_radio_button);

        //Adding setOnItemSelectedListener method on spinner.
        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                if (parent.equals(city)) {
                    station.setClickable(true);

                    if(city.getSelectedItem().equals("Hyderabad"))
                    {
                        try {
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        //adding values to spinner
                        final ArrayList<String> dbSpinnerActividad = new ArrayList<String>();
                        dbSpinnerActividad.add("Hyderabad Deccan railway station");
                        station.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, dbSpinnerActividad));

                        station.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                if(station.getSelectedItem().equals("Hyderabad Deccan railway station"))
                                {
                                    Globals globals=(Globals)getApplication();
                                    int priceForKG=3;
                                    globals.setRate(priceForKG);
                                    globals.setTrolley_fare(30);
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }
                    else if(city.getSelectedItem().equals("Banglore"))
                    {
                        try {
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        //adding values to spinner
                        final ArrayList<String> dbSpinnerActividad = new ArrayList<String>();
                        dbSpinnerActividad.add("Whitefield Railway Station(Banglore)");
                        dbSpinnerActividad.add("Bangalore City Railway Station");
                        station.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, dbSpinnerActividad));

                        station.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                if(station.getSelectedItem().equals("Whitefield Railway Station(Banglore)"))
                                {
                                    Globals globals=(Globals)getApplication();
                                    int priceForKG=4;
                                    globals.setRate(priceForKG);
                                    globals.setTrolley_fare(35);
                                }
                                else if(station.getSelectedItem().equals("Bangalore City Railway Station"))
                                {
                                    Globals globals=(Globals)getApplication();
                                    int priceForKG=5;
                                    globals.setRate(priceForKG);
                                    globals.setTrolley_fare(40);
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }
                    else if(city.getSelectedItem().equals("Chennai"))
                    {
                        try {
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        //adding values to spinner
                        final ArrayList<String> dbSpinnerActividad = new ArrayList<String>();
                        dbSpinnerActividad.add("Chennai Central Railway Station");
                        dbSpinnerActividad.add("Chennai Egmore Railway Station");
                        dbSpinnerActividad.add("Chennai Beach Railway Station");
                        dbSpinnerActividad.add("Tambram Railway Station(Chennai)");
                        station.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, dbSpinnerActividad));

                        station.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                if(station.getSelectedItem().equals("Chennai Central Railway Station"))
                                {
                                    Globals globals=(Globals)getApplication();
                                    int priceForKG=3;
                                    globals.setRate(priceForKG);
                                    globals.setTrolley_fare(30);
                                }
                                else if(station.getSelectedItem().equals("Chennai Egmore Railway Station"))
                                {
                                    Globals globals=(Globals)getApplication();
                                    int priceForKG=4;
                                    globals.setRate(priceForKG);
                                    globals.setTrolley_fare(35);
                                }
                                else if(station.getSelectedItem().equals("Chennai Beach Railway Station"))
                                {
                                    Globals globals=(Globals)getApplication();
                                    int priceForKG=5;
                                    globals.setRate(priceForKG);
                                    globals.setTrolley_fare(40);
                                }
                                else if(station.getSelectedItem().equals("Tambram Railway Station(Chennai)"))
                                {
                                    Globals globals=(Globals)getApplication();
                                    int priceForKG=3;
                                    globals.setRate(priceForKG);
                                    globals.setTrolley_fare(30);
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });


    }

    private int select = 0;

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.Coolie_radio_button:
                if (checked) {
                    select = 1;
                    break;
                }
            case R.id.Trolley_radio_button:
                if (checked) {
                    select = 2;
                    break;
                }
        }
    }

    public void nextCatalog(View view) {
        // Do something in response to button click

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (select == 1) {
            Intent it = new Intent(this, Booking_for_coolie.class);
            startActivity(it);
            Toast.makeText(Catalog.this, "Coolie Selected", Toast.LENGTH_SHORT).show();
        }
        if (select == 2) {
            Intent it = new Intent(this, Booking_for_trolley.class);
            startActivity(it);
            Toast.makeText(Catalog.this, "Trolley Selected", Toast.LENGTH_SHORT).show();
        }
    }
}
