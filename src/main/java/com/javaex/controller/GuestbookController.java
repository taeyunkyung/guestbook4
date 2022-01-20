package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping(value = "/view")
public class GuestbookController {
	
	@Autowired
	private GuestbookDao guestbookDao;

	@RequestMapping(value = "/addList", method = { RequestMethod.GET, RequestMethod.POST })
	public String addList(Model model) {
		System.out.println("GuestbookController>addList");

		List<GuestbookVo> guestList = guestbookDao.getList();
		model.addAttribute("guestList", guestList);

		return "addList";
	}

	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("GuestbookController>add");

		guestbookDao.insert(guestbookVo);

		return "redirect:/view/addList";
	}

	@RequestMapping(value = "/deleteForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteForm() {
		System.out.println("GuestbookController>deleteForm");

		return "deleteForm";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("GuestbookController>delete");

		guestbookDao.delete(guestbookVo);

		return "redirect:/view/addList";
	}
}
