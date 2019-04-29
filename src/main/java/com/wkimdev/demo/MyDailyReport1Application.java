package com.wkimdev.demo;

import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.wkimdev.demo.domain.Journal;
import com.wkimdev.demo.repository.JournalRepository;
import com.wkimdev.demo.service.JournalService;


@SpringBootApplication
public class MyDailyReport1Application implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(MyDailyReport1Application.class);
	
	@Autowired
    JournalService service;
	
//	 @Bean
//	    InitializingBean saveData(JournalRepository repo) {
//	        return () -> {
//	            repo.save(new Journal("스프링 부트 입문","오늘부터 스프링 부트 공부하기 시작했다","01/01/2016"));
//	            repo.save(new Journal("간단한 스프링 부트 프로젝트","스프링 부트 프로젝트를 처음 만들어 보았다","01/02/2016"));
//	            repo.save(new Journal("스프링 부트 해부","스프링 부트를 자세히 살펴보았다","02/01/2016"));
//	            repo.save(new Journal("스프링 부트 클라우드","클라우드 파운드리를 응용한 스프링 부트를 공부했다","03/01/2016"));
//	        };
//	    }

//	    @Bean
//	    CommandLineRunner init(JournalRepository repo) {
//	        return args -> {
//	            System.out.println("---------------------------------");
//	            repo.findAll().forEach(System.out::println);
//	            System.out.println("---------------------------------");
//	        };
//	    }

	public static void main(String[] args) {
//		SpringApplication.run(MyDailyReport1Application.class, args);
		
		//버전 2.
        SpringApplication app = new SpringApplication(MyDailyReport1Application.class);
        app.setBanner(new Banner() {
			@Override
			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
				out.print("\n\n\t위킴의 멋진 배너!\n\n".toUpperCase());
			}
        });
        app.run(args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		log.info("@@ 데이터 생성....");
        service.insertData();
        log.info("@@ findAll() 호출...");
        service.findAll().forEach(entry -> log.info(entry.toString()));
	}

}
