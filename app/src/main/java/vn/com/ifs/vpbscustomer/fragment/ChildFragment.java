package vn.com.ifs.vpbscustomer.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import vn.com.ifs.vpbscustomer.R;
import vn.com.ifs.vpbscustomer.module.Presenter;

public class ChildFragment extends BaseViewStubFragment {
    private static final String ARG_NAME = "name";

    public ChildFragment() {
        // Required empty public constructor
    }


    public static ChildFragment newInstance(String name) {
        ChildFragment fragment = new ChildFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onCreateViewAfterViewStubInflated(View inflatedView, Bundle savedInstanceState, boolean hasInflated) {
        if (!hasInflated)
            new Presenter(this).loadData();
        TextView tvChildName = inflatedView.findViewById(R.id.tvChildName);
        tvChildName.setText(getName());
    }

    @Override
    protected int getViewStubLayoutResource() {
        return R.layout.fragment_child;
    }

    public String getName() {
        Bundle args = getArguments();
        return args == null ? "" : args.getString(ARG_NAME);
    }
}
