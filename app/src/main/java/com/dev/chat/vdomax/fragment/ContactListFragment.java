package com.dev.chat.vdomax.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.adapter.contactlistfragment.ContactListViewpageAdapter;
import com.dev.chat.vdomax.event.retrofit.followers.GetFollowersEvent;
import com.dev.chat.vdomax.event.retrofit.following.GetFollowingEvent;
import com.dev.chat.vdomax.event.retrofit.friend.GetFrienEvent;
import com.dev.chat.vdomax.fragment.basefragment.BaseFragment;
import com.dev.chat.vdomax.handler.ApiBus;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Adisorn on 24/2/2558.
 */
public class ContactListFragment extends BaseFragment {



//    private ViewPager viewPager;
    private ContactListViewpageAdapter adapter;

    @InjectView(R.id.pager) ViewPager viewPager;


   // private String[] tabs = { "Top Rated", "Games", "Movies" };

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


        adapter = new ContactListViewpageAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);


        ApiBus.getInstance().post(new GetFrienEvent());        //Call To ApiHandler
        ApiBus.getInstance().post(new GetFollowingEvent());

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //actionBar.setSelectedNavigationItem(position);
                ApiBus.getInstance().post(new GetFollowersEvent());  // Get Data Followers
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @OnClick(R.id.tabFriend) public void ClickFriendTab(){
        viewPager.setCurrentItem(0);
    }
    @OnClick(R.id.tabFollowing) public void ClickFollowingTab(){
        viewPager.setCurrentItem(1);
        ApiBus.getInstance().post(new GetFollowersEvent());
    }
    @OnClick(R.id.tabFollower) public void ClickFollowerTab(){
        viewPager.setCurrentItem(2);
    }

    @OnClick(R.id.btCreateGroup) public void onClickCreateGroup(){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frameFragment, CreateGroupFragment.newInstance());
        transaction.addToBackStack(null);
        transaction.commit();
       // Toast.makeText(getActivity(), "navIconLeft", Toast.LENGTH_SHORT).show();

    }
    @OnClick(R.id.btCreateConference) public void onClickConference(){

    }


}
