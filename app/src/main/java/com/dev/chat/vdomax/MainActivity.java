package com.dev.chat.vdomax;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import com.dev.chat.vdomax.fragment.ChatFragment;
import com.dev.chat.vdomax.fragment.ContactListFragment;
import com.dev.chat.vdomax.fragment.MessageListFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends FragmentActivity {

    @InjectView(R.id.textNavigationBar)
    TextView textNavigationBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        ButterKnife.inject(MainActivity.this);

        transactionFragment(TYPE_MENU.MESSAGE_LIST);   // set First Fragment Defale


    }



    @OnClick(R.id.layoutMessageListBt)
    public void onClickMenuMessageList(){
        transactionFragment(TYPE_MENU.MESSAGE_LIST);
    }

    @OnClick(R.id.layoutChatBt)
    public void onClickMenuChat(){
        transactionFragment(TYPE_MENU.CHAT);
    }

    @OnClick(R.id.layoutContactBt)
    public void onClickMenuContact(){
        transactionFragment(TYPE_MENU.CONTACT_LIST);
    }
    void transactionFragment(TYPE_MENU type_menu){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (type_menu.equals(TYPE_MENU.MESSAGE_LIST)){
            transaction.replace(R.id.fragment, MessageListFragment.newInstance());
            textNavigationBar.setText(getResources().getString(R.string.txtNavigationBar_Message));

        }
        else if (type_menu.equals(TYPE_MENU.CHAT)){
            transaction.replace(R.id.fragment, ChatFragment.newInstance());
            textNavigationBar.setText(getResources().getString(R.string.txtNavigationBar_Chat));

        }
        else if (type_menu.equals(TYPE_MENU.CONTACT_LIST)){
            transaction.replace(R.id.fragment, ContactListFragment.newInstance());
            textNavigationBar.setText(getResources().getString(R.string.txtNavigationBar_Contact));

        }

        transaction.commit();
    }

    enum TYPE_MENU{
        MESSAGE_LIST , CHAT ,CONTACT_LIST
    }




}
