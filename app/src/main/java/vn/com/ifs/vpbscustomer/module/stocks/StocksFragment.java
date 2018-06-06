package vn.com.ifs.vpbscustomer.module.stocks;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.com.ifs.vpbscustomer.R;
import vn.com.ifs.vpbscustomer.adapter.StocksPagerAdapter;
import vn.com.ifs.vpbscustomer.fragment.BaseFragment;

import static android.graphics.Typeface.BOLD;
import static android.graphics.Typeface.NORMAL;

public class StocksFragment extends BaseFragment implements ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    StocksPagerAdapter pagerAdapter;

    public StocksFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_stocks, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pagerAdapter = new StocksPagerAdapter(getChildFragmentManager());

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
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        pagerAdapter.onFragmentSelected(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

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
}
