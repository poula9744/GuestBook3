package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestBookDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.GuestVo;


@WebServlet("/gbc")
public class GuestBookController extends HttpServlet {
	
	//필드
	private static final long serialVersionUID = 1L;
       
    
	//생성자
	//메소드-g/s
	//메소드-일반
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GuestBookController.doGet()");
		
		String action = request.getParameter("action");
		System.out.println(action);
		
		if("wform".equals(action)) {
			System.out.println("wform: 등록폼");
			
			//jsp 한테 html그리기 응답해라 --> 포워드
			WebUtil.forward(request, response, "/addList.jsp");
			
		} else if("insert".equals(action)) {
			System.out.println("insert: 등록");
			
			
			
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String content = request.getParameter("content");
			
			System.out.println(name);
			System.out.println(password);
			System.out.println(content);
			
			// vo로 묶기
			GuestVo guestVo = new GuestVo(name, password, content);
			System.out.println(guestVo.toString());
			
			//db관련 업무
			GuestBookDao guestbookDao = new GuestBookDao();
			
			//db에 저장
			guestbookDao.guestInsert(guestVo);
			
			//리다이렉트: 엔터효과를 낸다
			//WebUtil.redirect(request, response, "guestbook3/gbc?action=list");
		
			
		} else if("list".equals(action)) {
			System.out.println("list: 리스트");
			
			//db사용
			GuestBookDao guestBookDao = new GuestBookDao();
			
			//리스트 가져오기
			List<GuestVo> guestList = guestBookDao.guestSelect();
			System.out.println(guestList);
			
			//데이터 담기 --> 포워드
			request.setAttribute("guestList", guestList);
			
			WebUtil.forward(request, response, "guestbook3");
			
			
		} else if("delete".equals(action)) {
			System.out.println("delete: 삭제");
			int no = Integer.parseInt(request.getParameter("no"));
			System.out.println(no);
			
			//db사용
			GuestBookDao guestBookDao = new GuestBookDao();
			
			//삭제
			guestBookDao.guestDelete(no);
			
			//리다이렉트
			response.sendRedirect("/phonebook3/pbc?action=list");
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
