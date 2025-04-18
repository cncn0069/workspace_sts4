package com.rubypaper;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoggingRunner implements ApplicationRunner {

//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		// TODO Auto-generated method stub
//		
//		log.trace("TRACE 로그 메시지");
//		log.debug("TRACE 로그 메시지");
//		log.info("INFO 로그 메시지");
//		log.warn("WARN 로그 메시지");
//		log.error("ERROR 로그 메시지");
//		
//	}


	private Logger logger=LoggerFactory.getLogger(LoggingRunner.class);

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		logger.trace("TRACE 로그메시지");
		logger.debug("DEBUG 로그메시지");
		logger.info("INFO 로그메시지");
		logger.warn("WARN 로그메시지");
		logger.error("ERROR 로그메시지");
	}
}
