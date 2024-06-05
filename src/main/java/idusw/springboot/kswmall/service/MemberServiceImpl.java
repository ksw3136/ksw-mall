package idusw.springboot.kswmall.service;

import idusw.springboot.kswmall.entity.MemberEntity;
import idusw.springboot.kswmall.model.Member;
import idusw.springboot.kswmall.repository.MemberJpaRepository;
import idusw.springboot.kswmall.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{
    /*
    final MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository) { // 생성자:  주입된 객체의 필드에 배정
        this.memberRepository = memberRepository;
    }
     */
    final MemberJpaRepository memberJpaRepository;
    public MemberServiceImpl(MemberJpaRepository memberJpaRepository) { // 생성자:  주입된 객체의 필드에 배정
        this.memberJpaRepository = memberJpaRepository;
    }

    @Override
    public int create(Member dto) {
        return 0;
    }

    @Override
    public Member read(Member dto) {
        Optional<MemberEntity> result = memberJpaRepository.findById(dto.getIdx());
        if(!result.isEmpty())
            return entityToDto(result.get());
        else
            return null;
    }

    @Override
    public List<Member> readList() {
        // @Service : 비지니스 로직(업무) 처리를 담당, 통계 처리, 분석
        // dto - Member 와 entity - MemberEntity 공존함, 상호 변환
        // Java는 객체 관점, DB는 entity & relation 관점
        List<MemberEntity> memberEntityList = memberJpaRepository.findAll();
        List<Member> memberList = null; // List 인터페이스 (공통적, 외부접근), ArrayList 구현체, Vector 구현제
        if(!memberEntityList.isEmpty()) {
            memberList = new ArrayList<>(); // <>, Generics 사용
            for(MemberEntity me : memberEntityList)
                memberList.add(entityToDto(me)); // MemberService 인터페이스의 기본 메소드(default) 가짐
        }
        return memberList;
    }

    @Override
    public int update(Member dto) {
        MemberEntity memberEntity = MemberEntity.builder()
                .idx(dto.getIdx())
                .id(dto.getId())
                .pw(dto.getPw())
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
        if(memberJpaRepository.save(memberEntity) != null)
            return 1;
        else
            return 0;
    }

    @Override
    public int delete(Member dto) {
        return 0;
    }

    @Override
    public Member login(Member dto) {
        // dtoToEntity() 메소드를 default 메소드로 Service 인터페이스에 정의해둠
        MemberEntity entity = dtoToEntity(dto);
        Optional<MemberEntity> memberEntityOptional =
                memberJpaRepository.findByIdAndPw(entity.getId(), entity.getPw());
        if(memberEntityOptional.isPresent())
            return entityToDto(memberEntityOptional.get());
        else
            return null;
    }
}
