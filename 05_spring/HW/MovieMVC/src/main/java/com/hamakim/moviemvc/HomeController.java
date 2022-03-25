package com.hamakim.moviemvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hamakim.moviemvc.model.dto.Movie;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public ModelAndView home() {
//		
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("msg", "그래서 난" );
//		mav.addObject("msg2", "jungah");
//		mav.addObject("msg3", "nunah"  );
//		
//		mav.setViewName("home");
//		
//		return mav;
//	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
		
		
		model.addAttribute("msg", "그래서 난" );
		model.addAttribute("msg2", "jungah" );
		model.addAttribute("msg3", "nunah" );
		
		
		return "home";
	}
	
	// 
	@PostMapping("/movie")
	public String getMovieFromJSP(Model model, Movie movie) {
		model.addAttribute("movie", movie);
		return "show";
	}
}
