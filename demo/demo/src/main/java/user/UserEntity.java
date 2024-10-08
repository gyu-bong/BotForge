package user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;

@Entity
@Getter

public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true, length = 50)
	private String username;

	@Column(nullable = false, length = 255)
	private String password;

	@Column(nullable = false, unique = true, length = 100)
	private String email;

	@Column(nullable = false, length = 20)
	private String role;

  @Column(nullable = false)
	private Integer point = 0;

	@Column(nullable = false)
	private String phones;

	@Column(nullable = false, updatable = false)
	private LocalDateTime created_at;

	@Column(nullable = false)
	private LocalDateTime updated_at;
}
