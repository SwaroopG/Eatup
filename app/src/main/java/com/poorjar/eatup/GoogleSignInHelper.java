package com.poorjar.eatup;

import android.accounts.Account;
import android.accounts.AccountManager;

import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by Swaroop on 5/17/15.
 */
public class GoogleSignInHelper {
    private static AccountManager accountManager;
    private static GoogleSignInHelper INSTANCE;

    private GoogleSignInHelper(AccountManager accountManager)
    {
        this.accountManager = accountManager;
    }

    public static GoogleSignInHelper getInstance(AccountManager accountManager)
    {
        if(INSTANCE == null) {
            INSTANCE = new GoogleSignInHelper(accountManager);
        }
        return INSTANCE;
    }

    static List<String> getAccountNames() {
        Account[] accounts = accountManager
                .getAccountsByType(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
        List<String> names = Lists.newArrayListWithCapacity(accounts.length);

        for(Account account : accounts) {
            names.add(account.name);
        }
        return names;
    }
}
