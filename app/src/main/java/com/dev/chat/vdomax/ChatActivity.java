package com.dev.chat.vdomax;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.dev.chat.vdomax.adapter.chat.Message;
import com.dev.chat.vdomax.adapter.chat.MessagesListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adisorn on 8/3/2558.
 */
public class ChatActivity extends Activity {
    private ListView listViewMessages;
    MessagesListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);



        initUI();
        initData();
    }
    void initUI(){
        listViewMessages = (ListView) findViewById(R.id.list_view_messages);
    }
    void initData(){

        List<Message> list = new ArrayList<Message>();
        list.add(new Message("Nop" , "Hello" , true));
        list.add(new Message("ploy" , "Hi" , false));
        list.add(new Message("Nop" , "How are you?" , true));

        adapter = new MessagesListAdapter(ChatActivity.this ,list );
        listViewMessages.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
       // BusEvent.getInstance().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
       //usEvent.getInstance().unregister(ChatActivity.this);

    }

//    @Subscribe
//    public void textFromMainActivity(TestEvent event){
//        Toast.makeText(ChatActivity.this , event.getTextFromEvent() , Toast.LENGTH_LONG).show();
//
//    }
}
