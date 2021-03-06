package vn.com.ifs.vpbscustomer.module.stocks;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.com.ifs.vpbscustomer.R;
import vn.com.ifs.vpbscustomer.adapter.ExtensionsPagerAdapter;
import vn.com.ifs.vpbscustomer.fragment.BaseViewStubFragment;

import static android.graphics.Typeface.BOLD;
import static android.graphics.Typeface.NORMAL;

public class ExtensionsFragment extends BaseViewStubFragment implements TabLayout.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    ExtensionsPagerAdapter pagerAdapter;

    @Override
    protected void onCreateViewAfterViewStubInflated(View inflatedView, Bundle savedInstanceState, boolean hasInflated) {

        ButterKnife.bind(this, inflatedView);
        pagerAdapter = new ExtensionsPagerAdapter(getChildFragmentManager());

        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(this);
        // Give the TabLayout the ViewPager
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                View tabView = LayoutInflater.from(getContext()).inflate(R.layout.top_tab_indicator, tabLayout, false);
                TextView tvTabTitle = tabView.findViewById(R.id.tvTabTitle);
                tvTabTitle.setText(pagerAdapter.getTabTitleRes(i));
                tab.setCustomView(tabView);
                if (i == 0)
                    tvTabTitle.setTypeface(null, BOLD);
                else
                    tvTabTitle.setTypeface(null, NORMAL);
            }
        }

        tabLayout.addOnTabSelectedListener(this);
    }

    @Override
    protected int getViewStubLayoutResource() {
        return R.layout.fragment_portfolio;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        View tabView = tab.getCustomView();
        if (tabView != null) {
            TextView tvTabTitle = tabView.findViewById(R.id.tvTabTitle);
            tvTabTitle.setTypeface(null, BOLD);
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        View tabView = tab.getCustomView();
        if (tabView != null) {
            TextView tvTabTitle = tabView.findViewById(R.id.tvTabTitle);
            tvTabTitle.setTypeface(null, NORMAL);
        }
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        pagerAdapter.onFragmentSelected(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}