package com.mark.demo.shiro.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mark.demo.shiro.base.GenericController;
import com.mark.demo.shiro.base.PaginateResult;
import com.mark.demo.shiro.base.Pagination;
import com.mark.demo.shiro.entity.Message;
import com.mark.demo.shiro.entity.User;
import com.mark.demo.shiro.service.MessageService;

/*
*hxp(hxpwangyi@126.com)
*2017年9月18日
*
*/
@Controller
@RequestMapping("/admins/message")
public class MessageController extends GenericController {
	@Autowired
	private MessageService messageService;
	
	@RequestMapping("/list")
	public String list(){
		return "admins/message/list.ftl";
	}
	
	@RequestMapping("/list/data")
	@ResponseBody
	public PaginateResult<Message> listData(Message message,Pagination pagination,HttpServletRequest request){
		message.setReceiver(((User)SecurityUtils.getSubject().getPrincipal()).getUserName());
		return messageService.findPage(pagination, message);
	}
}
