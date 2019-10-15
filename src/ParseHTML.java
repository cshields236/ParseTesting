import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ParseHTML {

    public ParseHTML() {

    }

    public static void main(String[] args) throws IOException {
        //getAllSpans();
        //getISEQ();
        getBoris();

    }

    public static void getAllSpans() throws IOException {
        Document doc = Jsoup.connect("https://www.ticketmaster.ie/browse/all-concerts-catid-10001/music-rid-10001").get();

        String title = doc.title();

        //System.out.println(title);

        Elements es = doc.getElementsByTag("span");
        for (Element e : es) {
            System.out.println(e.text());
        }
    }

    public static void getISEQ() throws IOException {
        Document doc = Jsoup.connect(" https://www.rte.ie/news/markets/iseq/").get();

        Elements table = doc.getElementsByClass("business-shares");

        for (Element e : table) {
            Elements data = e.getElementsByTag("tr");

            for (Element d : data) {
                for (int i = 0; i < 2; i++) {
                    System.out.println(d.getElementsByIndexEquals(i).text());
                }


            }

        }
    }

    public static void getBoris() throws IOException {
        Document doc = Jsoup.connect(" https://www.dailymail.co.uk/home/index.html").get();

        Elements links = doc.getElementsByTag("a");

        for (Element e : links) {
            Elements headlines = e.getElementsByAttribute("itemprop");

            for (Element d : headlines) {
                if (d.text().contains("Boris")) {
                    System.out.println(d.text());
                }


            }
        }


    }
}

