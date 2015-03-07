package com.dev.chat.vdomax.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import com.dev.chat.vdomax.R;

/**
 * Created by Adisorn on 7/3/2558.
 */
public class DialogBlogFollow extends Dialog {
    private Context context;
    public DialogBlogFollow(Context context) {
        super(context);
        this.context = context;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_blog_follow);

    }
}
