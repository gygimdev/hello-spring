package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    /** jdbc 사용예제
     * private DataSource dataSource;

     * @Autowired
     * public SpringConfig(DataSource dataSource){
     * this.dataSource = dataSource;
     * }
     * */

    /** JPA 사용 예제
     * private EntityManager em;

     * @Autowired
     * public SpringConfig(EntityManager em){
     * this.em = em;
     * }
     * */

    //
    // 스프링 JPA(Spring JPA) 사용
    //
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
