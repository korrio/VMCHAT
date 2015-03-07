package com.dev.chat.vdomax.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.adapter.contactlistfragment.ContactListViewpageAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Adisorn on 24/2/2558.
 */
public class ContactListFragment extends Fragment {



//    private ViewPager viewPager;
    private ContactListViewpageAdapter adapter;

    @InjectView(R.id.pager) ViewPager viewPager;


    private String[] tabs = { "Top Rated", "Games", "Movies" };

    public ContactListFragment() {
    }

    public static Fragment newInstance() {
        ContactListFragment contactListFragment = new ContactListFragment();
        return contactListFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contactlist, container, false);

        ButterKnife.inject(this, rootView);
        initUI();


        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //initDataTabHost();
        //callSocket();
    }

    void initUI(){


        adapter = new ContactListViewpageAdapter(getFragmentManager());
        viewPager.setAdapter(adapter);


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @OnClick(R.id.tabFriend)
    public void ClickFriendTab(){
        viewPager.setCurrentItem(0);
    }
    @OnClick(R.id.tabFollowing)
    public void ClickFollowingTab(){
        viewPager.setCurrentItem(1);
    }
    @OnClick(R.id.tabFollower)
    public void ClickFollowerTab(){
        viewPager.setCurrentItem(2);
    }


}
