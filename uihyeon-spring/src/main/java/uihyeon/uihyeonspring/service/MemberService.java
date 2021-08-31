package uihyeon.uihyeonspring.service;

import uihyeon.uihyeonspring.domain.Member;
import uihyeon.uihyeonspring.repository.MemberRepository;
import uihyeon.uihyeonspring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    // 이렇게 객체를 외부에서 주입해서 사용하는 방식을 DI라고 한다.
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    /*
    회원 가입
     */
    public Long join(Member member){
        //같은 이름이 있는 중복 회원은 x
        validateDuplicateMember(member); //중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
