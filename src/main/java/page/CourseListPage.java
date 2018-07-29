package page;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import entity.BookEntity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import service.BookService;
import service.CourseService;
import util.SimpleDateFormatUtil;
import util.getRequestUrl;

import java.util.ArrayList;
import java.util.List;

public class CourseListPage {
    /**
     * 开始页，从哪页开始
     */
    private static final int START = 1;
    /**
     * 结束页，到哪页结束
     */
    private  int TOTAL = 1;

    private static CourseService courseService;
    /**
     * 请求页面
     */
    public static void requestPage(String url){
        String responseBody = getRequestUrl.getRequest(url);
        analysisDom(responseBody);
    }
    /**
     * 解析Dom
     */
    public static void analysisDom(String responseBody) {

        if(responseBody == null || responseBody.isEmpty()){
            return ;
        }
        Document document = Jsoup.parse(responseBody);
        Elements liList = document.select(".course-card-list");

        for(int i=0;i<liList.size();i++){

            Elements wrap = liList.get(i).select(".j-sku-item");
            if(wrap.size()>0) {
                Element div = wrap.get(0);
            }
        }

    }

    public static CourseService getCourseService() {
        return courseService;
    }

    public static void setCourseService(CourseService courseService) {
        CourseListPage.courseService = courseService;
    }
}
