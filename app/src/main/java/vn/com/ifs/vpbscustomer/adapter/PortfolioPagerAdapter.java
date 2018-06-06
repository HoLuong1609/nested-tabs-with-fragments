package vn.com.ifs.vpbscustomer.adapter;

import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import vn.com.ifs.vpbscustomer.R;
import vn.com.ifs.vpbscustomer.module.stocks.porfolio.AssetsCategoryFragment;
import vn.com.ifs.vpbscustomer.module.stocks.porfolio.CashStatementFragment;
import vn.com.ifs.vpbscustomer.module.stocks.porfolio.StockStatementFragment;
import vn.com.ifs.vpbscustomer.module.stocks.porfolio.TradingHistoryFragment;

/**
 * Created by IFS on 3/15/2018.
 */

public class PortfolioPagerAdapter extends FragmentPagerAdapter {

    private int[] titles = {R.string.assets_category, R.string.trading_history, R.string.cash_statement, R.string.stock_statement};

    private AssetsCategoryFragment assetsCategoryFragment = new AssetsCategoryFragment();
    private TradingHistoryFragment tradingHistoryFragment = new TradingHistoryFragment();
    private CashStatementFragment cashStatementFragment = new CashStatementFragment();
    private StockStatementFragment stockStatementFragment = new StockStatementFragment();


    public PortfolioPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void onFragmentSelected(int position) {
        switch (position) {
            case 0:
                // first fragment need to be call api onCreate
                break;
            case 1:
                tradingHistoryFragment.callApi();
                break;
            case 2:
                cashStatementFragment.callApi();
                break;
            case 3:
                stockStatementFragment.callApi();
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
                fragment = assetsCategoryFragment;
                break;
            case 1:
                fragment = tradingHistoryFragment;
                break;
            case 2:
                fragment = cashStatementFragment;
                break;
            case 3:
                fragment = stockStatementFragment;
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
