package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/hello")
	public String index() {
		return "aloha";
	}

//	@RequestMapping("/hello2")
//	public String hello2(@RequestParam(value= "name") String name, Model model) 
//	{
//		model.addAttribute("name", name);
//		return "hello2";
//	}
	
//	@RequestMapping("/hello2")
//	public String hello2(@RequestParam(value= "name", required = false) String name, Model model) 
//	{
//		model.addAttribute("name", name);
//		return "hello2";
//	}
	@RequestMapping("/hello2")
	public String hello2(@RequestParam(value= "name", required = false, defaultValue= "Thanos") String name, Model model) 
	{
		model.addAttribute("name", name);
		return "hello2";
	}
	
//	@RequestMapping("/hello2/{name}")
//	public String helloPath(@PathVariable String name, Model model) 
//	{
//		model.addAttribute("name", name);
//		return "hello2";
//	}
	
	@RequestMapping(value= {"/hello2","/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name, Model model) 
	{
		if (name.isPresent()) 
		{
			model.addAttribute("name", name.get());
		}
		else
		{
			model.addAttribute("name", "Phoenix");
		}
		
		return "hello2";
	}
	
	@RequestMapping("/calculator")
	public int calculator(@RequestParam(value= "angka1, angka2") int angka1, int angka2, Model model) 
	{
		model.addAttribute("angka1", angka1);
		model.addAttribute("angka2", angka2);
		int hasil= angka1 + angka2;
		return hasil;
	}
	
	
}
