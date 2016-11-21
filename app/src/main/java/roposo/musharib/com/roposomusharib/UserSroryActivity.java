package roposo.musharib.com.roposomusharib;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import roposo.musharib.com.roposomusharib.ViewHolder.StoryViewHolder;
import roposo.musharib.com.roposomusharib.model.Story;
import roposo.musharib.com.roposomusharib.model.User;
import roposo.musharib.com.roposomusharib.util.Util;

public class UserSroryActivity extends AppCompatActivity implements BaseAdapter.BindAdapterListener<StoryViewHolder> {
    private  FrameLayout collFrame;
    private ImageView ivCProfile;
  //  private NestedScrollView nestedScrollView;
    private TextView tvName,tvHandler,tvFollower,tvFollowing,tvAbount;
    private ImageView ivProfile;
    private TextView btFollow;
    private RecyclerView recyclerView;

    public MyCallbackClass getMyCallbackClass() {
        return myCallbackClass;
    }

    public void setMyCallbackClass(MyCallbackClass myCallbackClass) {
        this.myCallbackClass = myCallbackClass;
    }

    MyCallbackClass myCallbackClass;
     interface MyCallbackClass{
       public void setFollow(int position);
    }


    public ArrayList<Story> getStory() {
        return story;
    }

    public void setStory(ArrayList<Story> story) {
        this.story = story;
    }

    private ArrayList<Story> story = null;
    User users=null;
    private String db=null;
    private String image=null;
    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_srory);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout  collapsingToolbarLayout= (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitleEnabled(false);
       // mCallback = (TextUiUpdate) getApplicationContext();
        ivCProfile= (ImageView) findViewById(R.id.ivCProfile);
        //users=new User();
        Bundle intent=getIntent().getExtras();
        users=new User();
        if (intent!=null) {
            users = (User) intent.getSerializable("db");
            position= (int) intent.get("position");

          db=users.getId();
        }



        //nestedScrollView= (NestedScrollView) findViewById(R.id.containNested);

        /*try {
            JSONArray jsonArray = Util.loadJSONFromAsset(getApplicationContext(), "user");
            for (int j = 0; j < jsonArray.length(); j++) {
                JSONObject jsonObject = jsonArray.getJSONObject(j);
                if (db.equals(jsonObject.getString("id"))) {
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
                    users.add(user);

                }
            }
        }catch (JSONException e) {
                e.printStackTrace();
            }*/

        try {
            JSONArray ja = Util.loadJSONFromAsset(getApplicationContext(), "story");
            story = new ArrayList<>();

            for (int i = 0; i < ja.length(); i++) {
                JSONObject job = ja.getJSONObject(i);
                Story user = new Story();
                if (db.equals(job.getString("db"))) {
                    user.setDescription(job.getString("description"));
                    user.setId(job.getString("id"));
                    user.setVerb(job.getString("verb"));
                    user.setDb(job.getString("db"));
                    user.setUrl(job.getString("url"));
                    user.setSi(job.getString("si"));
                    user.setType(job.getString("type"));
                    user.setTitle(job.getString("title"));
                    user.setLikeFlag(job.getBoolean("like_flag"));
                    user.setLikesCount(job.getInt("likes_count"));
                    user.setCommentCount(job.getInt("comment_count"));
                    story.add(user);
                }

            }
            setStory(story);
            onInitView();
            setData();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void onInitView()
    {
        tvName= (TextView) findViewById(R.id.tvName);
        tvHandler= (TextView) findViewById(R.id.tvHandle);
        tvFollower= (TextView) findViewById(R.id.tvFollowers);
        tvFollowing= (TextView) findViewById(R.id.tvFollowing);
        tvAbount= (TextView) findViewById(R.id.tvAbout);
        ivProfile= (ImageView) findViewById(R.id.ivProfile);
        btFollow= (TextView) findViewById(R.id.btFollow);
        recyclerView= (RecyclerView) findViewById(R.id.recycle_list);

    }


    public void setData() {
       tvName.setText(users.getUsername());
       tvHandler.setText(users.getHandle());
       tvFollower.setText(users.getFollowers()+" Follower");
       tvFollowing.setText(""+users.getFollowers()+" Following");
       tvAbount.setText(""+users.getAbout());
       Util.loadImage(this,users.getImage(),ivProfile);
       Util.loadImage(this,getStory().get(0).getSi(),ivCProfile);
        if (users.getIsFollowing()) {
            btFollow.setText("Follow");

            btFollow.setTextColor(getResources().getColor(R.color.white));
            btFollow.setBackgroundResource(R.drawable.button_enable);
        }else {
                btFollow.setText("Unfollow");
                users.setIsFollowing(false);
                btFollow.setTextColor(getResources().getColor(R.color.black));
                btFollow.setBackgroundResource(R.drawable.button_disabled);

        }

        btFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  myCallbackClass=getMyCallbackClass();
                if (myCallbackClass!=null) {
                    */
                Intent intent = new Intent();
                intent.setAction("MyBroadcast");
                intent.putExtra("position",position);
                Log.d("position",""+position);

                    //myCallbackClass.setFollow(position);
                if (!users.getIsFollowing()) {
                    btFollow.setText("Follow");
                    users.setIsFollowing(true);
                    btFollow.setTextColor(getResources().getColor(R.color.white));
                    btFollow.setBackgroundResource(R.drawable.button_enable);
                }else {
                    btFollow.setText("Unfollow");
                    users.setIsFollowing(false);
                    btFollow.setTextColor(getResources().getColor(R.color.black));
                    btFollow.setBackgroundResource(R.drawable.button_disabled);
                }

                intent.putExtra("db",users);
                sendBroadcast(intent);
               /* }*/
            }
        });
        BaseAdapter<Story, StoryViewHolder> baseAdapter = new BaseAdapter<>(this, getStory(), this, StoryViewHolder.class, R.layout.story_list_item);
        Util.recyclerView(recyclerView, this, true).setAdapter(baseAdapter);
    }

    @Override
    public void onBind(StoryViewHolder holder, int position) {
        Util.loadImage(this,users.getImage(),holder.ivProfile);
        Util.loadImage(this,getStory().get(position).getSi(),holder.ivBoardImage);
        final String db=getStory().get(position).getDb();

        holder.tvTitle.setText(getStory().get(position).getTitle());
        holder.tvVerb.setText(getStory().get(position).getVerb());
        holder.tvLikeCount.setText(getStory().get(position).getLikesCount()+ " Like ");
        holder.tvComment.setText(getStory().get(position).getCommentCount()+" Comment");
        holder.tvDescription.setText(getStory().get(position).getDescription());
        holder.btFollow.setVisibility(View.GONE);
       /* if (users.get(0).getIsFollowing()) {
            holder.btFollow.setEnabled(true);
            holder.btFollow.setText("Follow");
            holder.btFollow.setTextColor(getResources().getColor(R.color.white));
        }else {

            holder.btFollow.setEnabled(false);
            holder.btFollow.setText("Unfollow");
            holder.btFollow.setTextColor(getResources().getColor(R.color.black));
        }*/


    }
}
