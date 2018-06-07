package vn.com.ifs.vpbscustomer.adapter;

import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import vn.com.ifs.vpbscustomer.R;
import vn.com.ifs.vpbscustomer.module.stocks.ExtensionsFragment;
import vn.com.ifs.vpbscustomer.module.stocks.MarketsFragment;
import vn.com.ifs.vpbscustomer.module.stocks.PendingOrdersFragment;
import vn.com.ifs.vpbscustomer.module.stocks.porfolio.PortfolioFragment;

/**
 * Created by IFS on 3/15/2018.
 */

public class StocksPagerAdapter extends FragmentPagerAdapter {

    private int[] titles = {R.string.portfolio, R.string.pending_orders, R.string.extensions, R.string.markets};

    private PortfolioFragment portfolioFragment = new PortfolioFragment();
    private PendingOrdersFragment pendingOrdersFragment = new PendingOrdersFragment();
    private ExtensionsFragment extensionsFragment = new ExtensionsFragment();
    private MarketsFragment marketsFragment = new MarketsFragment();


    public StocksPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void onFragmentSelected(int position) {
        switch (position) {
            case 0:
                // first fragment need to be call api onCreate
                break;
            case 1:
//                pendingOrdersFragment.callApi();
                break;
            case 2:
//                extensionsFragment.callApi();
                break;
            case 3:
//                marketsFragment.callApi();
                break;
            default:
                break;
        }
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = portfolioFragment;
                break;
            case 1:
                fragment = pendingOrdersFragment;
                break;
            case 2:
                fragment = extensionsFragment;
                break;
            case 3:
                fragment = marketsFragment;
                break;
            default:
                fragment = new Fragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

    @StringRes
    public int getTabTitleRes(int position) {
        return titles[position];
    }
}
