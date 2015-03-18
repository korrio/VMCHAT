package com.dev.chat.vdomax.event.retrofit.following;

import com.dev.chat.vdomax.model.followingmodel.FollowingModel;

/**
 * Created by Adisorn on 15/3/2558.
 */
public class GetFollowingSuccessEvent {
    private FollowingModel followingModel;
    public GetFollowingSuccessEvent( FollowingModel followingModel) {
        this.followingModel = followingModel;
    }

    public FollowingModel getFollowingModel() {
        return followingModel;
    }

    public void setFollowingModel(FollowingModel followingModel) {
        this.followingModel = followingModel;
    }
}
