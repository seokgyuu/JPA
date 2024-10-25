package controller;

//서비스 계층을 호출하고 결과를 뷰에 전달
// 데이터 검증을 수행
// url에 따라 적절한 view와 mapping 처리
//@autowired @service를 사용해 service 메소드 사용

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
}
