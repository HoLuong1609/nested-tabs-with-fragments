package vn.com.ifs.vpbscustomer.activity;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.com.ifs.vpbscustomer.R;
import vn.com.ifs.vpbscustomer.module.AssetsFragment;
import vn.com.ifs.vpbscustomer.module.BondsFragment;
import vn.com.ifs.vpbscustomer.module.DepositFragment;
import vn.com.ifs.vpbscustomer.module.MoreFragment;
import vn.com.ifs.vpbscustomer.module.stocks.ExtensionsFragment;
import vn.com.ifs.vpbscustomer.module.stocks.MarketsFragment;
import vn.com.ifs.vpbscustomer.module.stocks.PendingOrdersFragment;
import vn.com.ifs.vpbscustomer.module.stocks.StocksFragment;
import vn.com.ifs.vpbscustomer.module.stocks.porfolio.PortfolioFragment;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    private int[] tabTitles = {R.string.stocks, R.string.bonds, R.string.deposit, R.string.assets, R.string.more};
    private int[] tabImageResources = {R.drawable.ic_stocks, R.drawable.ic_bonds, R.drawable.ic_deposit_white, R.drawable.ic_assets_white_24dp, R.drawable.ic_menu_white_24dp};

    private StocksFragment stocksFragment = new StocksFragment();
    private BondsFragment bondsFragment = new BondsFragment();
    private DepositFragment depositFragment = new DepositFragment();
    private AssetsFragment assetsFragment = new AssetsFragment();
    private MoreFragment moreFragment = new MoreFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupView();
    }

    private void setupView() {
        for (int i = 0; i < 5; i++) {
            tabLayout.addTab(tabLayout.newTab().setTag(1));
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                View tabView = LayoutInflater.from(this).inflate(R.layout.bottom_tab_indicator, tabLayout, false);
                ImageView ivIndicator = tabView.findViewById(R.id.ivIndicator);
                TextView tvTabTitle = tabView.findViewById(R.id.tvTabTitle);
                ivIndicator.setImageResource(tabImageResources[i]);
                tvTabTitle.setText(tabTitles[i]);
                tab.setCustomView(tabView);
            }
        }

        tabLayout.addOnTabSelectedListener(this);
        onFragmentChanged(stocksFragment, null);

        //setup toolbar
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowHomeEnabled(true);
        }

    }

    public void setDefaultToolBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
    }

    public void onFragmentChanged(Fragment fragment, String name) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(name)
                .commit();
    }

    public void setTitle(@StringRes int res) {
        toolbar.setTitle(res);
    }

    public void selectTab(int position, boolean isRefreshData) {
        if (isRefreshData) {
            switch (position) {
                case 0:
                    stocksFragment = new StocksFragment();
                    break;
                case 1:
                    bondsFragment = new BondsFragment();
                    break;
                case 2:
                    depositFragment = new DepositFragment();
                    break;
                case 3:
                    assetsFragment = new AssetsFragment();
                    break;
                case 4:
                    moreFragment = new MoreFragment();
                    break;
                default:
                    break;
            }
        }
        TabLayout.Tab tab = tabLayout.getTabAt(position);
        if (tab != null) {
            tab.select();
        }
    }

    private Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = stocksFragment;
                break;
            case 1:
                fragment = bondsFragment;
                break;
            case 2:
                fragment = depositFragment;
                break;
            case 3:
                fragment = assetsFragment;
                break;
            case 4:
                fragment = moreFragment;
                break;
            default:
                fragment = new Fragment();
                break;
        }
        return fragment;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        onFragmentChanged(getItem(tab.getPosition()), null);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
