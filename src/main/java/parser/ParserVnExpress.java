package parser;

import item.ItemCategoryNews;
import item.ItemVideo;
import obj.Config;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ParserVnExpress {
    private Object listVideos;

    public ParserVnExpress() {


    }

    public ArrayList<ItemVideo> getListVideos() {
        ArrayList<ItemVideo> videos = new ArrayList<>();
        for (ItemCategoryNews itemCategoryNews : Config.getListCategoryVnExpress()) {
            videos.addAll(parserVideoByUrl(itemCategoryNews.getLink(), itemCategoryNews.getIdCategory()));
        }
        System.out.println("Lấy được số video VnExpress: " + videos.size());
        return videos;
    }

    private ArrayList<ItemVideo> parserVideoByUrl(String link, String idCategory) {
        ArrayList<ItemVideo> videos = new ArrayList<>();
        ParserHTML parserHTML = new ParserHTML();
        Document document = parserHTML.getHTMLDocumentByUrl(link);
        for (int i = 0; i < document.select(".item_video").size(); i++) {

            String jsonData = document.select(".item_video").get(i).attr("data-extend");
            try {
                String s720 = jsonData.split("s720\":\"")[1].split("\",\"")[0];
                String s480 = jsonData.split("s480\":\"")[1].split("\",\"")[0];
                String s360 = jsonData.split("s360\":\"")[1].split("\",\"")[0];
                String s240 = jsonData.split("s240\":\"")[1].split("\",\"")[0];
                String linkVideoPlay = s720;
                if (linkVideoPlay.isEmpty()) {
                    linkVideoPlay = s480;
                }
                if (linkVideoPlay.isEmpty()) {
                    linkVideoPlay = s360;
                }
                if (linkVideoPlay.isEmpty()) {
                    linkVideoPlay = s240;
                }
                Date date = new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int hour = cal.get(Calendar.HOUR);
                int minute = cal.get(Calendar.MINUTE);
                String phut = "" + minute,
                        gio = "" + hour,
                        ngay = "" + day,
                        thang = "" + (month + 1),
                        nam = "" + (year);
                String image = document.select(".item_video").get(i).select(".thumb_video").first().select("a").first().select("img").attr("src"),
                        idVideo = document.select(".item_video").get(i).select(".thumb_video").first().select("a").first().attr("href"),
                        title = document.select(".item_video").get(i).select(".thumb_video").first().select("a").first().attr("title"),
                        linkVideo = document.select(".item_video").get(i).select(".thumb_video").first().select("a").first().attr("href"),
                        timeVideo = document.select(".item_video").get(i).select(".thumb_video").first().select("a").first().select("span").text().split(" ")[0];
                ItemVideo itemVideo = new ItemVideo(idCategory, idVideo, title, image, linkVideoPlay, timeVideo, new obj.Date(System.currentTimeMillis(), phut, gio, ngay, thang, nam));
//                   System.out.println(i+" "+itemVideo.toString());
                videos.add(itemVideo);
//                   System.out.println(videos.size());
            } catch (ArrayIndexOutOfBoundsException e) {
//                System.out.println(e.getMessage());
//                System.out.println(jsonData);
            }
        }
        return videos;
    }
}
