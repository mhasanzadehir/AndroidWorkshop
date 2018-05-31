package ir.sharif.nightowls.viewholders;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ir.sharif.nightowls.R;
import ir.sharif.nightowls.listeners.CallItemListener;

/**
 * Created by mahdihs76 on 5/31/18.
 */

public class TeacherViewHolder extends RecyclerView.ViewHolder {

    public TextView nickNameTextView;
    public TextView roomTextView;
    public TextView roleTextView;
    public ImageView image;
    public ImageView callImageView;

    public TeacherViewHolder(View itemView, final CallItemListener listener) {
        super(itemView);

        nickNameTextView = itemView.findViewById(R.id.nick_name_tv);
        roomTextView = itemView.findViewById(R.id.room_tv);
        roleTextView = itemView.findViewById(R.id.role_tv);
        image = itemView.findViewById(R.id.image);
        callImageView = itemView.findViewById(R.id.call);

        callImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.call(getAdapterPosition());
            }
        });

    }


}
