package idusw.springboot.kswmall.repository;

import idusw.springboot.kswmall.model.Member;

import java.util.List;

public interface MemberRepository {
    // C.R.U.D : Data Basic Operation
    // Create -> insert
    // Read -> select
    // Update -> update
    // Delete -> delete
    int insert(Member member);
    Member selectById(Member member);
    List<Member> selectList();
    int update(Member member);
    int delete(Member member);
    /*
    Member selectByEmail(Member member);
    List<Member> sort(String direction);
    List<Member> selectListByCondition(String condition, String direction);
    */
}
