package roposo.musharib.com.roposomusharib.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import roposo.musharib.com.roposomusharib.R;

/**
 * Created by gaadi on 20/11/16.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {
    public TextView tvName,tvHandler,tvFollower,tvFollowing,tvAbount;
    public ImageView ivProfile;
    public TextView btFollow;

    public UserViewHolder(View itemView) {
        super(itemView);

        tvName= (TextView) itemView.findViewById(R.id.tvName);
        tvHandler= (TextView) itemView.findViewById(R.id.tvHandle);
        tvFollower= (TextView) itemView.findViewById(R.id.tvFollowers);
        tvFollowing= (TextView) itemView.findViewById(R.id.tvFollowing);
        tvAbount= (TextView) itemView.findViewById(R.id.tvAbout);
        ivProfile= (ImageView) itemView.findViewById(R.id.ivProfile);
        btFollow= (TextView) itemView.findViewById(R.id.btFollow);
    }
}
