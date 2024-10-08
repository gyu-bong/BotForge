package adminaction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import user.UserEntity;

@Entity
public class AdminActionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// 관리자 사용자
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admin_id", nullable = false)
	private UserEntity admin;

	@Column(nullable = false, length = 50)
	private String actionType;  // USER_SUSPENSION, POST_BLIND 등

	@Column(nullable = false)
	private Long targetId;  // 정지된 사용자 ID, 블라인드 처리된 게시물 ID 등

	@Column(nullable = false, length = 255)
	private String description;

	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;
}
