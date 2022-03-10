package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // 인터페이스 타입이지만 실제로 구현체에 있는 메소드들이 실행됨
    // 인터페이스를 사용하는 이유가 선언과 구현 구분하여, 나중에 구현체 변경 대비 가능
  public final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
