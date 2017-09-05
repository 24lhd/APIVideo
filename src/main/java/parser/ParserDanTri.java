package parser;

import item.ItemCategoryNews;
import item.ItemVideo;
import obj.Config;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ParserDanTri extends ParserHTML {


    public ArrayList<ItemVideo> getListVideos() {
        ArrayList<ItemVideo> videos = new ArrayList<>();
        for (ItemCategoryNews itemCategoryNews : Config.getListCategoryDanTri()) {
            videos.addAll(
                    parserVideoByUrl(itemCategoryNews.getLink(), itemCategoryNews.getIdCategory())
            );
        }
        System.out.println("Lấy được số video DanTri: " + videos.size());
//        for (ItemVideo itemVideo :videos) {
//            System.out.println(itemVideo.toString());
//        }
        return videos;
    }

    public ArrayList<ItemVideo> parserVideoByUrl(String link, String idCategory) {

        ArrayList<ItemVideo> videos = new ArrayList<>();
        Document documentGetHTML = getHTMLDocumentByUrl(link);
        try {
            String linkGetXML = documentGetHTML.select("#video-embeb").first()
                    .select("iframe").attr("data-original")
                    .split("listsuggest=")[1].split("&")[0];
            Document documentGetXML = getHTMLDocumentByUrl(linkGetXML);
            for (int i = 0; i < documentGetXML.select("video").size(); i++) {
                String linkContent = documentGetXML.select("video").get(i).attr("link");

                String linkImage = documentGetXML.select("video").get(i).attr("thumb");
                String linkTitle = documentGetXML.select("video").get(i).attr("name");
                String linkVideo = getLinkMp4DanTriFromURL(linkContent);
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
                videos.add(new ItemVideo(idCategory, linkContent, linkTitle, linkImage, linkVideo, "...",
                        new obj.Date(System.currentTimeMillis(), phut, gio, ngay, thang, nam)));
            }

        } catch (Exception e) {

        }

        return videos;
    }

    public String getLinkMp4DanTriFromURL(String link) {
        Document documentGetHTML = getHTMLDocumentByUrl(link);
        String linkMp4 = documentGetHTML.select("#video-embeb").first()
                .select("iframe").attr("data-original")
                .split("&_listsuggest=")[0].split("&vid=")[1];
        return "http://hls.mediacdn.vn/" + linkMp4;
    }

}//http://hls.mediacdn.vn/dantri/85b8ad95ea/2017/08/03/op-lung-iphone-chua-dung-dich-la-gay-bong-4-1501748414395.mp4
