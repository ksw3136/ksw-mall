package idusw.springboot.kswmall.repository;


import idusw.springboot.kswmall.entity.MemberEntity;
import idusw.springboot.kswmall.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, Long> {

    Optional<MemberEntity> findByIdAndPw(String id, String pw);

}
