package service;

// 비즈니스 로직이 포함되며 트랜잭션을 시작
// 데이터 접근 게층인 repository를 호출
// repository에서 얻어온 정보를 controller에 정보를 전달
// dao로 db접근하고 dto로 데이터를 넘겨 받음
// @autowird , @repostitory 를 사용하여 repository의 메소드에 접근

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import repository.BoardRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
	private final BoardRepository boardRepository;
	
}
