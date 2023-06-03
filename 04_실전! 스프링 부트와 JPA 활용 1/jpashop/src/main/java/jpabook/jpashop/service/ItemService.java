package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    // 저장
    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    // 모두찾기
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    // 하나 찾기
    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }



}
