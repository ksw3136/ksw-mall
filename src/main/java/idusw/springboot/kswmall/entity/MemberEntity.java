package idusw.springboot.kswmall.entity;

import jakarta.persistence.*; // jpa - build.gradle
import lombok.*;

@Entity // Spring Data JPA의 엔티티(개체)임을 의미함
@Table(name="member2")

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // MySQL, MariaDB의 경우 자동증가하는 필드 IDENTITY, Oracle의 경우 SEQUENCE, AUTO 유동적 선택
    private Long idx;

    @Column(length = 20, nullable = false)
    private String id;
    @Column(length = 20, nullable = false)
    private String pw;
    @Column(length = 20, nullable = true)
    private String name;
    @Column(length = 30, nullable = false)
    private String email;


}