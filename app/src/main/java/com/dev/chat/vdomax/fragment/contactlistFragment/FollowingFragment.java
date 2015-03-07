package com.dev.chat.vdomax.fragment.contactlistFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.adapter.contactlistfragment.GridFollowingAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Adisorn on 24/2/2558.
 */
public class FollowingFragment extends Fragment {

    @InjectView(R.id.gridViewFollowing)
    GridView gridViewFollowing;

    public FollowingFragment() {
    }

    public static FollowingFragment newInstance() {
        FollowingFragment followingFragment = new FollowingFragment();
        return followingFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_following_tab, container, false);
        ButterKnife.inject(this , rootView);
//        initUI(rootView);
//        initData();
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initUI();
        initData();
    }

    @Override
    public void onResume() {
        super.onResume();
//        initUI();
//        initData();
    }


    void initUI(){
        gridViewFollowing.setNumColumns(3);
    }
    void initData(){
        GridFollowingAdapter gridFollowingAdapter = new GridFollowingAdapter(getActivity());
        gridViewFollowing.setAdapter(gridFollowingAdapter);
    }

}
