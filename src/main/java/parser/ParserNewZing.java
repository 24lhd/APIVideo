package parser;

import item.ItemCategoryNews;
import item.ItemVideo;
import obj.Config;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;

public class ParserNewZing extends ParserHTML {
    public ArrayList<ItemVideo> getListVideos() {
        ArrayList<ItemVideo> videos = new ArrayList<>();
        for (ItemCategoryNews itemCategoryNews : Config.getListCategoryNewZing()) {
            videos.addAll(
                    parserListVideoByUrlCategory(itemCategoryNews.getLink(), itemCategoryNews.getIdCategory())
            );
//            System.out.println("Lấy được số video : " + itemCategoryNews.toString());
        }
        System.out.println("Lấy được số video ParserNewZing: " + videos.size());
        return videos;
    }

    @Override
    public ArrayList<ItemVideo> parserListVideoByUrlCategory(String link, String idCategory) {
        Document document = getHTMLDocumentByUrl(link);
        int sizeVideo = document.select(".article-item").size();
//        System.out.println("Lấy được số video : " + sizeVideo);
//        System.out.println(getLinkVideoByLink(idVideo));
        ArrayList<ItemVideo> videos = new ArrayList<>();
        for (int i = 0; i < sizeVideo; i++) {
            Element element = document.select(".article-item").get(i);
            String idVideo = "http://news.zing.vn" + element.select("header").select("a").first().attr("href");
            String title = element.select("header").select("a").first().attr("title");
            String image = element.select("p").select("a").select("img").first().attr("src");
            String linkVideo = getLinkVideoByLink(idVideo);

            String timeVideo = "...";
            ItemVideo itemVideo = new ItemVideo(idCategory, idVideo, title, image, linkVideo, timeVideo, new obj.Date());
//              System.out.println(itemVideo);
            videos.add(itemVideo);
        }

        return videos;
    }

    @Override
    public String getLinkVideoByLink(String link) {
        Document documentGetHTML = getHTMLDocumentByUrl(link);
        try {
            return documentGetHTML.select("video").first().attr("src");
        } catch (Exception e) {
            return "";
        }

    }
}
