package twitterreader;

import utils.Symbol;

public class TwitterReaderRunner {

	/**
	 * Runner class for TwitterReader
	 * @param args
	 */
	public static void main(String[] args) {
		
		TwitterReaderConfiguration trc= new TwitterReaderConfiguration(args[0]);
		
		TwitterReader twitterReader = new TwitterReader(trc);
		
		switch (trc.getReadMethod()){
		case Symbol.READ_FROM_PARAMLIST:
			twitterReader.readTweetFromSearchList();
			break;
		case Symbol.READ_FROM_USERLIST:
			twitterReader.readTweetFromUserList();
			break;
		}
	}

}
