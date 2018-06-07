package vn.com.ifs.vpbscustomer.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import vn.com.ifs.vpbscustomer.fragment.ChildFragment;

/**
 * Created by IFS on 3/15/2018.
 */

public class ExtensionsPagerAdapter extends FragmentPagerAdapter {

    private String[] titles = {"ExtensionsChild1Fragment", "ExtensionsChild2Fragment", "ExtensionsChild3Fragment", "ExtensionsChild4Fragment"};

    private ChildFragment child1 = ChildFragment.newInstance("ExtensionsChild1Fragment");
    private ChildFragment child2 = ChildFragment.newInstance("ExtensionsChild2Fragment");
    private ChildFragment child3 = ChildFragment.newInstance("ExtensionsChild3Fragment");
    private ChildFragment child4 = ChildFragment.newInstance("ExtensionsChild4Fragment");

    public ExtensionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void onFragmentSelected(int position) {
        switch (position) {
            case 0:
                // first fragment need to be call api onCreate
                break;
            case 1:
//                child2.callApi();
                break;
            case 2:
//                child3.callApi();
                break;
            case 3:
//                child4.callApi();
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
                fragment = child1;
                break;
            case 1:
                fragment = child2;
                break;
            case 2:
                fragment = child3;
                break;
            case 3:
                fragment = child4;
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

    public String getTabTitleRes(int position) {
        return titles[position];
    }
}
