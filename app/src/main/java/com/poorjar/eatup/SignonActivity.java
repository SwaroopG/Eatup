package com.poorjar.eatup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


/**
 * TODO: Add Google and Facebook Login
 * Class that provides Google and Facebook login.
 */
public class SignonActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signon);

        Button signinButton = (Button) findViewById(R.id.sign_in_button);
        restaurantSearchIntent(signinButton);

        Button facebookSigninButton = (Button) findViewById(R.id.facebook_signin_button);
        restaurantSearchIntent(facebookSigninButton);

    }

    private void restaurantSearchIntent(final Button button) {
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent restaurantActivity = new Intent(getApplicationContext(), RestaurantSearchActivity.class);
                Log.e("Hello!!!!!!!!!!!!!!", button.toString());
                startActivity(restaurantActivity);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_signon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
