package obj;

import item.ItemCategory;
import item.ItemCategoryNews;

import java.util.ArrayList;

public class Config {

    private Object listCategoryVnExpress;

    public Config() {
        getListCategorys();
        getListCategoryVnExpress();
    }

    public static ArrayList<ItemCategory> getListCategorys() {
        ArrayList<ItemCategory> itemCategories = new ArrayList<>();
        itemCategories.add(new ItemCategory("cgThoiSu", "Thời sự"));
        itemCategories.add(new ItemCategory("cgXaHoi", "Xã hội"));
        itemCategories.add(new ItemCategory("cgTheGioi", "Thế giới"));
        itemCategories.add(new ItemCategory("cgTheThao", "Thể thao"));
        itemCategories.add(new ItemCategory("cgGiaiTri", "Giải trí"));
        itemCategories.add(new ItemCategory("cgCameraBanDoc", "Camera bạn đọc"));
        itemCategories.add(new ItemCategory("cgVanHoa", "Văn Hóa"));
        itemCategories.add(new ItemCategory("cgDoiSong", "Đời sống"));
        itemCategories.add(new ItemCategory("cgTuoiTre", "Tuổi trẻ"));
        itemCategories.add(new ItemCategory("cgTinhYeu", "Tình yêu -Giới tính"));
        itemCategories.add(new ItemCategory("cgPhapLuat", "Pháp luật"));
        itemCategories.add(new ItemCategory("cgKinhDoanh", "Kinh doanh"));
        itemCategories.add(new ItemCategory("cgThoiTrang", "Thời trang"));
        itemCategories.add(new ItemCategory("cgViecLam", "Việc làm"));
        itemCategories.add(new ItemCategory("cgSoHoa", "Số hóa"));
        itemCategories.add(new ItemCategory("cgOtoXeMay", "Ô tô - Xe máy "));
        itemCategories.add(new ItemCategory("cgDuLich", "Du lịch"));
        itemCategories.add(new ItemCategory("cgGiaDinh", "Gia đình"));
        itemCategories.add(new ItemCategory("cgSucKhoe", "Sức khỏe"));
        itemCategories.add(new ItemCategory("cgChuyenLa", "Chuyện lạ"));
        itemCategories.add(new ItemCategory("cgGiaoDuc", "Giáo dục"));
        itemCategories.add(new ItemCategory("cgKhoaHoc", "Khoa học"));
        itemCategories.add(new ItemCategory("cgCuoi", "Cười"));
        return itemCategories;
    }

    public static ArrayList<ItemCategoryNews> getListCategoryVnExpress() {
        ArrayList<ItemCategoryNews> itemCategories = new ArrayList<>();
        itemCategories.add(new ItemCategoryNews("cgThoiSu", "http://video.vnexpress.net/xa-hoi"));
        itemCategories.add(new ItemCategoryNews("cgTheGioi", "http://video.vnexpress.net/the-gioi"));
        itemCategories.add(new ItemCategoryNews("cgTheThao", "http://video.vnexpress.net/the-thao"));
        itemCategories.add(new ItemCategoryNews("cgGiaiTri", "http://video.vnexpress.net/giai-tri"));
        itemCategories.add(new ItemCategoryNews("cgCameraBanDoc", "http://video.vnexpress.net/camera-ban-doc"));
        itemCategories.add(new ItemCategoryNews("cgPhapLuat", "http://video.vnexpress.net/phap-luat"));
        itemCategories.add(new ItemCategoryNews("cgKinhDoanh", "http://video.vnexpress.net/kinh-doanh"));
        itemCategories.add(new ItemCategoryNews("cgSoHoa", "http://video.vnexpress.net/so-hoa"));
        itemCategories.add(new ItemCategoryNews("cgOtoXeMay", "http://video.vnexpress.net/oto-xemay"));
        itemCategories.add(new ItemCategoryNews("cgDuLich", "http://video.vnexpress.net/du-lich"));
        itemCategories.add(new ItemCategoryNews("cgGiaDinh", "http://video.vnexpress.net/gia-dinh"));
        itemCategories.add(new ItemCategoryNews("cgSucKhoe", "http://video.vnexpress.net/suc-khoe"));
        itemCategories.add(new ItemCategoryNews("cgGiaoDuc", "http://video.vnexpress.net/giao-duc"));
        itemCategories.add(new ItemCategoryNews("cgKhoaHoc", "http://video.vnexpress.net/khoa-hoc"));
        itemCategories.add(new ItemCategoryNews("cgCuoi", "http://video.vnexpress.net/cuoi"));
        return itemCategories;
    }

    public static ArrayList<ItemCategoryNews> getListCategoryVietnamnet() {
        ArrayList<ItemCategoryNews> itemCategories = new ArrayList<>();
        itemCategories.add(new ItemCategoryNews("cgThoiSu",
                "http://video.vietnamnet.vn/thoi-su-c-aae/"));
        itemCategories.add(new ItemCategoryNews("cgThoiSu",
                "http://video.vietnamnet.vn/video-moi-nhat/"));
        itemCategories.add(new ItemCategoryNews("cgThoiSu",
                "http://video.vietnamnet.vn/video-hot-nhat/"));
        itemCategories.add(new ItemCategoryNews("cgTheThao",
                "http://video.vietnamnet.vn/the-thao-c-aak/"));
        itemCategories.add(new ItemCategoryNews("cgGiaiTri",
                "http://video.vietnamnet.vn/giai-tri-c-aag/"));
        itemCategories.add(new ItemCategoryNews("cgTheGioi",
                "http://video.vietnamnet.vn/the-gioi-c-aa3/"));
        itemCategories.add(new ItemCategoryNews("cgDuLich",
                "http://video.vietnamnet.vn/du-lich-c-aaj/"));
        itemCategories.add(new ItemCategoryNews("cgPhapLuat",
                "http://video.vietnamnet.vn/phap-luat-c-aai/"));
        itemCategories.add(new ItemCategoryNews("cgDoiSong",
                "http://video.vietnamnet.vn/doi-song-c-aaf/"));
        itemCategories.add(new ItemCategoryNews("cgXaHoi",
                "http://video.vietnamnet.vn/cong-dong-c-acr/"));
        return itemCategories;
    }

