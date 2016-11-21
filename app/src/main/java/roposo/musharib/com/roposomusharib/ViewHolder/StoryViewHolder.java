package roposo.musharib.com.roposomusharib.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import roposo.musharib.com.roposomusharib.R;

/**
 * Created by gaadi on 20/11/16.
 */

public class StoryViewHolder extends RecyclerView.ViewHolder {
    public TextView tvDescription,tvVerb,tvType,tvTitle,tvLikeCount,tvComment;
    public ImageView ivProfile,ivBoardImage;
    public TextView btFollow;

    public StoryViewHolder(View itemView) {
        super(itemView);
        tvDescription= (TextView) itemView.findViewById(R.id.tvDescription);
        tvVerb= (TextView) itemView.findViewById(R.id.tvCreation);
        tvTitle= (TextView) itemView.findViewById(R.id.tvTitle);
        ivProfile= (ImageView) itemView.findViewById(R.id.ivProfile);
        ivBoardImage= (ImageView) itemView.findViewById(R.id.ivBoardImage);
        tvLikeCount= (TextView) itemView.findViewById(R.id.tvLike);
        tvComment= (TextView) itemView.findViewById(R.id.tvComment);
        btFollow= (TextView) itemView.findViewById(R.id.btFollow);

    }
}
