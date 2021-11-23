import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://www.tongchengau.com/";
        Document doc = Jsoup.parse(new URL(url), 10000);
        Element body = doc.getElementById("wrap");
        System.out.println(body);
    }
}
