package service;

import entity.BookEntity;
import entity.BookSortEntity;
import mapper.BookMapper;
import mapper.BookSortMapper;

public class BookService implements BookMapper {

    private BookMapper bookMapper;

    @Override
    public void insert(BookEntity bookEntity) {
        bookMapper.insert(bookEntity);
    }

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }
}
