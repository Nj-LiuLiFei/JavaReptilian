package service;

import entity.BookSortEntity;
import mapper.BookSortMapper;
import org.mybatis.spring.mapper.MapperFactoryBean;

public class BookSortService implements BookSortMapper {

    private BookSortMapper bookSortMapper;


    @Override
    public void insert(BookSortEntity bookSort) {
        bookSortMapper.insert(bookSort);
    }

    public void setBookSortMapper(BookSortMapper bookSortMapper) {
        this.bookSortMapper = bookSortMapper;
    }
}
