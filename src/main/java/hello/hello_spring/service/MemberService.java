package hello.hello_spring.service;
import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;
public class MemberService {

    private final MemberRepository memberRepository;
    //직접 생성하는 것이 아닌 외부에서 가져오도록
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    /**
    * 서비스는 비즈니스에 가까운 용어 사용해야 함
     */
    /**
     *
     회원가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> { //값이 있으면 로직 동작, 바로 get 해서 가져오는 방법은 비추
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    /**
     *
     전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}