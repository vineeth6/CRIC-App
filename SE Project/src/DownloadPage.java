import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class DownloadPage {

    public static void main(String[] args) throws IOException {

        // Make a URL to the web page
        URL url = new URL("http://static.cricinfo.com/rss/livescores.xml");


        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();
        PrintWriter writer = new PrintWriter(new File("C:\\Users\\sudar\\Documents\\NetBeansProjects\\SE Project\\src\\livescores.xml"));
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;

        
        
        // read each line and write to System.out
        while ((line = br.readLine()) != null) {
            try{
                writer.println(line);

            }catch(Exception ex)
            {
                System.out.println("Couldn't write on the file");
            }
        }
        writer.close();
    }
}
