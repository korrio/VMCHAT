package com.dev.chat.vdomax.adapter.contactlistfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dev.chat.vdomax.fragment.contactlistFragment.FollowersFragment;
import com.dev.chat.vdomax.fragment.contactlistFragment.FollowingFragment;
import com.dev.chat.vdomax.fragment.contactlistFragment.FriendFragment;

/**
 * Created by Adisorn on 1/3/2558.
 */
public class ContactListViewpageAdapter extends FragmentPagerAdapter{

    public ContactListViewpageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 : return FriendFragment.newInstance();
            case 1 : return FollowingFragment.newInstance();
            case 2 : return FollowersFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
