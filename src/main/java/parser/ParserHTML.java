package parser;

import item.ItemVideo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class ParserHTML implements ParserHTMLInter {
    @Override
    public Document getHTMLDocumentByUrl(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            return doc;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<ItemVideo> getAllListVideos() {
        return null;
    }

    @Override
    public ArrayList<ItemVideo> parserListVideoByUrlCategory(String link, String idCategory) {
        return null;
    }

    @Override
    public String getLinkVideoByLink(String link) {
        return null;
    }
}
