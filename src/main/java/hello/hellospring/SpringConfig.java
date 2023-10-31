package hello.hellospring;
//import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

  private final MemberRepository memberRepository;

  public SpringConfig(MemoryMemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }


  //  private final DataSource dataSource;
//  private EntityManager em;

//  @Autowired
//  public SpringConfig(EntityManager em) {
//    this.em = em;
//  }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository);
  }

//  @Bean
//  public TimeTraceAop timeTraceAop() {
//    return new TimeTraceAop();
//  }

//  @Bean
//  public MemberRepository memberRepository() {
// return new MemoryMemberRepository();
// return new JdbcMemberRepository(dataSource);
//    return new JdbcTemplateMemberRepository(dataSource);
//    return new JpaMemberRepository(em);
//  }
}