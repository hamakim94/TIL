package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class ItemUpdateTest {

    @Autowired
    EntityManager em;

    @Test
    void updateTest() throws Exception {
        //given
        Book book = em.find(Book.class, 1L);
        //TX
        book.setName("asdasd");

        // 변경 감지 - dirty checking -> 이렇게 하면 알아서 JPA가 update Query를 날려준다


        // TX commit

    }

}