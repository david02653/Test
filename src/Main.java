import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.helper.Validate;

public class Main {
    public static void main( String[] args ){
        //sightTest();
        String URL = "http://travel.network.com.tw/tourguide/twnmap/keelungcity/";

        //getURL(URL);

        KeelungSightCrawler crawler = new KeelungSightCrawler();
        Sight[] sights = crawler.getItem(URL);

        //System.out.println("length = " + sights.length);
        //System.out.println(sights[0].getSightName());

        for(Sight s: sights){
            //System.out.println(s.getSightName());
            //System.out.println(s.getAddress());
            System.out.println(s);
        }
    }

    /*
    private static void sightTest(){
        System.out.println("javabean 'Sight' testing");

        Sight tmp = new Sight();

        tmp.setSightName("tmp");
        tmp.setZone("none");
        tmp.setCategory("test");
        tmp.setPhotoURL("hollow.jpg");
        tmp.setAddress("nowhere");

        System.out.println(tmp.getSightName());
        System.out.println(tmp.getZone());
        System.out.println(tmp.getCategory());
        System.out.println(tmp.getPhotoURL());
        System.out.println(tmp.getAddress());
    }
    */

    static void getURL( String url ){
        try{
            Document doc = Jsoup.connect(url)
                                .userAgent("\"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36")
                                .get();
            System.out.println(doc.text());
        }
        catch ( Exception e ){
            System.out.println(e.getMessage());
        }
    }
}
