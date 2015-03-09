package ene.redl.spring.mvc.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ene.redl.spring.hiberante.mapping.AddressCensus;
import ene.redl.spring.hiberante.mapping.CookieInfo;
import ene.redl.spring.service.AddressCensusService;
import ene.redl.spring.service.CookieService;

@Controller
public class AjaxController {
	
	@Resource
	private CookieService cookieService;
	
	@Resource
	private AddressCensusService addressCensusService;

	@RequestMapping(value="/cookieList", method = RequestMethod.GET)
	@ResponseBody
	public void getCookieList(PrintWriter print){
		
		List<CookieInfo> list = cookieService.getUserDataList();
		
		System.out.println(list.size());
		String str = JSONArray.fromObject(list).toString();
		print.print(str);
		print.close();
	}
	
	@RequestMapping(value="/cookie/{id}", method = RequestMethod.GET)
	public String getCookie(@PathVariable("id") String id, Model model){
		List<CookieInfo> list = cookieService.getUserData(id);
		model.addAttribute("message", JSONArray.fromObject(list).toString());
		//model.addAttribute("message", list);
		return "cookie";
	}
	
	@RequestMapping(value="/cookie/cookie-url-date")
	public String getCookie(@RequestParam("currentUrl") String currentUrl, 
			@RequestParam("dateSeq") String dateSeq, Model model){
		System.out.println(currentUrl);
		System.out.println(dateSeq);
		List<CookieInfo> list = cookieService.getUserData(currentUrl, dateSeq);
		model.addAttribute("message", JSONArray.fromObject(list).toString());
		return "cookie";
	}
	
	@RequestMapping(value="/census")
	public String census(Model model){
		model.addAttribute("message", "null");  
		return "census";
	}
	
	@RequestMapping(value="/census/list")
	public void getCensus(PrintWriter print){
		List<AddressCensus> list = addressCensusService.getAddressCensusList();
		print.print(JSONArray.fromObject(list).toString());
		print.close();
	}
	
	@RequestMapping(value="/census/city")
	public String getCensus(@RequestParam("city") String city, 
			Model model){
		List<AddressCensus> list = addressCensusService.getAddressCensusList(city);
		model.addAttribute("message", JSONArray.fromObject(list).toString());
		return "census";   
	}
	
}
