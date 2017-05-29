package twitterdata;
import java.sql.Timestamp;
import java.util.Vector;

import twitter4j.HashtagEntity;
import twitter4j.MediaEntity;
import twitter4j.Status;
import twitter4j.URLEntity;
import twitter4j.UserMentionEntity;
/**
 * 
 * Represents the content of tweet instance
 * @author Saulo Domingos de Souza Pedro
 * @version 2.0
 * 
 */
public class TweetInfo {
	
	private long idStatus;
	private long inReplyTo;
	private long idUser;
	private String status;
	private long replyToStatus;
	private long replyToUser;
	private long retweetCount;
	private String screenName;
	private String placeName;
	private String placeCountry;
	private String source;
	private Timestamp createdAt;
	
	private Vector<Mention> mentionList;
	private Vector<Hashtag> hashtagList;
	private Vector<Media> mediaList;
	private Vector<URLTweet> urlTweetList;
	
	private boolean isFavorite;
	private boolean isRetweet;
	private boolean isTruncated;
	
	/**
	 * Builds TweetInfo.
	 * 
	 * @see Status
	 */
	public TweetInfo(Status status){
		
		this.mentionList = new Vector<Mention>();
		this.hashtagList = new Vector<Hashtag>();
		this.mediaList = new Vector<Media>();
		this.urlTweetList = new Vector<URLTweet>();
		
		this.setIdUser(status.getUser().getId());
		this.setText(status.getText());
		this.setReplyToStatus(status.getInReplyToStatusId());
		this.setReplyToUser(status.getInReplyToUserId());
		this.setRetweetCount(status.getRetweetCount());
		this.setSource(status.getSource());
		this.setCreatedAt(new Timestamp(status.getCreatedAt().getTime()));
		
		this.setMentionList(status.getUserMentionEntities());
		this.setHashtagList(status.getHashtagEntities());
		this.setMediaList(status.getMediaEntities());
		this.setURLTweetList(status.getURLEntities());
		
		this.setIsFavorite(status.isFavorited());
		this.setIsRetweet(status.isRetweet());
		this.setIsTruncated(status.isTruncated());

	}
	
	public long getIdUser() {
		return idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	public String getStatus() {
		return status;
	}
	public void setText(String status) {
		this.status = status;
	}
	public long getReplyToStatus() {
		return replyToStatus;
	}
	public void setReplyToStatus(long replyToStatus) {
		this.replyToStatus = replyToStatus;
	}
	public long getReplyToUser() {
		return replyToUser;
	}
	public void setReplyToUser(long replyToUser) {
		this.replyToUser = replyToUser;
	}
	public long getRetweetCount() {
		return retweetCount;
	}
	public void setRetweetCount(long retweetCount) {
		this.retweetCount = retweetCount;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getPlaceCountry() {
		return placeCountry;
	}
	public void setPlaceCountry(String placeCountry) {
		this.placeCountry = placeCountry;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public long getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(long idStatus) {
		this.idStatus = idStatus;
	}

	public long getInReplyTo() {
		return inReplyTo;
	}

	public void setInReplyTo(long inReplyTo) {
		this.inReplyTo = inReplyTo;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}

	public void setRetweet(boolean isRetweet) {
		this.isRetweet = isRetweet;
	}

	public void setTruncated(boolean isTruncated) {
		this.isTruncated = isTruncated;
	}

	/**
	 * Set parameters of the list of {@link Mention} instances.
	 * 
	 * @param userMentionEntity A list of mentions in a tweet
	 */
	public void setMentionList(UserMentionEntity[] userMentionEntity){

		if(userMentionEntity != null){

			for(int i=0;i<userMentionEntity.length;i++){

				Mention mention = new Mention();

				mention.setIdUser(userMentionEntity[i].getId());
				mention.setName(userMentionEntity[i].getName());
				mention.setScreenName(userMentionEntity[i].getScreenName());

				this.mentionList.add(mention);
			}
		}
		
	}
	
	public Vector<Mention> getMentionList(){
		return this.mentionList;
	}
	
	
	/**
	 * Set parameters of the list of Hashtag instances.
	 * 
	 * @param hashtagEntity A list of hashtags in a tweet
	 */
	public void setHashtagList(HashtagEntity[] hashtagEntity){

		if(hashtagEntity != null){

			for(int i=0;i<hashtagEntity.length;i++){

				Hashtag hashtag = new Hashtag();

				hashtag.setText(hashtagEntity[i].getText());

				this.hashtagList.add(hashtag);
			}
		}
		
	}
	
	public Vector<Hashtag> getHashtagList(){
		return this.hashtagList;
	}
	
	
	/**
	 * Set parameters of the list of Media instances
	 * 
	 * @param mediaEntity A list of media instances in a tweet
	 */
	public void setMediaList(MediaEntity[] mediaEntity){

		if(mediaEntity != null){

			for(int i=0;i<mediaEntity.length;i++){

				Media media = new Media();

				media.setMediaURL(mediaEntity[i].getMediaURL());
				media.setMediaURLHttps(mediaEntity[i].getMediaURLHttps());

				this.mediaList.add(media);

			}
		}

	}
	
	
	/**
	 * Set parameters of the list of URLTweet instances.
	 * 
	 * @param urlEntity A list of URLs in a tweet
	 */
	public void setURLTweetList(URLEntity[] urlEntity){
		
		if(urlEntity != null){

			for(int i=0;i<urlEntity.length;i++){

		
				if(urlEntity[i].getURL() != null){		//fixing bug of Twitter4j. Sometimes a URLEntity does not have URL

					URLTweet urlTweet = new URLTweet();

					urlTweet.setUrl(urlEntity[i].getURL().toString());

					this.urlTweetList.add(urlTweet);
				}

			}
		}
		
	}
	
	public Vector<Media> getMediaList(){
		return this.mediaList;
	}
	
	public boolean getIsFavorite() {
		return isFavorite;
	}
	public void setIsFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}
	public boolean getIsRetweet() {
		return isRetweet;
	}
	public void setIsRetweet(boolean isRetweet) {
		this.isRetweet = isRetweet;
	}
	public boolean getIsTruncated() {
		return isTruncated;
	}
	public void setIsTruncated(boolean isTruncated) {
		this.isTruncated = isTruncated;
	}

}