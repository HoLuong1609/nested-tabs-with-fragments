package vn.com.ifs.vpbscustomer.fragment;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import vn.com.ifs.vpbscustomer.R;
import vn.com.ifs.vpbscustomer.utils.Logger;

public abstract class BaseViewStubFragment extends BaseFragment {

    private Bundle mSavedInstanceState;
    private boolean mHasInflated = false;
    private ViewStub mViewStub;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewstub, container, false);
        mViewStub = view.findViewById(R.id.fragmentViewStub);
        mViewStub.setLayoutResource(getViewStubLayoutResource());
        mSavedInstanceState = savedInstanceState;

        View inflatedView = mViewStub.inflate();
        onCreateViewAfterViewStubInflated(inflatedView, mSavedInstanceState, mHasInflated);
        afterViewStubInflated(view);

        Logger.i(getSimpleName(), "onCreateView");
        return view;
    }

    protected abstract void onCreateViewAfterViewStubInflated(View inflatedView, Bundle savedInstanceState, boolean hasInflated);

    /**
     * The layout ID associated with this ViewStub
     *
     * @return
     * @see ViewStub#setLayoutResource(int)
     */
    @LayoutRes
    protected abstract int getViewStubLayoutResource();

    /**
     * @param originalViewContainerWithViewStub
     */
    @CallSuper
    protected void afterViewStubInflated(View originalViewContainerWithViewStub) {
        mHasInflated = true;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser && mViewStub != null && !mHasInflated) {
            View inflatedView = mViewStub.inflate();
            onCreateViewAfterViewStubInflated(inflatedView, mSavedInstanceState, mHasInflated);
            afterViewStubInflated(getView());
        }
    }

    // Thanks to Noa Drach, this will fix the orientation change problem
    @Override
    public void onDetach() {
        super.onDetach();
        mHasInflated = false;
    }
}
