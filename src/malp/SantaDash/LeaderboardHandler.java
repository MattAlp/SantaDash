package malp.SantaDash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LeaderboardHandler {
	
	public static void registerScore(int score)
	{
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL("http://malp.pythonanywhere.com/smart/" + System.getProperty("user.name") + "/" + score).openConnection();
			connection.connect();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			System.out.println(br.readLine());
			br.close();
			connection.disconnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getScores()
	{
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL("http://malp.pythonanywhere.com/data/score").openConnection();
			connection.setConnectTimeout(5000);
			connection.connect();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			String tmp = "";
			while ((line = br.readLine()) != null) 
			{
				if (line.isEmpty()) 
				{
					break;
			    }
			   
			   tmp +=  line.substring(0, line.lastIndexOf(" "))+ " " + line.substring(line.lastIndexOf(" "), line.length()) + "\n";
			}
			return tmp;
		} catch (Exception e) {
			e.printStackTrace();
			return "Couldn't connect to the leaderboards :(";
		}
		
	}
	
}
