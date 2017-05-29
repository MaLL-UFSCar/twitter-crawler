package twitterreader;

import java.util.List;

import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitterdata.TweetInfo;

import com.google.gson.Gson;
import authentication.TwitterAuth;

/**
 * Reads tweets from specific Twitter users and place them standard output
 * @author Saulo Domingos de Souza Pedro
 * @version 1.0
 */

public class TwitterReader{

	/**
	 * Read tweets from a list of twitter names
	 * @param user A list of twitter names to be the source of the reader 
	 */
	
	private TwitterReaderConfiguration trc;
	
	public TwitterReaderConfiguration getTwitterReaderConfiguration() {
		return trc;
	}

	public void setTwitterReaderConfiguration(TwitterReaderConfiguration trc) {
		this.trc = trc;
	}

	public TwitterReader(TwitterReaderConfiguration trc){
		this.setTwitterReaderConfiguration(trc);
	}

	private void writeTweet(List<Status> tweetList, String filename){

		for(int i=0;i<tweetList.size();i++){

			Status status = tweetList.get(i);

			TweetInfo tweetInfo = new TweetInfo(status);

			Gson gson = new Gson();
			String stringJson = gson.toJson(tweetInfo);

			System.out.println(stringJson);
		}
	}
	
	/**
	 * Read tweets from a query list
	 */
	public void readTweetFromSearchList(){
		Twitter twitter;
		TwitterAuth twitterAuth = new TwitterAuth(this.getTwitterReaderConfiguration().getTwitterAuthConfigurationPath());

		try {
			twitter = twitterAuth.getAuthenticatedConnection();

			String[] searchParams = this.getTwitterReaderConfiguration().getParamList();

			for(int k=0;k<searchParams.length;k++){

				Query query = new Query(searchParams[k]);

				List<Status> tweetList = twitter.search(query).getTweets();

				this.writeTweet(tweetList,searchParams[k]);
			}
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Read tweets from a list of Twitter users
	 */
	public void readTweetFromUserList() {

		Twitter twitter;
		TwitterAuth twitterAuth = new TwitterAuth(this.getTwitterReaderConfiguration().getTwitterAuthConfigurationPath());
		try {
			twitter = twitterAuth.getAuthenticatedConnection();

			String[] userList = this.getTwitterReaderConfiguration().getUserList();

			for(int k=0;k<userList.length;k++){ //for each user from user[], read tweets.

				Paging paging = new Paging(1, 100);
				ResponseList<Status> tweetList;

				tweetList = twitter.getUserTimeline(userList[k], paging);
				this.writeTweet(tweetList,userList[k]);
			} 

		} catch (TwitterException e1) {
			e1.printStackTrace();
		}

	}
}
