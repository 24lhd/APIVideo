package parser;

import item.ItemCategoryNews;
import item.ItemVideo;
import obj.Config;
import org.jsoup.nodes.Document;

import java.util.ArrayList;

public class ParserVietnamnet extends ParserHTML {


    public ArrayList<ItemVideo> getListVideos() {

        ArrayList<ItemVideo> videos = new ArrayList<>();
        for (ItemCategoryNews itemCategoryNews : Config.getListCategoryVietnamnet()) {
            videos.addAll(
                    parserListVideoByUrlCategory(itemCategoryNews.getLink(), itemCategoryNews.getIdCategory())
            );
//            System.out.println("Lấy được số video : " + itemCategoryNews.toString());
        }
        System.out.println("Lấy được số video Vietnamnet: " + videos.size());
        return videos;
    }

    @Override
    public ArrayList<ItemVideo> parserListVideoByUrlCategory(String link, String idCategory) {
        Document document = getHTMLDocumentByUrl(link);
        int sizeVideo = document.select(".vnn-home-item").size();
        ArrayList<ItemVideo> videos = new ArrayList<>();
        for (int i = 0; i < sizeVideo; i++) {

            String idVideo = "http://video.vietnamnet.vn" + document.select(".vnn-home-item").get(i).select("a").attr("href");
            String title = document.select(".vnn-home-item").get(i).select(".content-title").select("a").attr("title");
            String image = document.select(".vnn-home-item").get(i).select("img").attr("src").split("width")[0];
            String linkVideo = getLinkVideoByLink(idVideo);
            String timeVideo = "...";
            ItemVideo itemVideo = new ItemVideo(idCategory, idVideo, title, image, linkVideo, timeVideo, new obj.Date());
            //  System.out.println(itemVideo);
            videos.add(itemVideo);
        }

        return videos;
    }

    @Override
    public String getLinkVideoByLink(String link) {
        Document documentGetHTML = getHTMLDocumentByUrl(link);
        try {
            return "http" + documentGetHTML.select("#videoDetail").html().split("'http")[1].split("';")[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }

    }
}
