package twitterreader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import parser.TwitterParser;
import twitterdata.TweetInfo;

public class TwitterParserRunner {

	public static void main(String[] args) {
		
		try {
			FileWriter fstream;	
			fstream = new FileWriter(args[1]);
			BufferedWriter out = new BufferedWriter(fstream);
			
			TwitterParser twitterParser = new TwitterParser(args[0]);
			
			Vector<TweetInfo> tweetList = twitterParser.parse();
			
			for(int i=0;i<tweetList.size();i++){
				out.write(tweetList.get(i).getStatus().replaceAll("@[\\w]*", "")+"\n");
			}
			
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
