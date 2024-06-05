package idusw.springboot.kswmall.service;

import idusw.springboot.kswmall.entity.MemberEntity;
import idusw.springboot.kswmall.model.Member;
import idusw.springboot.kswmall.repository.MemberRepository;

import java.util.List;

public interface MemberService {
    // interface : 외부 상호 작용 방법 제시
    // C.R.U.D :
    int create(Member dto);
    Member read(Member dto);
    List<Member> readList();
    int update(Member dto);
    int delete(Member dto);

    Member login(Member dto); // dto 객체가 id/pw 를 전달해줌
    // Member -> MemberEntity : Repository에서는 MemberEntity를 다룸
    default MemberEntity dtoToEntity(Member member) {
        MemberEntity entity = MemberEntity.builder()
                .idx(member.getIdx())
                .id(member.getId())
                .pw(member.getPw())
                .name(member.getName())
                .email(member.getEmail())
                .build();
        return entity;
    }
    // MemberEntity -> : Controller에서는 Member를 다룸
    default Member entityToDto(MemberEntity entity) {
        Member member = Member.builder()
                .idx(entity.getIdx())
                .id(entity.getId())
                .pw(entity.getPw())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
        return member;
    }
}
