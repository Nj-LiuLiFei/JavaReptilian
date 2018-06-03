package entity;

public class BookEntity {
    private int id;
    private String jd_id;
    private String ad_id;
    private String bookName;
    private String promoWords;
    private String bookPrice;
    private String press;
    private String dateOfPublication;
    private String author;
    private String cover;
    private String createDate;
    private String updateDate;
    private int bookSortId;
    private int bookSortDetailsId;
    private String jdHref;

    public String getPromoWords() {
        return promoWords;
    }

    public void setPromoWords(String promoWords) {
        this.promoWords = promoWords;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJd_id() {
        return jd_id;
    }

    public void setJd_id(String jd_id) {
        this.jd_id = jd_id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(String dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public int getBookSortId() {
        return bookSortId;
    }

    public void setBookSortId(int bookSortId) {
        this.bookSortId = bookSortId;
    }

    public int getBookSortDetailsId() {
        return bookSortDetailsId;
    }

    public void setBookSortDetailsId(int bookSortDetailsId) {
        this.bookSortDetailsId = bookSortDetailsId;
    }

    public String getJdHref() {
        return jdHref;
    }

    public void setJdHref(String jdHref) {
        this.jdHref = jdHref;
    }

    public String getAd_id() {
        return ad_id;
    }

    public void setAd_id(String ad_id) {
        this.ad_id = ad_id;
    }
}
