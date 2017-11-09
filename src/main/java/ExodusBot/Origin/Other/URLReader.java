package ExodusBot.Origin.Other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by josep on 02/08/2017.
 */
public class URLReader {

    public static String URLRead(String URL) throws Exception {


            URL oracle = new URL(URL);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                return inputLine;
            in.close();
            return inputLine;



    }

}
