package com.hello.Hellospring;

import com.hello.Hellospring.aop.TimeTraceAop;
import com.hello.Hellospring.domain.Member;
import com.hello.Hellospring.repository.JdbcMemberRepository;
import com.hello.Hellospring.repository.JdbcTemplateMemberRepository;
import com.hello.Hellospring.repository.JpaMemberRepository;
import com.hello.Hellospring.repository.MemberRepository;
import com.hello.Hellospring.repository.MemoryMemberRepository;
import com.hello.Hellospring.repository.SpringDataJpaMemberRepository;
import com.hello.Hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

@Configuration
public class SpringConfig { // 직접 스프링 빈 등록하기

    private final MemberRepository memberRepository;
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public TimeTraceAop TimeTraceAop(){
//        return new TimeTraceAop();
//    }

//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }


}
