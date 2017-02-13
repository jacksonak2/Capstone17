/**
 *  Author: Francisco Fantl
 *  Project: Overripe Pantry
 */

import java.io.*;
import java.net.*;

/**
 *  Universal Product Code (UPC) API Prototype
 *
 *  This method provides with product codes to the upcitemdb API and returns a JSON object,
 *  with an object.
 *
 *  TODO
 *  * Setup exceptions when creating the JSON parser.
 *  * Prettify.
 */
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
