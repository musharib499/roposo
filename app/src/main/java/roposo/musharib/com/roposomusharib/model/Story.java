
package roposo.musharib.com.roposomusharib.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Story implements Serializable{

    private String description;
    private String id;
    private String verb;
    private String db;
    private String url;
    private String profile;
    private String si;
    private String type;
    private String title;
    private Boolean likeFlag;

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    private ArrayList<User> userArrayList;


    private Integer likesCount;
    private Integer commentCount;


    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The verb
     */
    public String getVerb() {
        return verb;
    }

    /**
     * 
     * @param verb
     *     The verb
     */
    public void setVerb(String verb) {
        this.verb = verb;
    }

    /**
     * 
     * @return
     *     The db
     */
    public String getDb() {
        return db;
    }

    /**
     * 
     * @param db
     *     The db
     */
    public void setDb(String db) {
        this.db = db;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The si
     */
    public String getSi() {
        return si;
    }

    /**
     * 
     * @param si
     *     The si
     */
    public void setSi(String si) {
        this.si = si;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The likeFlag
     */
    public Boolean getLikeFlag() {
        return likeFlag;
    }

    /**
     * 
     * @param likeFlag
     *     The like_flag
     */
    public void setLikeFlag(Boolean likeFlag) {
        this.likeFlag = likeFlag;
    }

    /**
     * 
     * @return
     *     The likesCount
     */
    public Integer getLikesCount() {
        return likesCount;
    }

    /**
     * 
     * @param likesCount
     *     The likes_count
     */
    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    /**
     * 
     * @return
     *     The commentCount
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * 
     * @param commentCount
     *     The comment_count
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

}
