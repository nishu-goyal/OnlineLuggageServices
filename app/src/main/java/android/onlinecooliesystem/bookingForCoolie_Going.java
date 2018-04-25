package android.onlinecooliesystem;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class bookingForCoolie_Going extends Fragment {

    Button btn_going_save;
    Button btn_going_cancel;

    EditText text_train_number;
    EditText text_platform;
    Spinner spinner_luggage;
    EditText text_wt;
    Spinner spinner_loc;

    public bookingForCoolie_Going() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_booking_for_coolie__going, container, false);

        text_train_number = (EditText) view.findViewById(R.id.txt_going_train_nmbr);
        text_platform = (EditText) view.findViewById(R.id.txt_going_platform);
        text_wt = (EditText) view.findViewById(R.id.txt_going_weight);

        spinner_luggage = (Spinner) view.findViewById(R.id.spin_going_number_luggage);
        //on selecting the item of spin_luggage
        spinner_luggage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_loc = (Spinner) view.findViewById(R.id.spin_going_loc);
        //on selecting the item of spin_loc
        spinner_loc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinner_loc.getSelectedItem().equals("Front Gate")){
                    Globals globals=(Globals) getActivity().getApplication();
                    double priceForFrontBack=1.5;
                    globals.setPrice_for_F_G(priceForFrontBack);
                }
                else if(spinner_loc.getSelectedItem().equals("Back Gate")){
                    Globals globals=(Globals) getActivity().getApplication();
                    double priceForFrontBack=1;
                    globals.setPrice_for_F_G(priceForFrontBack);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_going_save = (Button) view.findViewById(R.id.going_confirm_btn);
        //on click listener for button
        btn_going_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                On_btn_going_save_click();
            }
        });

        btn_going_cancel = (Button) view.findViewById(R.id.going_cancel_btn);
        //on click listener for button
        btn_going_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(getActivity(),Catalog.class);
                getActivity().startActivity(it);
            }
        });


        return view;
    }

    public void On_btn_going_save_click()
    {
        //called method
        final String train_num=text_train_number.getText().toString().trim();
        final String platform=text_platform.getText().toString().trim();
        String wtS = text_wt.getText().toString();

        //int train_num_len = train_num.length();
        //String wtS = txt_wt.getText().toString();

        //checking the validations for empty and wrong fields
        if(train_num.isEmpty())
        {
            Toast.makeText(getActivity(), "Train Number field Can Not Be Empty", Toast.LENGTH_SHORT).show();
        }
        else if(platform.isEmpty())
        {
            Toast.makeText(getActivity(), "Platform field Can Not Be Empty", Toast.LENGTH_SHORT).show();
        }
        else if(wtS.isEmpty())
        {
            Toast.makeText(getActivity(), "Weight field Can Not Be Empty", Toast.LENGTH_SHORT).show();
        }
        else if(train_num.length()!=5)
        {
            Toast.makeText(getActivity(), "Enter a valid train number", Toast.LENGTH_SHORT).show();
        }
        else
        {
            int wt=Integer.parseInt(wtS);

            Globals g=(Globals) getActivity().getApplication();
            g.setWt_in_KGs(wt);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Intent it=new Intent(getActivity(),Estimated_Fare.class);
            getActivity().startActivity(it);
        }
    }
}
