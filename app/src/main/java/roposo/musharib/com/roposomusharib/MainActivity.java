package roposo.musharib.com.roposomusharib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import roposo.musharib.com.roposomusharib.ViewHolder.StoryViewHolder;
import roposo.musharib.com.roposomusharib.ViewHolder.UserViewHolder;
import roposo.musharib.com.roposomusharib.model.Story;
import roposo.musharib.com.roposomusharib.model.User;
import roposo.musharib.com.roposomusharib.util.Util;

public class MainActivity extends AppCompatActivity implements BaseAdapter.BindAdapterListener<UserViewHolder>{

/*
    public ArrayList<Story> getStory() {
        return story;
    }

    public void setStory(ArrayList<Story> story) {
        this.story = story;
    }

    private ArrayList<Story> story = null;*/
    private RecyclerView recyclerView;


    public ArrayList<User> getUserStory() {
        return userStory;
    }

    public void setUserStory(ArrayList<User> userStory) {
        this.userStory = userStory;
    }
    private BaseAdapter<User, UserViewHolder> baseAdapter=null;
    public static int followPosition=-1;

    private  ArrayList<User> userStory=null;
    private UserViewHolder userViewHolder=null;
    private UserSroryActivity userSroryActivity;
    public static User userData=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycle_list);

        try {
          //  JSONArray ja = Util.loadJSONFromAsset(getApplicationContext(), "story");
            JSONArray jsonArray= Util.loadJSONFromAsset(getApplicationContext(), "user");
            userStory = new ArrayList<>();

                for (int j = 0; j < jsonArray.length(); j++) {
                    JSONObject jsonObject=jsonArray.getJSONObject(j);

                        User user = new User();
                        user.setAbout(jsonObject.getString("about"));
                        user.setUsername(jsonObject.getString("username"));
                        user.setId(jsonObject.getString("id"));
                        user.setFollowers(jsonObject.getInt("followers"));
                        user.setFollowing(jsonObject.getInt("following"));
                        user.setImage(jsonObject.getString("image"));
                        user.setUrl(jsonObject.getString("url"));
                        user.setHandle(jsonObject.getString("handle"));
                        user.setIsFollowing(jsonObject.getBoolean("is_following"));
                        user.setCreatedOn(jsonObject.getInt("createdOn"));
                        userStory.add(user);



                }

                setUserStory(userStory);

            } catch (JSONException e1) {
            e1.printStackTrace();
        }

        setData();




    }

    public void setData() {
         baseAdapter = new BaseAdapter<>(this, getUserStory(), this, UserViewHolder.class, R.layout.user_item);
        Util.recyclerView(recyclerView, this, true).setAdapter(baseAdapter);
    }



    @Override
    public void onBind(UserViewHolder holder, final int position) {
        userViewHolder=holder;
        holder.tvName.setText(getUserStory().get(position).getUsername());
        holder.tvHandler.setText(getUserStory().get(position).getHandle());
        holder.tvFollower.setText(getUserStory().get(position).getFollowers()+" Follower");
        holder.tvFollowing.setText(getUserStory().get(position).getFollowers()+" Following");
        holder.tvAbount.setText(getUserStory().get(position).getAbout());

        Util.loadImage(this,getUserStory().get(position).getImage(),holder.ivProfile);

        final User list=getUserStory().get(position);
        if (getUserStory().get(position).getIsFollowing()) {
            holder.btFollow.setText("Follow");

            holder.btFollow.setTextColor(getResources().getColor(R.color.white));
            holder.btFollow.setBackgroundResource(R.drawable.button_enable);
        }else {

            holder.btFollow.setText("Unfollow");
            holder.btFollow.setTextColor(getResources().getColor(R.color.black));
            holder.btFollow.setBackgroundResource(R.drawable.button_disabled);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,UserSroryActivity.class);
                intent.putExtra("db",list);
                intent.putExtra("position",position);
                startActivity(intent);


            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
       if (followPosition!=-1)
       {

           userStory.remove(followPosition);
           userStory.add(followPosition,userData);
           baseAdapter.notifyItemChanged(followPosition);


       }

           }


}
