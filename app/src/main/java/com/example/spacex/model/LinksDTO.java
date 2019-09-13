package com.example.spacex.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

@SuppressWarnings("unused")
public class LinksDTO implements Parcelable {

    public static final Creator<LinksDTO> CREATOR = new Creator<LinksDTO>() {
        @Override
        public LinksDTO createFromParcel(Parcel in) {
            return new LinksDTO(in);
        }

        @Override
        public LinksDTO[] newArray(int size) {
            return new LinksDTO[size];
        }
    };

    private String mission_patch;
    private String mission_patch_small;
    private String reddit_campaign;
    private String reddit_launch;
    private String reddit_recovery;
    private String reddit_media;
    private String presskit;
    private String article_link;
    private String wikipedia;
    private String video_link;
    private String youtube_id;
    private List<String> flickr_images;

    private LinksDTO(Parcel in) {
        mission_patch = in.readString();
        mission_patch_small = in.readString();
        reddit_campaign = in.readString();
        reddit_launch = in.readString();
        reddit_recovery = in.readString();
        reddit_media = in.readString();
        presskit = in.readString();
        article_link = in.readString();
        wikipedia = in.readString();
        video_link = in.readString();
        youtube_id = in.readString();
        flickr_images = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mission_patch);
        dest.writeString(mission_patch_small);
        dest.writeString(reddit_campaign);
        dest.writeString(reddit_launch);
        dest.writeString(reddit_recovery);
        dest.writeString(reddit_media);
        dest.writeString(presskit);
        dest.writeString(article_link);
        dest.writeString(wikipedia);
        dest.writeString(video_link);
        dest.writeString(youtube_id);
        dest.writeStringList(flickr_images);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getMission_patch() {
        return mission_patch;
    }

    public void setMission_patch(String mission_patch) {
        this.mission_patch = mission_patch;
    }

    public String getMission_patch_small() {
        return mission_patch_small;
    }

    public void setMission_patch_small(String mission_patch_small) {
        this.mission_patch_small = mission_patch_small;
    }

    public String getReddit_campaign() {
        return reddit_campaign;
    }

    public void setReddit_campaign(String reddit_campaign) {
        this.reddit_campaign = reddit_campaign;
    }

    public String getReddit_launch() {
        return reddit_launch;
    }

    public void setReddit_launch(String reddit_launch) {
        this.reddit_launch = reddit_launch;
    }

    public String getReddit_recovery() {
        return reddit_recovery;
    }

    public void setReddit_recovery(String reddit_recovery) {
        this.reddit_recovery = reddit_recovery;
    }

    public String getReddit_media() {
        return reddit_media;
    }

    public void setReddit_media(String reddit_media) {
        this.reddit_media = reddit_media;
    }

    public String getPresskit() {
        return presskit;
    }

    public void setPresskit(String presskit) {
        this.presskit = presskit;
    }

    public String getArticle_link() {
        return article_link;
    }

    public void setArticle_link(String article_link) {
        this.article_link = article_link;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getVideo_link() {
        return video_link;
    }

    public void setVideo_link(String video_link) {
        this.video_link = video_link;
    }

    public String getYoutube_id() {
        return youtube_id;
    }

    public void setYoutube_id(String youtube_id) {
        this.youtube_id = youtube_id;
    }

    public List<String> getFlickr_images() {
        return flickr_images;
    }

    public void setFlickr_images(List<String> flickr_images) {
        this.flickr_images = flickr_images;
    }
}