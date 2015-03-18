package com.dev.chat.vdomax;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.chat.vdomax.event.retrofit.addfriend.GetFollow_SuggestionEvent;
import com.dev.chat.vdomax.fragment.addfriend.AddFriendFragment;
import com.dev.chat.vdomax.fragment.ChatFragment;
import com.dev.chat.vdomax.fragment.ContactListFragment;
import com.dev.chat.vdomax.fragment.MessageListFragment;
import com.dev.chat.vdomax.handler.ApiBus;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends FragmentActivity {

    @InjectView(R.id.textNavigationBar)
    TextView textNavigationBar;

    @InjectView(R.id.navIconLeft)
    ImageView navIconLeft;

    @InjectView(R.id.navIconRight)
    ImageView navIconRight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(MainActivity.this);

        transactionFragment(TYPE_MENU.CONTACT_LIST);   // set First Fragment Defale



    }

    @Override
    protected void onResume() {
        super.onResume();
       // Toast.makeText(this , "Main onResume" , Toast.LENGTH_SHORT).show();
        ApiBus.getInstance().register(MainActivity.this);




    }

    @Override
    protected void onPause() {
        super.onPause();
       // Toast.makeText(this , "Main onPause" , Toast.LENGTH_SHORT).show();
        ApiBus.getInstance().unregister(MainActivity.this);
    }

    @OnClick(R.id.navIconLeft)
    public void onClickNavIconLeft(){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frameFragment, AddFriendFragment.newInstance());
        transaction.addToBackStack(null);
        transaction.commit();
        Toast.makeText(MainActivity.this , "navIconLeft" , Toast.LENGTH_SHORT).show();

        ApiBus.getInstance().post(new GetFollow_SuggestionEvent());
    }
    @OnClick(R.id.navIconRight)
    public void onClickNavIconRight(){
        Toast.makeText(MainActivity.this , "navIconRight" , Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.layoutMessageListBt)
    public void onClickMenuMessageList(){

        transactionFragment(TYPE_MENU.CONTACT_LIST);

    }

    @OnClick(R.id.layoutChatBt)
    public void onClickMenuChat(){

        transactionFragment(TYPE_MENU.CHAT);

    }

    @OnClick(R.id.layoutContactBt)
    public void onClickMenuContact(){

        transactionFragment(TYPE_MENU.MESSAGE_LIST);

    }
    void transactionFragment(TYPE_MENU type_menu){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (type_menu == TYPE_MENU.CONTACT_LIST){
            transaction.replace(R.id.fragment, ContactListFragment.newInstance());
            textNavigationBar.setText(getResources().getString(R.string.txtNavigationBar_Contact));
          //  navIconLeft.setVisibility(View.VISIBLE);
            navIconRight.setVisibility(View.INVISIBLE);
        }
        else if (type_menu == TYPE_MENU.CHAT){
            transaction.replace(R.id.fragment, ChatFragment.newInstance());
            textNavigationBar.setText(getResources().getString(R.string.txtNavigationBar_Chat));
           // navIconLeft.setVisibility(View.VISIBLE);
            navIconRight.setVisibility(View.VISIBLE);
        }
        else if (type_menu == TYPE_MENU.MESSAGE_LIST){

            transaction.replace(R.id.fragment, MessageListFragment.newInstance());
            textNavigationBar.setText(getResources().getString(R.string.txtNavigationBar_Message));
            navIconRight.setVisibility(View.VISIBLE);
        }

        transaction.commit();



    }


    enum TYPE_MENU{
        CONTACT_LIST , MESSAGE_LIST , CHAT
    }




}
