package entity;

public class BookSortDetailsEntity {
    private int id;
    private int bookSortId;
    private String bookSortDetailName;

    public BookSortDetailsEntity() {
    }

    public BookSortDetailsEntity(int id, int bookSortId, String bookSortDetailName) {
        this.id = id;
        this.bookSortId = bookSortId;
        this.bookSortDetailName = bookSortDetailName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookSortId() {
        return bookSortId;
    }

    public void setBookSortId(int bookSortId) {
        this.bookSortId = bookSortId;
    }

    public String getBookSortDetailName() {
        return bookSortDetailName;
    }

    public void setBookSortDetailName(String bookSortDetailName) {
        this.bookSortDetailName = bookSortDetailName;
    }

    @Override
    public String toString() {
        return "BookSortDetailsEntity{" +
                "id=" + id +
                ", bookSortId=" + bookSortId +
                ", bookSortDetailName='" + bookSortDetailName + '\'' +
                '}';
    }
}
