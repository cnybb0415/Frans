package com.frans.main.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.frans.main.service.MessageService;
import com.frans.main.service.NotiService;
import com.frans.stock.dto.StockDTO;

@Controller
public class MessageController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired MessageService msgsevice;
	
	@GetMapping(value="/msgList.go")
	public ModelAndView msgListGo(HttpServletRequest req){
		HttpSession session = req.getSession();
		String loginId = (String) session.getAttribute("loginId");
		logger.info("결재 문서 작성 이동 컨트롤러");
		logger.info("로그인 아이디: "+loginId);
		
		
		return msgsevice.msgListGo(loginId);
	}
	
	@PostMapping(value="/msg/write.do")
	public String msgWriteDo(@RequestParam HashMap<String, String> params, HttpServletRequest req) {
		HttpSession session = req.getSession();
		String loginId = (String) session.getAttribute("loginId");
		logger.info("쪽지 작성 컨트롤러");
		logger.info("params: {}",params);
		
		msgsevice.msgWriteDo(params,loginId,req);
		String page = "redirect:/msgList.go";
		return page;
	}
	
	//메인화면 메신저 리스트
	@ResponseBody
	@GetMapping(value="/msg/msgList.ajax")
	public HashMap<String, Object> msgList(HttpServletRequest req){
		HttpSession session = req.getSession();
		String loginId = (String) session.getAttribute("loginId");
		logger.info("메신저 리스트 컨트롤러");
		logger.info("로그인 아이디: "+loginId);
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<StockDTO> msgList = msgsevice.msgList(loginId);
		map.put("msgList", msgList);
		
		return map;
	}
	
	
	

}
