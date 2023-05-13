package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryMemberRepository implements MemberRepository {

    // 실무에서는 동시성 문제 때문에 ConcurrentHashMap을 사용하지만 간단하니까 그냥 넘어가)
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // 다양한 방법이 있다, 이것 또한 동시성 문제 떄문

    // Q) 동시성 문제
    // 하나의 데이터에 2 이상의 스레드, 혹은 세션에서 가변 데이터를 동시에 제어할 때 나타나는 문재


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
//        return store.get(id); // null이 반환될 가능성이 있기 때문에, optional로!!
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name))
                .findAny(); // 끝까지 찾았는데 없으면 Optional을 쓴다..
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public  void clearStore() {
        store.clear();

    }
}
