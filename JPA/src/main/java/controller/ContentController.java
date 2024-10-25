package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import domain.Content;
import lombok.RequiredArgsConstructor;
import service.ContentService;

@Controller
@RequiredArgsConstructor
public class ContentController {

	private final ContentService contentService;
	
	@GetMapping(value= {"/home"})
	public String home(Model model) {
		model.addAttribute("contents",contentService.getAllContents());
		return "home";
	}
	
	@GetMapping("/content/write")
	public String writePage() {
		return "write-page";
	}
	
	@PostMapping("/content/write")
	public String writeContent(Content content) {
		LocalDateTime now = LocalDateTime.now();
		String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		content.setUpdateDate(formattedDate);
		
		contentService.writeContent(content);
		return "redirect:/";
	}
	
	@GetMapping("/content/{id}")
	public String showContent(@PathVariable int id, Model model) {
		model.addAttribute("content",contentService.getContent(id));
		return "content-page";
	}
	
	@PostMapping("/content/{id}")
	public String editContent(@PathVariable int id, Content content) {
		contentService.editContent(id,content.getTexts(), content.getPassword());
		return "redirect:/";
	}
	
	@PostMapping("/content/delete/{id}")
	public String deleteContent(@PathVariable int id ,Content content) {
		contentService.deletContent(id, content.getPassword());
		return "redirect:/";
	}
}
