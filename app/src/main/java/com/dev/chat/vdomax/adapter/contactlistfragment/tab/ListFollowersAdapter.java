package com.dev.chat.vdomax.adapter.contactlistfragment.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.VdoMaxAplication;
import com.dev.chat.vdomax.model.followersmodel.FollowersModel;
import com.dev.chat.vdomax.model.followersmodel.User;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.Optional;

/**
 * Created by Adisorn on 7/3/2558.
 */
public class ListFollowersAdapter extends BaseAdapter {
    private Context context;
    private FollowersModel followersModel;

    private int sizePicProfile;
    public ListFollowersAdapter(Context context) {
        this.context = context;
       // this.followersModel = followersModel;
        sizePicProfile = context.getResources().getInteger(R.integer.sizePicProfile);

    }
    public void addData(FollowersModel followersModel){
        if (this.followersModel == null){
            this.followersModel = followersModel;
            this.notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        if (this.followersModel == null){
            return 0;
        }
        else {
            return followersModel.getUsers().size();
        }

    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {


        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        }
        else {
            LayoutInflater inflater = (LayoutInflater)   context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.layout_follower_item, parent, false);
            holder = new ViewHolder(view);
//            holder.lbUser = (TextView)view.findViewById(R.id.lbUser);
//            holder.btInvite = (Button)view.findViewById(R.id.btInvite);
//            holder.picProfile = (ImageView)view.findViewById(R.id.picProfile);
            view.setTag(holder);
        }
        User user = followersModel.getUsers().get(position);

        Picasso.with(context)
                .load(VdoMaxAplication.IMAGE_ENDPOINT + user.getAvatar())
                .resize(sizePicProfile , sizePicProfile)
                .placeholder(R.drawable.avatar)
                .centerInside()
                .into(holder.picProfile);

        holder.lbUser.setText(user.getName());

        return view;
    }
    class ViewHolder {


        @Optional @InjectView(R.id.picProfile)
        ImageView picProfile;

        @Optional @InjectView(R.id.lbUser)
        TextView lbUser;

        @Optional @InjectView(R.id.btInvite)
        Button btInvite;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }

}
