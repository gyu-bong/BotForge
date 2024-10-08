package gameresult;

import game.GameEntity;
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
public class GameResultEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// 게임 참여 사용자
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity user;

	// 참여한 게임
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "game_id", nullable = false)
	private GameEntity game;

	@Column(nullable = false)
	private Integer pointsAwarded;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String resultDetails;

	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;
}
