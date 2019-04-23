package com.wkimdev.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.wkimdev.demo.domain.Journal;
import com.wkimdev.demo.repository.JournalRepository;


@SpringBootApplication
public class MyDailyReport1Application {
	
	 @Bean
	    InitializingBean saveData(JournalRepository repo) {
	        return () -> {
	            repo.save(new Journal("스프링 부트 입문","오늘부터 스프링 부트 공부하기 시작했다","01/01/2016"));
	            repo.save(new Journal("간단한 스프링 부트 프로젝트","스프링 부트 프로젝트를 처음 만들어 보았다","01/02/2016"));
	            repo.save(new Journal("스프링 부트 해부","스프링 부트를 자세히 살펴보았다","02/01/2016"));
	            repo.save(new Journal("스프링 부트 클라우드","클라우드 파운드리를 응용한 스프링 부트를 공부했다","03/01/2016"));
	        };
	    }

	    @Bean
	    CommandLineRunner init(JournalRepository repo) {
	        return args -> {
	            System.out.println("---------------------------------");
	            repo.findAll().forEach(System.out::println);
	            System.out.println("---------------------------------");
	        };
	    }

	public static void main(String[] args) {
		SpringApplication.run(MyDailyReport1Application.class, args);
	}

}
