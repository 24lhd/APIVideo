package parser;

import item.ItemCategoryNews;
import item.ItemVideo;
import obj.Config;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Parser24h extends ParserHTML {

    public ArrayList<ItemVideo> getListVideos() {
        ArrayList<ItemVideo> videos = new ArrayList<>();
        for (ItemCategoryNews itemCategoryNews : Config.getListCategory24h()) {
            videos.addAll(
                    parserVideoByUrl(itemCategoryNews.getLink(), itemCategoryNews.getIdCategory())
            );
        }
        System.out.println("Lấy được số video 24h: " + videos.size());
        return videos;
    }

    private ArrayList<ItemVideo> parserVideoByUrl(String link, String idCategory) {
        ArrayList<ItemVideo> videos = new ArrayList<>();
        Document document = getHTMLDocumentByUrl(link);
        try {

            for (int i = 0; i < document.select(".item-video-play").size(); i++) {
                String linkContent = document.select(".item-video-play").get(i).select(".main-video-img").first().select("a").attr("href");
                String title = document.select(".item-video-play").get(i).select(".main-video-img").first().select("a").attr("title");
                String linkImage = document.select(".item-video-play").get(i).select(".main-video-img").first().select("a").first().select("img").attr("src");
                String timeVideo =
                        document.select(".item-video-play").get(i).select(".main-video-img").first().select(".leng-video").select(".time-leng-1").text();
                String linkVideo = getLinkVideo24h(linkContent);
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
                videos.add(new ItemVideo(idCategory, linkContent, title, linkImage, linkVideo, timeVideo, new obj.Date(System.currentTimeMillis(), phut, gio, ngay, thang, nam)));
            }

        } catch (Exception e) {

        }

        return videos;
    }

    private String getLinkVideo24h(String link) {
        Document document = getHTMLDocumentByUrl(link);
        return document.select(".zplayerDiv").attr("data-config").split("&file=")[1].split("&fileAlt")[0].split(".mp4")[0] + ".mp4";
    }

}
