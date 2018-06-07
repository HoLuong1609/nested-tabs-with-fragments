package vn.com.ifs.vpbscustomer.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.com.ifs.vpbscustomer.R;
import vn.com.ifs.vpbscustomer.utils.Logger;

/**
 * Created by mobileTeam1 on 3/21/2018.
 */

public abstract class BaseFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.i(getSimpleName(), "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Logger.i(getSimpleName(), "onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Logger.i(getSimpleName(), "onViewCreated");
        mSwipeRefreshLayout = view.findViewById(R.id.swipeContainer);
        if (mSwipeRefreshLayout != null)
            mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Logger.i(getSimpleName(), "onActivityCreated");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Logger.i(getSimpleName(), "setUserVisibleHint - " + isVisibleToUser);
    }

    @Override
    public void onStart() {
        super.onStart();
        Logger.i(getSimpleName(), "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Logger.i(getSimpleName(), "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Logger.i(getSimpleName(), "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Logger.i(getSimpleName(), "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Logger.i(getSimpleName(), "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Logger.i(getSimpleName(), "onDetach");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Logger.i(getSimpleName(), "onViewStateRestored");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Logger.i(getSimpleName(), "onSaveInstanceState");
    }

    public void hideSwipeProgress() {
        if (mSwipeRefreshLayout != null && mSwipeRefreshLayout.isRefreshing())
            mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(this::hideSwipeProgress, 1000);
    }

    protected String getSimpleName() {
        String simpleName = this.getClass().getSimpleName();
        if (simpleName.equals("ChildFragment")) {
            ChildFragment fragment = (ChildFragment) this;
            simpleName = fragment.getName();
        }
        return simpleName;
    }
}