    public static ArrayList<ItemCategoryNews> getListCategory24h() {
        ArrayList<ItemCategoryNews> itemCategories = new ArrayList<>();
        itemCategories.add(new ItemCategoryNews("cgThoiSu",
                "http://www.24h.com.vn/video/video-tin-tuc-cvd769.html"));
        itemCategories.add(new ItemCategoryNews("cgTheThao",
                "http://www.24h.com.vn/video/video-bong-da-the-thao-cvd770.html"));
        itemCategories.add(new ItemCategoryNews("cgGiaiTri",
                "http://www.24h.com.vn/video/video-giai-tri-cvd772.html "));
        itemCategories.add(new ItemCategoryNews("cgSoHoa",
                "http://www.24h.com.vn/video/video-thoi-trang-hi-tech-cvd776.html"));
        itemCategories.add(new ItemCategoryNews("cgDuLich",
                "http://www.24h.com.vn/video/video-am-thuc-du-lich-cvd775.html"));
        itemCategories.add(new ItemCategoryNews("cgCuoi",
                " http://www.24h.com.vn/video/video-cuoi-cvd773.html"));
        itemCategories.add(new ItemCategoryNews("cgThoiTrang",
                "http://www.24h.com.vn/video/video-thoi-trang-cvd771.html"));
        itemCategories.add(new ItemCategoryNews("cgXaHoi",
                "http://www.24h.com.vn/video/video-an-ninh-xa-hoi-cvd774.html"));
        return itemCategories;
    }

    public static ArrayList<ItemCategoryNews> getListCategoryDanTri() {
        ArrayList<ItemCategoryNews> itemCategories = new ArrayList<>();
        itemCategories.add(new ItemCategoryNews("cgThoiSu",
                "http://dantri.com.vn/video-page.htm"));
        itemCategories.add(new ItemCategoryNews("cgTheGioi",
                "http://dantri.com.vn/video/the-gioi.htm"));
        itemCategories.add(new ItemCategoryNews("cgXaHoi",
                "http://dantri.com.vn/video/xa-hoi.htm"));
        itemCategories.add(new ItemCategoryNews("cgTheThao",
                "http://dantri.com.vn/video/the-thao.htm"));
        itemCategories.add(new ItemCategoryNews("cgGiaiTri",
                "http://dantri.com.vn/video/giai-tri.htm"));
        itemCategories.add(new ItemCategoryNews("cgCameraBanDoc",
                "http://dantri.com.vn/video/ban-doc.htm"));
        itemCategories.add(new ItemCategoryNews("cgPhapLuat",
                "http://dantri.com.vn/video/phap-luat.htm"));
        itemCategories.add(new ItemCategoryNews("cgKinhDoanh",
                " http://dantri.com.vn/video/kinh-doanh.htm "));
        itemCategories.add(new ItemCategoryNews("cgSoHoa",
                "http://dantri.com.vn/video/suc-manh-so.htm"));
        itemCategories.add(new ItemCategoryNews("cgOtoXeMay",
                "http://dantri.com.vn/video/o-to-xe-may.htm"));
        itemCategories.add(new ItemCategoryNews("cgDuLich",
                "http://dantri.com.vn/video/du-lich.htm"));
        itemCategories.add(new ItemCategoryNews("cgSucKhoe",
                " http://dantri.com.vn/video/suc-khoe.htm"));
        itemCategories.add(new ItemCategoryNews("cgGiaoDuc",
                "http://dantri.com.vn/video/tuyen-sinh.htm"));
        itemCategories.add(new ItemCategoryNews("cgGiaoDuc",
                "http://dantri.com.vn/video/giao-duc-khuyen-hoc.htm"));
        itemCategories.add(new ItemCategoryNews("cgGiaoDuc",
                "http://dantri.com.vn/video/du-hoc.htm"));
        itemCategories.add(new ItemCategoryNews("cgKhoaHoc",
                "http://dantri.com.vn/video/khoa-hoc-cong-nghe.htm"));
        itemCategories.add(new ItemCategoryNews("cgViecLam",
                "http://dantri.com.vn/video/viec-lam.htm"));
        itemCategories.add(new ItemCategoryNews("cgVanHoa",
                "http://dantri.com.vn/video/van-hoa.htm"));
        itemCategories.add(new ItemCategoryNews("cgTuoiTre",
                " http://dantri.com.vn/video/nhip-song-tre.htm"));
        itemCategories.add(new ItemCategoryNews("cgTinhYeu",
                "http://dantri.com.vn/video/tinh-yeu-gioi-tinh.htm"));
        itemCategories.add(new ItemCategoryNews("cgDoiSong",
                "http://dantri.com.vn/video/doi-song.htm"));
        itemCategories.add(new ItemCategoryNews("cgChuyenLa",
                "http://dantri.com.vn/video/chuyen-la.htm"));
        return itemCategories;
    }
}
