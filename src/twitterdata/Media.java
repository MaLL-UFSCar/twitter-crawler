package twitterdata;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Represents the Media of a tweet in a database
 * @author Saulo Domingos de Souza Pedro
 * @version 1.0
 */
public class Media {
	
	private int idMedia;
	private int idTweetInfo;
	private String mediaURL;
	private String mediaURLHttps;
	
	public int getIdMedia() {
		return idMedia;
	}
	public void setIdMedia(int idMedia) {
		this.idMedia = idMedia;
	}
	public int getIdTweetInfo() {
		return idTweetInfo;
	}
	public void setIdTweetInfo(int idTweetInfo) {
		this.idTweetInfo = idTweetInfo;
	}
	public String getMediaURL() {
		return mediaURL;
	}
	public void setMediaURL(String mediaURL) {
		this.mediaURL = mediaURL;
	}
	public String getMediaURLHttps() {
		return mediaURLHttps;
	}
	public void setMediaURLHttps(String mediaURLHttps) {
		this.mediaURLHttps = mediaURLHttps;
	}
	
	/**
	 * Inserts a {@link Media} instance into a database
	 * @param conn A database connection
	 */
	public void insertMedia(Connection conn) throws SQLException{
		
		String strSQL = "INSERT INTO TWITTERREADER.MEDIA (ID_TWEETINFO,MEDIAURL,MEDIAURLHTTPS) VALUES (?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(strSQL);
		
		ps.setInt(1, this.getIdTweetInfo());
		ps.setString(2, this.getMediaURL());
		ps.setString(3, this.getMediaURLHttps());
		
		ps.executeUpdate();
		
	}

}
