package com.dev.chat.vdomax.fragment.contactlistFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.adapter.contactlistfragment.ListFollowingAdapter;
import com.dev.chat.vdomax.event.retrofit.following.GetFollowingSuccessEvent;
import com.dev.chat.vdomax.fragment.basefragment.BaseFragment;
import com.dev.chat.vdomax.model.followingmodel.FollowingModel;
import com.squareup.otto.Subscribe;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Adisorn on 24/2/2558.
 */
public class FollowingFragment extends BaseFragment {

    @InjectView(R.id.listViewFollowing)
    ListView listViewFollowing;

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

        return rootView;
    }

    @Subscribe public void onGetFollowingSuccessEvent(GetFollowingSuccessEvent getFollowingSuccessEvent){
        Toast.makeText(getActivity(), "Following_Success", Toast.LENGTH_SHORT).show();
        Log.d("EVENTTTT ", "GetFollowingSuccess");
       // getFollowingSuccessEvent.get
        initData(getFollowingSuccessEvent.getFollowingModel());
    }

    void initData(FollowingModel followingModel){
        ListFollowingAdapter gridFollowingAdapter = new ListFollowingAdapter(getActivity() ,followingModel );
        listViewFollowing.setAdapter(gridFollowingAdapter);
    }

}
