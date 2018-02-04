import com.sun.org.apache.xerces.internal.dom.ParentNode;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import java.io.IOException;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
public class livescoreparser{

    public static void main(String[] args) throws IOException, Exception
    {
        try 
        {
            DOMParser parser = new DOMParser();
            parser.parse("C:\\Users\\sudar\\Documents\\NetBeansProjects\\SE Project\\src\\livescores.xml"); 

            org.w3c.dom.Document doc  = parser.getDocument();

            NodeList list = doc.getElementsByTagName("item");

            for(int i = 0, length = list.getLength(); i < length; i++)
            {
                Element city  = (Element)list.item(i);
                ParentNode description = (ParentNode)doc.getElementsByTagName("description").item(i);
                System.out.println(description.getTextContent());
            }
        }catch (Exception e) 
            {         
                System.out.println(e.getMessage());
            }     
    }
}
