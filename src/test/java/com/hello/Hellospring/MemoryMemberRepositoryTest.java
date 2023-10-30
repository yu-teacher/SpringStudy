package com.hello.Hellospring;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.hello.Hellospring.domain.Member;
import com.hello.Hellospring.repository.MemoryMemberRepository;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @AfterEach  // 줜나 중요함
    public void afterEach(){
        memoryMemberRepository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("승미니");

        memoryMemberRepository.save(member);

        Member result = memoryMemberRepository.findById(member.getId()).get();
//        Assertions.assertEquals(result, member);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("승미니1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("승미니2");
        memoryMemberRepository.save(member2);

        Member result = memoryMemberRepository.findByName("승미니1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("승미니1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("승미니2");
        memoryMemberRepository.save(member2);

        List<Member> result = memoryMemberRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
