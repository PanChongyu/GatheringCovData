package getData;
import java . io .*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
public class loadJSON {
	public String pURL="https://data.covid19japan.com/patient_data/latest.json";
	public String sURL="https://data.covid19japan.com/summary/latest.json";	
	public String tURL="https://data.covid19japan.com/tokyo/counts.json";
	public String json;
	public static String loadJson (String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        	} catch (MalformedURLException e) {
        		e.printStackTrace();
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
        return json.toString();
	}
	public String getJSON() {
		return json;
	}
	loadJSON()
	{
		this.json=loadJson(sURL);
	}
}
