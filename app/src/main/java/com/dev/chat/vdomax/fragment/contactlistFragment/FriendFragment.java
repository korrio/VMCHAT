package com.dev.chat.vdomax.fragment.contactlistFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.adapter.mainadapter.MessageListAdapter;
import com.dev.chat.vdomax.dialog.DialogBlogFollow;
import com.dev.chat.vdomax.event.retrofit.friend.GetFriendSuccessEvent;
import com.dev.chat.vdomax.fragment.basefragment.BaseFragment;
import com.dev.chat.vdomax.model.friendmodel.FriendModel;
import com.squareup.otto.Subscribe;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Adisorn on 24/2/2558.
 */
public class FriendFragment extends BaseFragment{

    @InjectView(R.id.epFriendList)
    ExpandableListView epFriendList;

    @InjectView(R.id.textView4)
    TextView text;


    Bundle bundleState;

    private FriendModel friendModel;

    int count = 1;
    /*****************************
     *Sample Data
     */
//    MessageListAdapter messageListAdapter;
//    List<String> listDataHeader;
//    HashMap<String, List<String>> listDataChild;
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

        if (bundleState != null){
            initDataToView((FriendModel)bundleState.getParcelable("friendModel"));
        }
        else {
            Toast.makeText(getActivity() , "null" , Toast.LENGTH_SHORT).show();
        }

        initEvent();

        return rootView;
    }



    @Override
    public void onDestroyView() {
        bundleState = new Bundle();
        bundleState.putParcelable("friendModel" ,friendModel );

        super.onDestroyView();

    }



    @Subscribe public void onGetFriendSuccessEvent(GetFriendSuccessEvent event){
       // Toast.makeText(getActivity() , "FriendSuccess" , Toast.LENGTH_SHORT).show();
        text.setText("OK : "+ count);
        count++;

        this.friendModel = event.getFrindModel();

        initDataToView(friendModel);
    }


    void initDataToView(FriendModel friendModel){
        MessageListAdapter messageListAdapter = new MessageListAdapter(getActivity() ,friendModel );
        epFriendList.setAdapter(messageListAdapter);
//        prepareListData();
//        messageListAdapter = new MessageListAdapter(getActivity() , listDataHeader , listDataChild);
//        epFriendList.setAdapter(messageListAdapter);
    }
    void initEvent(){
        epFriendList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getActivity() , "Click" , Toast.LENGTH_SHORT).show();

                DialogBlogFollow dialogBlogFollow = new DialogBlogFollow(getActivity() , getActivity().getSupportFragmentManager());
                dialogBlogFollow.show();
                return false;
            }
        });

    }





}
