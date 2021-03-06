package com.teamJ3.homepage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.teamJ3.homepage.dto.Notice;
import com.teamJ3.homepage.service.NoticeService;

@Controller
public class NoticeController {
	
	private static final Logger log = LoggerFactory
			.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService service;
	
	@RequestMapping(value = "/board-notice", method = RequestMethod.GET)
	public ModelAndView boardNotice(HttpServletRequest request) {
		log.info("board-notice 페이지 로딩중...");
		
		List<Notice> list = service.selectNoticeList();
		ModelAndView mav = new ModelAndView();
		mav = new ModelAndView();
		mav.setViewName("board-notice");
		mav.addObject("list",list);
		return mav;
	}
	
		
	@RequestMapping(value = "/board-write", method = RequestMethod.GET)
	public ModelAndView boardWrite(HttpServletRequest request, ModelAndView mav) {
		log.info("board-write 페이지 로딩중...");
		mav = new ModelAndView();
		mav.setViewName("board-write");
		mav.addObject("Notice", new Notice());
		return mav;
	}
	
	
	@RequestMapping(value = "/board-info", method = RequestMethod.GET)
	public ModelAndView boardInfo(HttpServletRequest request, ModelAndView mav) {
		log.info("board-info 페이지 로딩중...");
		mav = new ModelAndView();
		mav.setViewName("board-info");
		return mav;
	}
	
	
	@RequestMapping(value = "/board-estimate", method = RequestMethod.GET)
	public ModelAndView boardEstimate(HttpServletRequest request, ModelAndView mav) {
		log.info("board-estimate 페이지 로딩중...");
		mav = new ModelAndView();
		mav.setViewName("board-estimate");
		return mav;
	}
	
	
	@RequestMapping(value = "/board-submit", method = RequestMethod.POST)
	public String boardSubmit(Notice notice, ModelAndView mav) {
		log.info("board-Submit 로딩중...");
		System.out.println(notice.getNotice_contents());
		notice.setNotice_writer("admin");
		service.insertNotice(notice);
		return "redirect:/board-notice";
	}
	
	
}
