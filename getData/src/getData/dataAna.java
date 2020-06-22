package getData;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class dataAna {
	public static String json;
	
	public static void main(String[] args) throws ParseException {
		loadJSON jsondata=new loadJSON();
		json=jsondata.getJSON();
//		System . out . print ( json ) ;
		JSONObject jsonObject=(JSONObject) new JSONParser().parse(json);
//		System . out . print ( jsonObject ) ;
		String fileName1="TokyoData.txt";
		String fileName2="TotalData.txt";
		JSONArray perData=(JSONArray) jsonObject.get("prefectures");
//		System . out . print ( perData ) ;
		JSONObject TokyoData=(JSONObject) perData.get(0);
//		System . out . print ( TokyoData ) ;
		JSONArray SumData=(JSONArray) jsonObject.get("daily");
//		System . out . print ( TokyoData ) ;
		JSONArray TokyoinfData=(JSONArray) TokyoData.get("dailyConfirmedCount");
//		System . out . print ( json ) ;
		try
		{
			FileWriter writer=new FileWriter(fileName1);
			String t=TokyoData.get("dailyConfirmedStartDate").toString();
			writer.write("StartDate:"+t+"(dailyComfirmedData)"+"\n");
			for (int i=0;i<TokyoinfData.size();i++) {
				String s=TokyoinfData.get(i).toString();
				writer.write(s+"\n");
			}
			writer.close();
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		try
		{
			FileWriter writer=new FileWriter(fileName2);
			writer.write("TotalConfirmedCumulative");
			writer.write("\t");
			writer.write("DailyRecovered");
			writer.write("\n");
			for (int i=0;i<SumData.size();i++) {
				JSONObject j=(JSONObject) SumData.get(i);
				String d=j.get("date").toString();
				String s=j.get("confirmedCumulative").toString();
				String r=j.get("recovered").toString();
				writer.write(d+"\t"+s+"\t"+r+"\n");
			}
			writer.close();
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
