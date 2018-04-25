package android.onlinecooliesystem;

import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
//implements View.OnClickListener

public class bookingForCoolie_coming extends Fragment {

    Button btn_coming_save;
    Button btn_coming_cancel;

    EditText txt_train_number;
    EditText txt_time;
    Spinner spin_luggage;
    EditText txt_wt;
    Spinner spin_loc;
    public bookingForCoolie_coming() {
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
        View view = inflater.inflate(R.layout.fragment_booking_for_coolie_coming, container, false);

        txt_train_number = (EditText) view.findViewById(R.id.txt_coming_train_number);
        txt_time = (EditText) view.findViewById(R.id.txt_coming_time);
        txt_wt = (EditText) view.findViewById(R.id.txt_coming_weight);

        spin_luggage = (Spinner) view.findViewById(R.id.spin_coming_number_luggage);

        //on selecting the item of spin_luggage
        spin_luggage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin_loc = (Spinner) view.findViewById(R.id.spin_coming_loc);

        //on selecting the item of spin_loc
        spin_loc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spin_loc.getSelectedItem().equals("Front Gate")){
                    Globals globals=(Globals) getActivity().getApplication();
                    double priceForFrontBack=1.5;
                    globals.setPrice_for_F_G(priceForFrontBack);
                }
                else if(spin_loc.getSelectedItem().equals("Back Gate")){
                    Globals globals=(Globals) getActivity().getApplication();
                    double priceForFrontBack=1;
                    globals.setPrice_for_F_G(priceForFrontBack);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_coming_save = view.findViewById(R.id.coming_confirm_btn);
        //on click listener for button
        btn_coming_save.setOnClickListener(v -> On_btn_coming_save_click());


        btn_coming_cancel = view.findViewById(R.id.coming_cancel_btn);
        //on click listener for button
        btn_coming_cancel.setOnClickListener(v -> {
            Intent it=new Intent(getActivity(),Catalog.class);
            getActivity().startActivity(it);
        });

        return view;
    }

    public void On_btn_coming_save_click()
    {
        //called method
        final String train_num=txt_train_number.getText().toString().trim();
        final String time=txt_time.getText().toString().trim();
        String wtS = txt_wt.getText().toString();

        //checking the validations for empty and wrong fields
        if(train_num.isEmpty())
        {
            Toast.makeText(getActivity(), "Train Number field Can Not Be Empty", Toast.LENGTH_SHORT).show();
        }
        else if(time.isEmpty())
        {
            Toast.makeText(getActivity(), "Time field Can Not Be Empty", Toast.LENGTH_SHORT).show();
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
