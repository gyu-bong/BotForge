package recommendation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import org.apache.catalina.User;
import org.springframework.data.annotation.Id;
import post.PostEntity;

@Entity
public class RecommendationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// 추천한 사용자
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	// 추천 대상 게시물
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id", nullable = false)
	private PostEntity postentity;

	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;
}
