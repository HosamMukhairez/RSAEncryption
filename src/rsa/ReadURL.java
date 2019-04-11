/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

import java.net.*;
import java.io.*;

class ReadURL {

    public static void main(String[] args) {
        try {
            URL yahoo = new URL("http://www.yahoo.com/");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(yahoo.openStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                // Process each line.
                System.out.println(inputLine);
            }
            in.close();

        } catch (MalformedURLException me) {
            System.out.println(me);

        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }//end main
}//end class ReadURL

