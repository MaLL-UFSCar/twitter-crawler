package twitterdata;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Represents the Hashtag of a tweet in a database
 * @author Saulo Domingos de Souza Pedro
 * @version 1.0
 */
public class Hashtag {
	
	private int idHashtag;
	private int idTweetInfo;
	private String text;

	public int getIdHashtag() {
		return this.idHashtag;
	}

	public void setIdHashtag(int idHashtag) {
		this.idHashtag = idHashtag;
	}
	
	public int getIdTweetInfo() {
		return this.idTweetInfo;
	}

	public void setIdTweetInfo(int idTweetInfo) {
		this.idTweetInfo = idTweetInfo;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Inserts a {@link Hashtag} instance into a database
	 * @param conn A database connection
	 */
	public void insertHashtag(Connection conn) throws SQLException{
		
		String strSQL = "INSERT INTO TWITTERREADER.HASHTAG (ID_TWEETINFO,TEXT) VALUES (?,?)";
		
		PreparedStatement ps = conn.prepareStatement(strSQL);
		
		ps.setInt(1, this.getIdTweetInfo());
		ps.setString(2, this.getText());
		
		ps.executeUpdate();
	}
	
	
	

}
