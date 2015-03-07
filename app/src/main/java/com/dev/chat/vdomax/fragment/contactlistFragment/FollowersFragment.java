package com.dev.chat.vdomax.fragment.contactlistFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.adapter.contactlistfragment.tab.ListFolowAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Adisorn on 24/2/2558.
 */
public class FollowersFragment extends Fragment {

    @InjectView(R.id.listViewFollowing)
    ListView listViewFollowing;

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
        initData();
        return rootView;
    }
    void initUI(View rootView){

    }
    void initData(){
        ListFolowAdapter listFolowAdapter = new ListFolowAdapter(getActivity());
        listViewFollowing.setAdapter(listFolowAdapter);
    }
}
