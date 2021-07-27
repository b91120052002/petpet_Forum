package com.petpet.controller;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.petpet.model.ForumBean;
import com.petpet.service.ForumService;

@Controller
public class ForumController {

	@Autowired
	ForumService forumService;
	
	@PostMapping("/update")
	public String update(@RequestParam(name = "textId") Integer textId, 
						  @RequestParam(name = "title") String title, 
						  @RequestParam(name = "text") String text,
						  @RequestParam(name = "text_sub") String text_sub,
						  @RequestParam(name = "text_type") String text_type,
						  Model m
						  ) {
		ForumBean fb = new ForumBean();
		System.out.println("textId = "+textId);
		fb.setTextId(textId);
		fb.setTitle(title);
		fb.setText(text);
		fb.setText_sub(text_sub);
		fb.setText_type(text_type);		
		forumService.update(fb);
		System.out.println("textId = "+fb.getTextId());
		ForumBean fbs1 = forumService.findByTextId(textId);
		m.addAttribute("fbs1", fbs1);
		return "forumText";
	}
	
	
	@GetMapping("/delete")
    public String delete(@RequestParam Integer textId ,
		     			Model m
		     			){
        forumService.delete(textId);
        List<ForumBean> fbs = forumService.findAll();
		m.addAttribute("fbs1", fbs);        
        return "forum_Main";
        
    }
	
	@GetMapping("/text")
	public String findByTextId(
			@RequestParam("textId") Integer textId, 
			Model m 
			) {
		//要Service呼叫Dao
		ForumBean fbs1 = forumService.findByTextId(textId);
		m.addAttribute("fbs1", fbs1);
		return 	"forumText";
	}
	
	//回傳json
	@GetMapping("/textJ")
	public @ResponseBody ForumBean findByTextId(
			@RequestParam Integer textId
			) {
		return forumService.findByTextId(textId);
	}

	@GetMapping("/post_Page")
	public String forum(Model model) {
		return "forum_Post";
	}

	@PostMapping("/post")
	public String insert(@RequestParam(name = "title") String title, 
						  @RequestParam(name = "text") String text,
						  @RequestParam(name = "text_sub") String text_sub,
						  @RequestParam(name = "text_type") String text_type,
						  Model m
						  ) {
		ForumBean fb = new ForumBean();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		fb.setCreate_time(ts);
		fb.setTitle(title);
		fb.setText(text);
		fb.setText_sub(text_sub);
		fb.setText_type(text_type);
		forumService.save(fb);	
		List<ForumBean> fbs = forumService.findAll();
		m.addAttribute("fbs1", fbs);
		return "redirect:/";
	}

	@GetMapping("/")
	public String getTexts(Model model) {
		List<ForumBean> fbs = forumService.findAll();
		model.addAttribute("fbs1", fbs);
		return "forum_Main";
	}
	

//	@PutMapping("/text/{textId}")
//	public @ResponseBody Map<String, String> update(
//			  @RequestBody ForumBean fb,
//			  @PathVariable Integer textId
//			) {
//		Map<String, String> map = new HashMap<>();
//		String result = "";
//		try {
//		   forumService.update(fb);
//		   result = "修改成功";
//		   map.put("success", result);
//		} catch(Exception e) {
//		   result = e.getMessage();	
//		   map.put("fail", result);
//		}
//		return map;
//	}
	
//	@ModelAttribute("update")
//	public ForumBean getForumBean(
//			@RequestParam(value="textId", required = false) Integer textId
//				) {
//		ForumBean fb = null;
//		if (textId == null) {
//			fb = new ForumBean();
//		}else {
//			fb = forumService.findById(textId);
//		}
//		return fb;
//	}
	
	
}
