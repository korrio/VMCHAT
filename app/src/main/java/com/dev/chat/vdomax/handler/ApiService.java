package com.dev.chat.vdomax.handler;

import com.dev.chat.vdomax.model.follow_suggestion_model.Follow_SuggestionModel;
import com.dev.chat.vdomax.model.followersmodel.FollowersModel;
import com.dev.chat.vdomax.model.followingmodel.FollowingModel;
import com.dev.chat.vdomax.model.friendmodel.FriendModel;

import retrofit.Callback;
import retrofit.http.POST;

/**
 * Created by Adisorn on 14/3/2558.
 */
public interface ApiService {


    @POST("/friends/3")
    public void getFriend(Callback<FriendModel> responseJson);

    @POST("/followings/6")
    public void getFollowing(Callback<FollowingModel> responseJson);

    @POST("/followers/3")
    public void getFollowers(Callback<FollowersModel> responseJson);

    @POST("/follow_suggestion")
    public void getFolow_Suggestion(Callback<Follow_SuggestionModel> responseJson);

}
