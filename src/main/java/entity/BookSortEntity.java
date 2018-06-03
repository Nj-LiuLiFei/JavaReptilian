package entity;

public class BookSortEntity {
    private int id;
    private String sortName;

    public BookSortEntity() {
    }

    public BookSortEntity(int id, String sortName) {
        this.id = id;
        this.sortName = sortName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    @Override
    public String toString() {
        return "BookSortEntity{" +
                "id=" + id +
                ", sortName='" + sortName + '\'' +
                '}';
    }
}
