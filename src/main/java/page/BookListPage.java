package page;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import entity.BookEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import service.BookService;
import util.ResponseHandlerUtil;
import util.SimpleDateFormatUtil;
import util.getRequestUrl;


import java.awt.print.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookListPage {
    /**
     * 开始页，从哪页开始
     */
    private static final int START_PAGE = 1;
    /**
     * 结束页，到哪页结束
     */
    private static final int END_PAGE = 1;

    private static BookService bookService;
    /**
     * 请求页面
     */
    public static void requestPage(String url, int bookSortId, int bookSortDetailsId){
        for(int i=START_PAGE;i<=END_PAGE;i++) {
            String responseBody = getRequestUrl.getRequest(url+"&page="+i);
            analysisDom(responseBody,bookSortId,bookSortDetailsId);
        }
    }
    /**
     * 解析Dom
     */
    public static void analysisDom(String responseBody,int bookSortId,int bookSortDetailsId) {
        if(responseBody == null || responseBody.isEmpty()) return ;
        Document document = Jsoup.parse(responseBody);
        Elements liList = document.select(".gl-item");
        List<BookEntity> bookEntities = new ArrayList<BookEntity>();
        for(int i=0;i<liList.size();i++){
            BookEntity bookEntity = new BookEntity();
            Elements wrap = liList.get(i).select(".j-sku-item");
            if(wrap.size()>0) {
                Element div = wrap.get(0);
                String id= div.attr("data-sku");
                String bookName = div.select(".p-name em").text();
                String promoWords = div.select(".p-name .promo-words").text();
                String bookPrice = div.select(".p-price .J_price i").text();
                String press = div.select(".p-bookdetails .p-bi-store a").text();
                String dateOfPublication = div.select(".p-bookdetails .p-bi-date").text();
                String author = div.select(".p-bookdetails .p-bi-name").text();
                String cover = div.select(".p-img img").attr("src");
                String lazyImg = div.select(".p-img img").attr("data-lazy-img");
                String createDate = SimpleDateFormatUtil.getNowDate();
                String updateDate = createDate;
                String jdHref = div.select(".p-img a").attr("href");
                if(cover == "") {
                    cover = lazyImg;
                }
                bookEntity.setJd_id("J_"+id);
                bookEntity.setAd_id("AD_"+id);
                bookEntity.setBookName(bookName);
                bookEntity.setPromoWords(promoWords);
                bookEntity.setBookPrice(bookPrice);
                bookEntity.setPress(press);
                bookEntity.setDateOfPublication(dateOfPublication);
                bookEntity.setAuthor(author);
                bookEntity.setCover(cover);
                bookEntity.setCreateDate(createDate);
                bookEntity.setUpdateDate(updateDate);
                bookEntity.setJdHref(jdHref);
                bookEntity.setBookSortId(bookSortId);
                bookEntity.setBookSortDetailsId(bookSortDetailsId);
                bookEntities.add(bookEntity);
            }
        }
        setPrice(bookEntities);
        setpromoWords(bookEntities);
        insert(bookEntities);
    }
    public static void setPrice(List<BookEntity> bookEntityList){
        String p = "";
        for(int i=0;i<bookEntityList.size();i++) {
            p = p+bookEntityList.get(i).getJd_id()+",";
        }
        String responseBody = getRequestUrl.getRequest("https://p.3.cn/prices/mgets?skuIds="+p);
        JSONArray jsonArray = JSON.parseArray(responseBody);
        for (int i=0;i<jsonArray.size();i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            bookEntityList.get(i).setBookPrice(jsonObject.getString("p"));
        }

    }
    public static void setpromoWords(List<BookEntity> bookEntityList) {
        String p = "";
        for(int i=0;i<bookEntityList.size();i++) {
            p = p+bookEntityList.get(i).getAd_id()+",";
        }
        String responseBody = getRequestUrl.getRequest("https://ad.3.cn/ads/mgets?skuIds="+p);
        JSONArray jsonArray = JSON.parseArray(responseBody);
        for (int i=0;i<jsonArray.size();i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            bookEntityList.get(i).setPromoWords(jsonObject.getString("ad"));
        }
    }
    public static void insert(List<BookEntity> bookEntities){
        for(int i=0;i<bookEntities.size();i++) {
            bookService.insert(bookEntities.get(i));
        }
    }
    public static void setBookService(BookService bookService) {
        BookListPage.bookService = bookService;
    }
}
