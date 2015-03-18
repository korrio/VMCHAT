package com.dev.chat.vdomax.fragment.contactlistFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.adapter.contactlistfragment.tab.ListFollowersAdapter;
import com.dev.chat.vdomax.event.retrofit.followers.GetFollowersSuccessEvent2;
import com.dev.chat.vdomax.fragment.basefragment.BaseFragment;
import com.dev.chat.vdomax.model.followersmodel.FollowersModel;
import com.squareup.otto.Subscribe;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Adisorn on 24/2/2558.
 */
public class FollowersFragment extends BaseFragment {

    @InjectView(R.id.listViewFollowers)
    ListView listViewFollowers;

    private ListFollowersAdapter listFollowersAdapter;

    public FollowersFragment() {
    }

    public static FollowersFragment newInstance() {
        FollowersFragment followersFragment = new FollowersFragment();
        return followersFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_followers_tab, container, false);

        ButterKnife.inject(this , rootView);
        initUI(rootView);
        //initData();
        return rootView;
    }
    @Subscribe public void onEvent(GetFollowersSuccessEvent2 event){
        Toast.makeText(getActivity() , "Success///" , Toast.LENGTH_SHORT).show();

        initData(event.getFollowersModel());
    }

    void initUI(View rootView){
        listFollowersAdapter = new ListFollowersAdapter(getActivity());
        listViewFollowers.setAdapter(listFollowersAdapter);
    }
    void initData(FollowersModel followersModel){
//        listFollowersAdapter = new ListFollowersAdapter(getActivity() , followersModel);
//        listViewFollowers.setAdapter(listFollowersAdapter);
        listFollowersAdapter.addData(followersModel);
    }
}
