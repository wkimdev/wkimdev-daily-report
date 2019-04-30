package com.wkimdev.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wkimdev.demo.domain.Journal;

public interface JournalRepository2 extends JpaRepository<Journal, Long> {

}
