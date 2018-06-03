package service;

import entity.BookSortDetailsEntity;
import mapper.BookSortDetailsMapper;

public class BookSortDetailsService implements BookSortDetailsMapper {

    private BookSortDetailsMapper bookSortDetailsMapper;

    @Override
    public void insert(BookSortDetailsEntity bookSortDetailsEntity) {
        bookSortDetailsMapper.insert(bookSortDetailsEntity);
    }

    public void setBookSortDetailsMapper(BookSortDetailsMapper bookSortDetailsMapper) {
        this.bookSortDetailsMapper = bookSortDetailsMapper;
    }
}
