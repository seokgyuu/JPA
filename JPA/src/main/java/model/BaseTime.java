package model;
// 클래스 정의할때마다 매번 정의하지 않고 공통 entity 클래스로 만들어 사용가능 

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class) //JPA에서 자동으로 그 값을 채워준다
public abstract class BaseTime {
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdDated;
	
	@LastModifiedDate
	private LocalDateTime modifiedDate;

}
