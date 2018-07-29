import entity.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import page.BookListPage;
import page.CourseListPage;
import service.*;
import util.getRequestUrl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("ALL")
public class RunMain2 {
    public static final Pattern  PATTERN_COMPILE = Pattern.compile("(\\d+)-(\\d+)-(\\d+)");
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        CategoryOneService categoryOneService = (CategoryOneService) context.getBean("categoryOneService");
        CategoryTwoService categoryTwoService = (CategoryTwoService) context.getBean("categoryTwoService");
        CategoryThreeService categoryThreeService = (CategoryThreeService) context.getBean("categoryThreeService");
        CourseService courseService = (CourseService) context.getBean("courseService");
        CourseListPage.setCourseService(courseService);
        Pattern pattern = PATTERN_COMPILE;
        System.out.println("爬虫中.....");

        String responseBody = getRequestUrl.getRequest("https://ke.qq.com/course/list?");
        Document doc = Jsoup.parse(responseBody);
        Elements element = doc.select("#auto-test-1 a");
        Element element1;

        int len = element.size();
        CategoryOneEntity  categoryOneEntity;
        CategoryTwoEntity categoryTwoEntity;
        CategoryThreeEntity categoryThreeEntity;
        for (int i=0 ;i<len;i++) {
            element1 = element.get(i);
            if(element1.attr("href").indexOf("mt=") > -1){
                categoryOneEntity = new CategoryOneEntity();
                categoryOneEntity.setCategory_name(element1.text());
                categoryOneService.insert(categoryOneEntity);
                responseBody = getRequestUrl.getRequest("https://ke.qq.com"+element1.attr("href"));
                Document doc2 = Jsoup.parse(responseBody);
                Elements element2 = doc2.select("#auto-test-1 a");
                int len2 = element2.size();
                for (int j=0;j<len2;j++) {
                    element1 = element2.get(j);

                    if(element1.attr("href").indexOf("st=") > -1){
                        categoryTwoEntity = new CategoryTwoEntity();
                        categoryTwoEntity.setCategory_name(element1.text());
                        categoryTwoEntity.setCo_id(categoryOneEntity.getId());
                        categoryTwoService.insert(categoryTwoEntity);
                        responseBody = getRequestUrl.getRequest("https://ke.qq.com"+element1.attr("href"));
                        Document doc3 = Jsoup.parse(responseBody);
                        Elements element3 = doc3.select("#auto-test-1 a");
                        int len3 = element3.size();
                        for (int k=0;k<len3;k++) {
                            element1 = element3.get(k);
                            if(element1.attr("href").indexOf("tt=") > -1){
                                categoryThreeEntity = new CategoryThreeEntity();
                                categoryThreeEntity.setCategory_name(element1.text());
                                categoryThreeEntity.setCo_id(categoryTwoEntity.getCo_id());
                                categoryThreeEntity.setCt_id(categoryTwoEntity.getId());
                                categoryThreeService.insert(categoryThreeEntity);
                                CourseListPage.requestPage(element1.attr("href"));
                            }
                        }
                    }
                }
            }

        }
        System.out.println("----------------------------------------");
        System.out.println("爬虫完成");

    }
}
