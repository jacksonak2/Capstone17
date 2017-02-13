import java.io.*;
import java.net.*;

public class getUPC{

   public static String getUPC(String upcCode) throws Exception {
      StringBuilder result = new StringBuilder();
      URL url = new URL("https://api.upcitemdb.com/prod/trial/lookup?upc=" + upcCode);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String line;
      while ((line = rd.readLine()) != null) {
         result.append(line);
      }
      rd.close();
      return result.toString();
   }

   public static void main(String[] args) throws Exception {
     System.out.println(getUPC("033383655208"));
   }
}
