package android.onlinecooliesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText login_userid;
    EditText login_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //for hiding the keyboard
        hideSoftKeyboard();

        login_userid = (EditText) findViewById(R.id.login_userid);
        login_password = (EditText) findViewById(R.id.login_Password);
    }
    public void registerBtn(View v) {
        // Do something in response to button click
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Intent it=new Intent(this,Registration.class);
        startActivity(it);
    }

    public void login_button(View view) {
        // Do something in response to button click

        String userid=login_userid.getText().toString();
        String password=login_password.getText().toString();

        //String type = "login";
        //BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        //backgroundWorker.execute(type, password, userid);


        //checking the validations for thr fields
        if((userid.equals("nishugoyal@gmail.com") && password.equals("123")) ||
                (userid.equals("bhawnasahasi@gmail.com") && password.equals("12345")) ||
                (userid.equals("Nishugoyal@gmail.com") && password.equals("123")) ||
                (userid.equals("Bhawnasahasi@gmail.com") && password.equals("12345")))
        {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Intent it=new Intent(this,Catalog.class);
            startActivity(it);
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
        }
        else if(userid.isEmpty()==true)
        {
            Toast.makeText(this, "Email Id field can not be empty", Toast.LENGTH_SHORT).show();
        }
        else if(password.isEmpty()==true)
        {
            Toast.makeText(this, "Password field can not be empty", Toast.LENGTH_SHORT).show();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(userid).matches())
        {
            Toast.makeText(this, "Email Pattern is not correct", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Either Email Id or Password is incorrect", Toast.LENGTH_SHORT).show();
        }

    }
    public void login_cancel_btn(View view)
    {
        // Do something in response to button click
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //exit from app
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
        Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show();
    }

    /**
     * Hides the soft keyboard
     */
    public void hideSoftKeyboard() {
        if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }
}
