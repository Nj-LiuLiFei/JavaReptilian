import entity.BookSortDetailsEntity;
import entity.BookSortEntity;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import page.BookListPage;
import service.BookService;
import service.BookSortDetailsService;
import service.BookSortService;
import util.ResponseHandlerUtil;
import util.getRequestUrl;

import java.awt.print.Book;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunMain {
    public static final Pattern  PATTERN_COMPILE = Pattern.compile("(\\d+)-(\\d+)-(\\d+)");
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        BookSortService bookSortService = (BookSortService) context.getBean("bookSortService");
        BookSortDetailsService bookSortDetailsService = (BookSortDetailsService) context.getBean("bookSortDetailsService");
        BookService bookService = (BookService) context.getBean("bookService");
        BookListPage.setBookService(bookService);
        Pattern pattern = PATTERN_COMPILE;
        System.out.println("爬虫中.....");

        String responseBody = getRequestUrl.getRequest("https://book.jd.com/booksort.html");
        Document doc = Jsoup.parse(responseBody);
        Elements element = doc.select("#booksort>div.mc>dl");
        Element element1  = element.get(0);
        element = element1.children();
        int len = element.size();
        BookSortEntity bookSortEntity = null;
        for (int i=0 ;i<len;i++) {
            element1 = element.get(i);
            if((i+1)%2 == 1) {
                if(!element1.text().isEmpty()){
                    bookSortEntity = new BookSortEntity();
                    bookSortEntity.setSortName(element1.text());
                    bookSortService.insert(bookSortEntity);
                }
            }else {
                if(bookSortEntity!=null) {
                    BookSortDetailsEntity bookSortDetailsEntity = null;
                    Elements elements = element1.children();
                    for(int j=0;j<elements.size();j++) {
                        if(!elements.get(j).text().isEmpty()) {
                            bookSortDetailsEntity = new BookSortDetailsEntity();
                            bookSortDetailsEntity.setBookSortId(bookSortEntity.getId());
                            bookSortDetailsEntity.setBookSortDetailName(elements.get(j).text());
                            bookSortDetailsService.insert(bookSortDetailsEntity);
                            Elements elements1 = elements.get(j).select("a");
                            String url = elements1.attr("href");
                            Matcher matcher = pattern.matcher(url);
                            if (matcher.find( )) {
                                String[] str=matcher.group().split("-");
                                if(str.length == 3 ) {
                                    BookListPage.requestPage("https://list.jd.com/list.html?cat="+str[0]+","+str[1]+","+str[2]+"",
                                            bookSortDetailsEntity.getBookSortId(),bookSortDetailsEntity.getId());
                                }
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
