package vn.com.ifs.vpbscustomer.module;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import vn.com.ifs.vpbscustomer.activity.BaseActivity;

public class Presenter {

    private BaseActivity activity;

    public Presenter(Fragment fragment) {
        activity = (BaseActivity) fragment.getActivity();
    }

    public void loadData() {
        activity.showProgressDialog();
        new Handler().postDelayed(() -> {
            activity.dismissProgressDialog();
            Toast.makeText(activity, "Load data successful!", Toast.LENGTH_SHORT).show();
        }, 500);
    }
}
