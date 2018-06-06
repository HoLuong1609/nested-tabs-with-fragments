package vn.com.ifs.vpbscustomer.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import vn.com.ifs.vpbscustomer.dialog.LoadingDialog;
import vn.com.ifs.vpbscustomer.utils.Logger;

/**
 * Created by mobileTeam1 on 3/20/2018.
 */

public abstract class BaseActivity extends AppCompatActivity {

    LoadingDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialog = new LoadingDialog(this);
        Logger.e(this.getClass().getSimpleName(), "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.e(this.getClass().getSimpleName(), "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.e(this.getClass().getSimpleName(), "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.e(this.getClass().getSimpleName(), "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.e(this.getClass().getSimpleName(), "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.e(this.getClass().getSimpleName(), "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.e(this.getClass().getSimpleName(), "onDestroy");
    }

    public void showProgressDialog() {
        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        mProgressDialog.dismiss();
    }
}
