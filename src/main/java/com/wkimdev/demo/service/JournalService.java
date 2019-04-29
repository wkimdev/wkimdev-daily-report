package com.wkimdev.demo.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.wkimdev.demo.domain.Journal;
import com.wkimdev.demo.repository.JournalRepository;

@Service
public class JournalService{
	
	private static final Logger log = LoggerFactory.getLogger(JournalService.class);
	
//	@Autowired
//    JdbcTemplate jdbcTemplate;
	
	@Autowired
    JournalRepository repo;
	
	// jdbc 연결 설정
//	public void insertData() {
//        log.info("> 테이블 생성");
//        jdbcTemplate.execute("DROP TABLE JOURNAL IF EXISTS");
//        jdbcTemplate.execute("CREATE TABLE JOURNAL(id SERIAL, title VARCHAR(255), summary VARCHAR(255), created TIMESTAMP)");
//        log.info("> 데이터 생성...");
//        jdbcTemplate.execute("INSERT INTO JOURNAL(title,summary,created) VALUES('스프링 부트 입문','오늘부터 스프링 부트를 배웠다','2016-01-02 00:00:00.00')");
//        jdbcTemplate.execute("INSERT INTO JOURNAL(title,summary,created) VALUES('간단한 스프링 부트 프로젝트','스프링 부트 프로젝트를 처음 만들어 보았다','2016-01-03 00:00:00.00')");
//        jdbcTemplate.execute("INSERT INTO JOURNAL(title,summary,created) VALUES('스프링 부트 해부','스프링 부트를 자세히 살펴보았다','2016-02-02 00:00:00.00')");
//        jdbcTemplate.execute("INSERT INTO JOURNAL(title,summary,created) VALUES('스프링 부트 클라우드','클라우드 파운드리를 응용한 스프링 부트를 공부했다','2016-02-05 00:00:00.00')");
//        log.info("> 완료");
//    }
	
//	  in case of jdbc conn
//    public List<Journal> findAll() {
//        List<Journal> entries = new ArrayList<>();
//        jdbcTemplate.query("SELECT * FROM JOURNAL",
//                    new Object[]{},
//                    (rs,row) -> new Journal(rs.getLong("id"), rs.getString("title"), rs.getString("summary"),new Date(rs.getTimestamp("created").getTime())))
//                .forEach(entry -> entries.add(entry));
//        return entries;
//    }
	
    public void insertData() throws ParseException{
        log.info("> 데이터 생성...");
        repo.save(new Journal("스프링 부트 입문","오늘부터 스프링 부트를 배웠다","01/01/2016"));
        repo.save(new Journal("간단한 스프링 부트 프로젝트","스프링 부트 프로젝트를 처음 만들어 보았다","01/02/2016"));
        repo.save(new Journal("스프링 부트 해부","스프링 부트를 자세히 살펴보았다","02/01/2016"));
        repo.save(new Journal("스프링 부트 클라우드","클라우드 파운드리를 응용한 스프링 부트를 공부했다","03/01/2016"));
        log.info("> 완료");
    }

    public List<Journal> findAll() {
        return repo.findAll();
    }

}
