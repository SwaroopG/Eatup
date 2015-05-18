package com.poorjar.eatup;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.poorjar.commons.CommonUtilities;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;

import java.util.List;

/**
 * Initial activity. Class that provides the sign-on funtionality.
 */
public class SignonActivity extends Activity {

    private CallbackManager callbackManager;
    private AccountManager accountManager;
    private static final String SCOPE = "oauth2:https://www.googleapis.com/auth/userinfo.profile";

    private GoogleSignInHelper googleSignInHelper;

    private String token;
    private int serverCode;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        FacebookSdk.sdkInitialize(context);

        // Create the callback manager
        callbackManager = CallbackManager.Factory.create();

        // Initialize Facebook & Google log-in
        registerFacebookLoginManager();
        syncGoogleAccount();

        // Set the rest
        setContentView(R.layout.activity_signon);
        restaurantSearchIntent((Button) findViewById(R.id.sign_in_button));
    }

    /**
     * Google sign-on
     */
    public void syncGoogleAccount() {
        accountManager = AccountManager.get(this);
        googleSignInHelper = GoogleSignInHelper.getInstance(AccountManager.get(this));

        if (CommonUtilities.isNetworkAvailable(context) == true) {
            List<String> accountNames = GoogleSignInHelper.getAccountNames();
            if (!CollectionUtils.isEmpty(accountNames)) {
                Log.e("AccountName : ", accountNames.get(0));
                //you can set here account for login
            } else {
                Toast.makeText(context, "Google Accounts not available!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "Network Service not available!", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * Default Button behavior.
     */
    private void restaurantSearchIntent(final Button button) {
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                onSuccessAction();
            }
        });
    }

    /**
     * Switch to the restaurant list menu.
     */
    private void onSuccessAction() {
        Intent restaurantActivity = new Intent(context, RestaurantSearchActivity.class);
        startActivity(restaurantActivity);
    }

    /**
     * Register the Facebook login callback.
     */
    private void registerFacebookLoginManager() {
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.e("OnSuccess", "OnSuccess");
                        onSuccessAction();
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(context, "Login Cancel", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText(context, exception.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
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
