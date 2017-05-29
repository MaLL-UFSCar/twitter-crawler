package twitterdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Saulo Domingos de Souza Pedro
 * @version 1.0
 * 
 * Represents the URL of a tweet in a database
 */
public class URLTweet {
	
	private int idURLTweet;
	private int idTweetInfo;
	private String url;
	
	public int getIdURLTweet() {
		return idURLTweet;
	}
	public void setIdURLTweet(int idURLTweet) {
		this.idURLTweet = idURLTweet;
	}
	public int getIdTweetInfo() {
		return idTweetInfo;
	}
	public void setIdTweetInfo(int idTweetInfo) {
		this.idTweetInfo = idTweetInfo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Inserts a {@link URLTweet} instance into a database
	 * @param conn A database connection
	 */
	public void insertURLTweet(Connection conn) throws SQLException{
		
		String strSQL = "INSERT INTO TWITTERREADER.URLTWEET (ID_TWEETINFO,URL) VALUES (?,?)";
		
		PreparedStatement ps = conn.prepareStatement(strSQL);
		
		ps.setInt(1, this.getIdTweetInfo());
		ps.setString(2, this.getUrl());
		
		ps.executeUpdate();
		
	}
	
	

}