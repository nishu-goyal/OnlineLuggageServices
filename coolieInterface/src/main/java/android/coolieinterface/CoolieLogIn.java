package android.coolieinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class CoolieLogIn extends AppCompatActivity {

    EditText login_username;
    EditText login_password;
    EditText login_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coolie_log_in);

        //for hiding the keyboard
        hideSoftKeyboard();

        login_username = (EditText) findViewById(R.id.Clogin_username);
        login_password = (EditText) findViewById(R.id.Clogin_Password);
        login_id = (EditText) findViewById(R.id.Clogin_userid);
    }

    public void Clogin_button(View view)
    {
        // Do something in response to button click
        String username=login_username.getText().toString().trim();
        String password=login_password.getText().toString().trim();
        String id = login_id.getText().toString().trim();

        //checking validations for fields
        if((username.equals("Raju") && password.equals("abc") && id.equals("3")) ||
                (username.equals("Shyam") && password.equals("abc") && id.equals("4")) ||
                (username.equals("Rahul") && password.equals("abc") && id.equals("2")) ||
                (username.equals("abc") && password.equals("abc") && id.equals("1")) ||
                (username.equals("Sawant") && password.equals("abc") && id.equals("5")) ||
                (username.equals("Ravi") && password.equals("abc") && id.equals("6")) ||
                (username.equals("Mohinder") && password.equals("abc") && id.equals("7")) ||
                (username.equals("Kaka") && password.equals("abc") && id.equals("8")))
        {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Toast.makeText(this, "Log In Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,Request.class);
            startActivity(intent);
        }
        else if(username.isEmpty())
        {
            Toast.makeText(this, "Username Field can not be empty", Toast.LENGTH_SHORT).show();
        }
        else if(password.isEmpty())
        {
            Toast.makeText(this, "Password Field can not be empty", Toast.LENGTH_SHORT).show();
        }
        else if(id.isEmpty())
        {
            Toast.makeText(this, "Id Field can not be empty", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Either Username, Password or Id is incorrect", Toast.LENGTH_SHORT).show();
        }

    }

    public void Clogin_cancel_btn(View view)
    {
        // Do something in response to button click
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
