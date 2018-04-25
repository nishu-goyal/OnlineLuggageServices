package android.onlinecooliesystem;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {

    private EditText signup_user_name;
    private EditText signup_password;
    private EditText signup_emailid;
    private EditText signup_phone;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        signup_user_name = (EditText) findViewById(R.id.signup_username);
        signup_password = (EditText) findViewById(R.id.signup_pass);
        signup_emailid = (EditText) findViewById(R.id.signup_email);
        signup_phone = (EditText) findViewById(R.id.signup_number);

        progressDialog = new ProgressDialog(this);
        //progressDialog.setMessage();

    }

    public void doLOGIN(View v) {
        // Do something in response to textview click
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Intent it=new Intent(this,Login.class);
        startActivity(it);
    }
    public void signup_button(View view)
    {
        // Do something in response to button click
        final String user_name=signup_user_name.getText().toString().trim();
        final String pass=signup_password.getText().toString().trim();
        final String email=signup_emailid.getText().toString().trim();
        final String phone=signup_phone.getText().toString().trim();

        //checking the validations for fields
        if(user_name.isEmpty()==true)
        {
            Toast.makeText(this, "UserName Field can not be empty!", Toast.LENGTH_SHORT).show();
        }
        if(pass.isEmpty()==true)
        {
            Toast.makeText(this, "Password Field can not be empty!", Toast.LENGTH_SHORT).show();
        }
        if(email.isEmpty()==true)
        {
            Toast.makeText(this, "Email Id Field can not be empty!", Toast.LENGTH_SHORT).show();
        }
        if(phone.isEmpty()==true)
        {
            Toast.makeText(this, "Phone Number Field can not be empty!", Toast.LENGTH_SHORT).show();
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Toast.makeText(this, "Email Pattern is not correct", Toast.LENGTH_SHORT).show();
        }
        int phn_length = phone.length();
        if(phn_length != 10)
        {
            Toast.makeText(this, "Enter a valid phone number", Toast.LENGTH_SHORT).show();
        }

        if(user_name.isEmpty()==false && pass.isEmpty()==false && email.isEmpty()==false && phone.isEmpty()==false && phn_length==10
                && Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Intent it = new Intent(this, Catalog.class);
            startActivity(it);
            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
        }


        //register_user();
    }
   /* public void register_user()
    {
        final String user_name=signup_user_name.getText().toString().trim();
        final String pass=signup_password.getText().toString().trim();
        final String email=signup_emailid.getText().toString().trim();
        final String phone=signup_phone.getText().toString().trim();

        progressDialog.setMessage("REGISTERING USER...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();

                try {
                    JSONObject jsonObject=new JSONObject(response);

                    Toast.makeText(Registration.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (JSONExc-eption e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(Registration.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();
                params.put("user_name",user_name);
                params.put("pass",pass);
                params.put("email",email);
                params.put("phone",phone);
                return params;
                //return super.getParams();
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }*/
    public void signup_cancel_btn(View view)
    {
        // Do something in response to button click
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
