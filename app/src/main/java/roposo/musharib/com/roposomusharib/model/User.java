package roposo.musharib.com.roposomusharib.model;

import java.io.Serializable;

public class User implements Serializable {

    private String about;
    private String id;
    private String username;
    private Integer followers;
    private Integer following;
    private String image;
    private String url;
    private String handle;
    private Boolean isFollowing;
    private Integer createdOn;

    /**
     *
     * @return
     * The about
     */
    public String getAbout() {
        return about;
    }

    /**
     *
     * @param about
     * The about
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     * The followers
     */
    public Integer getFollowers() {
        return followers;
    }

    /**
     *
     * @param followers
     * The followers
     */
    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    /**
     *
     * @return
     * The following
     */
    public Integer getFollowing() {
        return following;
    }

    /**
     *
     * @param following
     * The following
     */
    public void setFollowing(Integer following) {
        this.following = following;
    }

    /**
     *
     * @return
     * The image
     */
    public String getImage() {
        return image;
    }

    /**
     *
     * @param image
     * The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The handle
     */
    public String getHandle() {
        return handle;
    }

    /**
     *
     * @param handle
     * The handle
     */
    public void setHandle(String handle) {
        this.handle = handle;
    }

    /**
     *
     * @return
     * The isFollowing
     */
    public Boolean getIsFollowing() {
        return isFollowing;
    }

    /**
     *
     * @param isFollowing
     * The is_following
     */
    public void setIsFollowing(Boolean isFollowing) {
        this.isFollowing = isFollowing;
    }

    /**
     *
     * @return
     * The createdOn
     */
    public Integer getCreatedOn() {
        return createdOn;
    }

    /**
     *
     * @param createdOn
     * The createdOn
     */
    public void setCreatedOn(Integer createdOn) {
        this.createdOn = createdOn;
    }



}