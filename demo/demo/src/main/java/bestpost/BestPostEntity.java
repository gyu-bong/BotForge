package bestpost;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import post.PostEntity;

@Entity
public class BestPostEntity {
	@Id
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	private PostEntity post;  // 베스트 게시물

	@Column(nullable = false, updatable = false)
	private LocalDateTime awardedAt;


}
