package repository;

//JPA를 직접 사용하는 계층
//엔티티 매니저를 사용하여 엔티티를 저장하고 조회
//실제로 DB에 접근하는 객체
//service와 DB를 연결
//JPA에서는 기본적인 CRUD를 제공한다

import org.springframework.data.jpa.repository.JpaRepository;
import model.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

}
