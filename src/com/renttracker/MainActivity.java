package com.renttracker;

import android.accounts.*;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AccountManager accountManager = AccountManager.get(this);
        Account account = accountManager.getAccountsByType("com.google")[0];
        final Activity context = this;
        accountManager.getAuthToken(account, "oauth2:https://www.googleapis.com/auth/drive", null, this, new AccountManagerCallback<Bundle>() {
            @Override
            public void run(AccountManagerFuture<Bundle> bundleAccountManagerFuture) {
                try {
                    String token = bundleAccountManagerFuture.getResult().getString(AccountManager.KEY_AUTHTOKEN);
                    Log.e("TOKEN :: ", token);
                } catch (OperationCanceledException e) {
                    Log.e("EXCEPTION : ", e.getMessage(), e);
                    e.printStackTrace();
                } catch (IOException e) {
                    Log.e("EXCEPTION : ", e.toString(), e.getCause());
                } catch (AuthenticatorException e) {
                    Log.e("EXCEPTION : ", e.getMessage(), e);
                }
            }
        }, null);
    }
}
