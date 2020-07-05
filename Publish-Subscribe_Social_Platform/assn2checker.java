import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class assn2checker
{
	public static void main ( String args [])
	{
		BufferedReader br = null;
		SocialMedia r =new SocialMedia();

		try {
			String actionString;
			br = new BufferedReader(new FileReader("actions2.txt"));

			while ((actionString = br.readLine()) != null) {
				r.performAction(actionString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}
