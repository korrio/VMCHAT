package com.dev.chat.vdomax.fragment.contactlistFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.adapter.mainadapter.MessageListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Adisorn on 24/2/2558.
 */
public class FriendFragment extends Fragment {

    @InjectView(R.id.epFriendList)
    ExpandableListView epFriendList;


    /*****************************
     *Sample Data
     */
    MessageListAdapter messageListAdapter;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    //****************************

    public FriendFragment() {
    }

    public static FriendFragment newInstance() {
        FriendFragment friendFragment = new FriendFragment();
        return friendFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_friends_tab, container, false);

        ButterKnife.inject(this, rootView);
        initUI(rootView);
        initData();

        return rootView;
    }

    void initUI(View rootView){

    }
    void initData(){
        prepareListData();
        messageListAdapter = new MessageListAdapter(getActivity() , listDataHeader , listDataChild);
        epFriendList.setAdapter(messageListAdapter);
    }

    private void prepareListData() {

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Top 250");
        listDataHeader.add("Now Showing");
        listDataHeader.add("Coming Soon..");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }

}
