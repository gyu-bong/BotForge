package pointtransaction;

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
public class PointTransactionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// 포인트 거래 사용자
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity user;

	@Column(nullable = false)
	private Integer points;  // 증감 포인트

	@Column(nullable = false, length = 20)
	private String transactionType;  // EARN, SPEND

	@Column(nullable = false, length = 255)
	private String description;

	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

}
