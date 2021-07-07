package com.Sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.Sportyshoes.dao.UserinfoDAO;
import com.Sportyshoes.jdbc.entity.Userinfo;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.Sportyshoes.jdbc.entity.loginuser;
import com.Sportyshoes.dao.EProductDAO;
import com.Sportyshoes.jdbc.entity.EProduct;
import com.Sportyshoes.dao.CategoryDAO;
import com.Sportyshoes.jdbc.entity.Category;
import com.Sportyshoes.service.Loginservice;
@Controller
public class MainController {
	
	
	@Autowired
	Loginservice service;
	 @RequestMapping(value = "login", method=RequestMethod.GET)
	public String login(Model map) {
                return "login";
	}
	
		@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String hello(@RequestParam String name, @RequestParam String password,Model mod){
          boolean validuser=service.validateuser(name,password);
	if(!validuser) {
		mod.addAttribute("error","invalid");
		return"login";
	}
	mod.addAttribute("name",name);
		mod.addAttribute("password",password);	
		return"hello";
		}
		
		

	@Autowired
	EProductDAO eproductDAO;
	@RequestMapping(value = "/listproducts", method = RequestMethod.GET)
	public String listProducts(Model map) {
		List<EProduct> list = eproductDAO.getProducts();
		map.addAttribute("list", list);
		return "listproducts";
	}

	@Autowired
	UserinfoDAO userinfoDAO;

	@RequestMapping(value = "/listinfo", method = RequestMethod.GET)
	public String info(Model m) {
		List<Userinfo> info = userinfoDAO.getProducts();
		m.addAttribute("info", info);
		return "listinfo";
	}
	
	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping(value = "/purchaseDetails", method = RequestMethod.GET)
	public String category(Model map) {
		List<Category> purchaseDetails= categoryDAO.getDetails();
		map.addAttribute("purchaseDetails", purchaseDetails);
		return "purchaseDetails";
	}
}

