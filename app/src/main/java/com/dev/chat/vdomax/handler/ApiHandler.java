package com.dev.chat.vdomax.handler;

import android.content.Context;
import android.widget.Toast;

import com.dev.chat.vdomax.event.retrofit.addfriend.GetFollow_SuggestionEvent;
import com.dev.chat.vdomax.event.retrofit.addfriend.GetFollow_SuggestionSuccessEvent;
import com.dev.chat.vdomax.event.retrofit.followers.GetFollowersEvent;
import com.dev.chat.vdomax.event.retrofit.followers.GetFollowersSuccessEvent2;
import com.dev.chat.vdomax.event.retrofit.following.GetFollowingEvent;
import com.dev.chat.vdomax.event.retrofit.following.GetFollowingSuccessEvent;
import com.dev.chat.vdomax.event.retrofit.friend.GetFrienEvent;
import com.dev.chat.vdomax.event.retrofit.friend.GetFriendSuccessEvent;
import com.dev.chat.vdomax.model.follow_suggestion_model.Follow_SuggestionModel;
import com.dev.chat.vdomax.model.followersmodel.FollowersModel;
import com.dev.chat.vdomax.model.followingmodel.FollowingModel;
import com.dev.chat.vdomax.model.friendmodel.FriendModel;
import com.squareup.otto.Subscribe;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Adisorn on 14/3/2558.
 */
public class ApiHandler {


    private Context context;
    private ApiService apiService;
    private ApiBus apiBus;

    private FriendModel frindModel_data;
    private FollowingModel followingModel_data;
    private FollowersModel followersModel_data;


    public ApiHandler(Context context , ApiService apiService , ApiBus apiBus ) {
        this.context = context;
        this.apiService = apiService;
        this.apiBus = apiBus;
    }
    public void registerForEvents() {
        apiBus.register(this);
    }


    @Subscribe public void getFriendList(GetFrienEvent data){

        apiService.getFriend(new Callback<FriendModel>() {
            @Override
            public void success(FriendModel frindModel, Response response) {
                apiBus.post(new GetFriendSuccessEvent(frindModel));
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(context , "error "+error.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Subscribe public void getFollowingList(GetFollowingEvent data){

        apiService.getFollowing(new Callback<FollowingModel>() {
            @Override
            public void success(FollowingModel followingModel, Response response) {
                apiBus.post(new GetFollowingSuccessEvent(followingModel));
                //Toast.makeText(context , "getFollowingList" ,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Subscribe public void getFollowersList(GetFollowersEvent data){

        apiService.getFollowers(new Callback<FollowersModel>() {
            @Override
            public void success(FollowersModel followersModel, Response response) {
                apiBus.post(new GetFollowersSuccessEvent2(followersModel));

                Toast.makeText(context , "followers_sssss" ,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(context , error.getMessage() ,Toast.LENGTH_SHORT).show();
            }
        });
    }

//    @Produce public FriendModel getFriendListAnswer(){
//        return frindModel_data;
//    }

    @Subscribe public void getFolow_SuggestionEvent(GetFollow_SuggestionEvent event){
        Toast.makeText(context , "1111111" ,Toast.LENGTH_SHORT).show();
        apiService.getFolow_Suggestion(new Callback<Follow_SuggestionModel>() {
            @Override
            public void success(Follow_SuggestionModel follow_suggestionModel, Response response) {
                apiBus.post(new GetFollow_SuggestionSuccessEvent(follow_suggestionModel));
                Toast.makeText(context , "222222" ,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }






}
