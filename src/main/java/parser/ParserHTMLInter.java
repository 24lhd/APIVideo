package parser;

import item.ItemVideo;
import org.jsoup.nodes.Document;

import java.util.ArrayList;

public interface ParserHTMLInter {
    public Document getHTMLDocumentByUrl(String url);

    public ArrayList<ItemVideo> getAllListVideos();

    public ArrayList<ItemVideo> parserListVideoByUrlCategory(String link, String idCategory);

    public String getLinkVideoByLink(String link);

}
