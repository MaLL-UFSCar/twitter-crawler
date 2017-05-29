package twitterdata;
/**
 * Represents the mention of a tweet in a database
 * @author Saulo Domingos de Souza Pedro
 * @version 1.0
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Mention {
	
	private int  idMention;
	private int idTweetInfo;
	private long idUser;		//the id of the user mentioned 
	private String name;
	private String screenName;
	
	public int getIdMention() {
		return idMention;
	}

	public void setIdMention(int idMention) {
		this.idMention = idMention;
	}

	public int getIdTweetInfo() {
		return idTweetInfo;
	}

	public void setIdTweetInfo(int idTweetInfo) {
		this.idTweetInfo = idTweetInfo;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
}
