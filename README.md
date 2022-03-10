# Spring-Core-Basic
[인프런] 스프링 핵심 원리 - 기본편

## 객체 지향 설계와 스프링

### 스프링의 핵심 컨셉

스프링은 자바 언어 기반의 프레임워크

자바의 가장 큰 특징은 **객체 지향 언어**

그렇다면, **스프링은 객체 지향 언어의 가장 강력한 특징을 살려내는 프레임워크**라고 볼 수 있다.

`좋은 객체 지향 애플리케이션을 개발`할 수 있게 도와주는 프레임워크가 스프링이라고 할 수 있다.



### 좋은 객체 지향 프로그래밍?

#### 객체 지향 특징

- `추상화` : 인터페이스로 공통적인 특성을 모아 표현
- `캡슐화` : 유사한 속성과 메소드를 클래스로 모은 것, 캡슐 내부의 로직과 변수를 감추고 외부에는 기능만 제공하는 정보은닉이 있음
- `상속` : 자식 클래스가 부모 클래스의 특성과 기능을 상속받아 재사용성 높이는 것
- `다형성` : 오버로딩, 오버라이딩이 있으며  역할과 기능을 분리하여 컴포넌트를 유연하게 변경하면서 개발할 수 있게 도와주는 특징

#### 객체 지향 프로그래밍

- **컨셉의 핵심은 다형성이다. 다형성은 컴포넌트를 쉽고 유연하게 변경하면서 개발할 수 있게 한다.**

- 프로그램을 **독립된 객체들의 모임**으로 파악하고자 하는 것, **객체는 메시지 주고 받는 데이터 처리**한다. (협력)
- 객체 지향 프로그래밍은 프로그램을 **유연하고 변경 용이**하게 만들고, 대규모 소프트웨어 개발에 사용

#### 다형성

- 객체지향의 핵심 컨셉
- `역할과 기능을 분리`하여 `컴포넌트를 유연하게 변경하면서 개발`할 수 있게 도와주는 특징

#### 자바 언어 - 역할과 구현 분리

- 다형성 활용
  - 역할 : 인터페이스
  - 구현 : 인터페이스 구현한 클래스
- 객체 설계할 때 역할과 구현 명확히 분리
- 객체 설계시 역할 먼저 부여하고, 그 역할 수행하는 구현 객체 만들기

#### 객체는 협력 한다?

- 수 많은 클라이언트와 객체 서버는 협력 관계다.

- 클라이언트: 요청.  서버: 응답

#### 자바 언어의 다형성

- 오버라이딩 된 메서드가 실행된다.

- 다형성으로 인터페이스를 구현한 객체를 실행 시점에 변경할 수 있으며, 클래스 상속 관계도 다형성, 오버라이딩 적용 가능하다.

- 다형성 본질 : 클라이언트 변경하지 않고, 서버의 구현 기능을 유연하게 변경할 수 있다.

#### 스프링과 객체 지향

- **객체지향의 꽃 : 다형성**
- IoC, DI 다형성을 활용해서 역할과 구현을 편리하게 다룰 수 있도록 지원
- 구현을 편리하게 변경-> 스프링의 장점



### 좋은 객체 지향 설계의 5가지 원칙(SOLID)

클린코드로 유명한 로버트 마틴이 좋은 객체 지향 설계의 5가지 원칙을 정리

• `SRP`: 단일 책임 원칙(single responsibility principle)
• `OCP`: 개방-폐쇄 원칙 (Open/closed principle)
• `LSP`: 리스코프 치환 원칙 (Liskov substitution principle)
• `ISP`: 인터페이스 분리 원칙 (Interface segregation principle)
• `DIP`: 의존관계 역전 원칙 (Dependency inversion principle)

#### SRP 단일 책임 원칙

- 한 클래스는 하나의 책임만 가져야 한다.
- 하나의 책임이라는 것은 모호하다.
  - 클 수 있고, 작을 수 있다.
  - 문맥과 상황에 따라 다르다.
- 중요한 기준은 변경이다. 변경이 있을 때 파급 효과가 적으면 단일 책임 원칙을 잘 따른 것
- 예) UI 변경, 객체의 생성과 사용을 분리

#### OCP 개방-폐쇄 원칙** 가장 중요한 원칙

- 소프트웨어 요소는 **확장에는 열려**있으나 **변경에는 닫혀**있어야 한다.
- **다형성**을 활용해보자.
- 인터페이스를 구현한 새로운 클래스를 하나 만들어서 새로운 기능을 구현
- 역할과 구현의 분리를 생각해보자.

> - MemberService 클라이언트가 구현 클래스를 직접 선택
>   - MemberRepository m = new MemoryMemberRepository(); // 기존 코드
>   - MemberRepository m = new JdbcMemberRepository(); // 변경 코드
> - **구현 객체를 변경하려면 클라이언트 코드를 변경해야 한다.**
> - **분명 다형성을 사용했지만 OCP 원칙을 지킬 수 없다**.
> - 이 문제를 어떻게 해결해야하나?
> - 객체를 생성하고, 연관관계를 맺어주는 별도의 조립, 설정자가 필요하다. - 다형성만으로 해결X

#### LSP 리스코스 치환 원칙

- 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다.
- 다형성에서 하위 클래스는 인턴페이스 규악을 다 지켜야한다는 것, 다형성을 지원하기 위한 원칙, 인터페이스를 구현한 구현체는 믿고 사용하려면, 이 원칙이 필요하다.
- 단순히 컴파일에 성공하는 것을 넘어서는 이야기
- 예) 자동차 인터페이스의 엑셀은 앞으로 가라는 기능, 뒤로 가게 구현하면 LSP 위반, 느리더라도 앞으로 가야함

#### ISP 인터페이스 분리 원칙

- 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다.
- 자동차 인터페이스 -> 운전 인터페이스, 정비 인터페이스로 분리
- 사용자 클라이언트 -> 운전자 클라이언트, 정비사 클라이언트로 분리
- 분리하면 정비 인터페이스 자체가 변해도 운전자 클라이언트에 영향을 주지 않음
- 인터페이스가 명확해지고, 대체 가능성이 높아진다

#### DIP 의존관계 역전 원칙** 중요

- 프로그래머는 "추상화에 의존해야지, 구체화에 의존하면 안된다." 의존성 주입은 이 원칙을 따르는 방법 중 하나다.
- 쉽게 이야기해서 구현 클래스에 의존하지 말고,`클라이언트는 인터페이스에 의존`하라는 뜻
- 앞에서 이야기한 **역할(Role)에 의존하게 해야 한다는 것과 같다.** 객체 세상도 클라이언트가 인터페이스에 의존해야 유연하게 구현체를 변경할 수 있다. 구현체에 의존하게 되면 변경이 아주 어려워진다.
- 그런데 OCP에서 설명한 MemberService는 인터페이스에 의존하지만, 구현 클래스도 동시에 의존한다.
- MemberService 클라이언트가 구현 클래스를 직접 선택
  - MemberRepository m = new MemoryMemberRepository();
- **DIP 위반**

#### 정리

- 객체 지향의 핵심은 다형성
- 다형성 만으로는 쉽게 부품을 갈아 끼우듯이 개발할 수 없다.
- 다형성 만으로는 구현 객체를 변경할 때 클라이언트 코드도 함께 변경된다.
- **다형성 만으로는 OCP, DIP를 지킬 수 없다.**
- 뭔가 더 필요하다.



### 객체 지향 설계와 스프링

- 스프링은 다음 기술로 다형성 + OCP, DIP를 가능하게 지원
  - DI (Dependency Injection): 의존 관계, 의존성 주입
  - DI 컨테이너 제공
- **클라이언트 코드의 변경 없이 기능 확장**
- 쉽게 부품을 교체하듯이 개발



## 스프링 핵심 원리 이해1 - 예제 만들기

(스프링의 도움 없이 순수 자바로만 먼저 짜보겠음)

### 프로젝트 생성

- Project: Gradle Project
  - Spring Boot: 2.5.x
  - Language: Java
  - Packaging: Jar
  - Java: 11
- Project Metadata
  - groupId: hello
  - artifactId: core
- Dependencies: 선택하지 않는다.

실행을 빠르게 하기 위해 settings - gradle - build/run을 intellij로 바꾼다. 

![image-20220310114937066](C:\Users\yujin\AppData\Roaming\Typora\typora-user-images\image-20220310114937066.png)



### 비즈니스 요구 사항과 설계

- 회원
  - 회원을 가입하고 조회할 수 있다.
  - 회원은 일반과 VIP 두가지 등급이 있다.
  - 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다. (미확정)
- 주문과 할일 정책
  - 회원은 상품을 주문할 수 있다.
  - 회원 등급에 따라 할인 정책을 적용할 수 있다.
  - 할인 정책은 모든 VIP는 1000원을 할인해주는 고정 금액 할인을 적용해달라. (나중에 변경 될 수 있다.)
  - 할인 정책은 변경 가능성이 높다. 회사의 기본 할인 정책을 아직 정하지 못했고, 오픈 직전까지 고민을 미루고 싶다. 최악의 경우 할인을 적용하지 않을 수 도 있다. (미확정)

요구 사항을 보면 현재 결정하기 어려운 부분들이 있지만, 인터페이스를 만들고 구현체를 언제든 갈아끼울 수 있게 설계하면 문제를 해결할 수 있다.

### 회원 도메인 설계

- 회원 도메인 요구사항
  - 회원을 가입하고 조회할 수 있다.
  - 회원은 일반과 VIP 두 가지 등급이 있다.
  - 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다. (미확정)

#### 회원 도메인 협력 관계 : 기획자가 참고

![img](https://user-images.githubusercontent.com/38436013/126977572-61f0f92c-45b0-426f-a524-c9de8b1a693e.png)

#### 회원 클래스 다이어그램 : 개발자가 참고

![img](https://user-images.githubusercontent.com/38436013/126977595-2fc47749-b5cd-4936-b16c-f2ee9a54f6bc.png)

#### 회원 객체 다이어그램 : 서버 떴을 때 클라이언트가 실제로 사용하는 참조

(실제 객체 간의 참조라고 보면 된다. 클라는 회원서비스impl을, 회원서비스impl은 메모리~~를 참조한다. )

![img](https://user-images.githubusercontent.com/38436013/126973706-356b5fcf-8431-4148-b322-e3c44ff2f804.png)

### 회원 도메인 개발

*회원 클래스 다이어 그램을 기반으로 구현*

#### 회원 엔티티

- 회원 등급

~~~java
public enum Grade {
    BASIC,
    VIP
}
~~~

- 회원 엔티티

~~~java
public class Member {

    private Long id;
    private String name;
    private Grade grade;

    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
~~~

#### 회원 저장소

- 회원 저장소 인터페이스

~~~java
public interface MemberRepository {

    void save(Member member);
    Member findById(Long memberId);
}
~~~

- 메모리 회원 저장소 구현체

~~~java
import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
~~~

#### 회원 서비스

- 회원 서비스 인터페이스

~~~java
public interface MemberService {
    void join(Member memeber);
    Member findMember(Long memberId);
}
~~~

- 회원 서비스 구현체

~~~java
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 다형성에 의해 MemoryMemberRepository의 save, findById 호출
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
~~~

### 회원 도메인 실행과 테스트

*회원 객체 다이어그램 기반으로 구현*

- 회원 도메인 - 회원 가입 테스트

~~~java
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
~~~

#### 회원 도메인 설계의 문제점

- 이 코드의 설계상 문제점은 무엇일까?
- 다른 저장소 변경할 때 OCP 원칙 잘 지키고 있는가?
- DIP는 지키고 있는가?
- 의존관계가 인터페이스 뿐 아니라 구현까지 모두 의존하는 문제점이 있다.

```java
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    }
```

MemberServiceImpl는 MemberRepository, MemoryMemberRepository 모두 의존하고 있다. -> DIP 위반

### 주문 과 할인 도메인 설계

- 주문과 할인 정책
  - 회원은 상품 주문 가능
  - 회원 등급에 따라 할인 정책을 적용할 수 있다.
    - 할인 정책은 모든 VIP는 1000원을 할인해주는 고정 금액 할인을 적용하자.(변경 가능)
    - 할인 정책은 변경 가능성이 높다. 회사의 기본 할인 정책을 아직 정하지 못했고, 오픈 직전까지 고민을 미루고 싶다. (미확정)

### 주문 도메인 협력, 역할, 책임

역할만 그림으로 표현

![img](https://user-images.githubusercontent.com/38436013/127806729-8677c1ad-596d-492e-a8ad-d8f8cc156e60.png)

1. **주문 생성**: 클라이언트는 주문 생성을 요청한다.
2. **회원 조회**: 할인을 위해서는 회원 등급이 필요하고, 주문 서비스는 회원저장소에서 회원을 조회한다.
3. **할인 적용**: 주문 서비스는 회원 등급에 따른 할인 여부를 할인 정책에 위임한다.
4. **주문 결과 반환**: 주문 서비스는 할인 결과를 포함한 주문 결과를 반환한다.

### 주문 도메인 전체

역할과 구현 그림으로 표현

정액 할인 : vip는 1000원 할인, 정률 확인 : 금액에 대한 10%, 20% 할인

![img](https://user-images.githubusercontent.com/38436013/127806739-dc421bbd-7cc3-47d0-871f-136b22ac3c82.png)

**역할과 구현을 분리**해서 자유롭게 구현 객체를 조립할 수 있게 설계

회원저장소나 할인 정책 변경 가능

협력 관계를 그대로 재사용 가능하다.

### 주문과 할인 도메인 개발

- 할인 정책 인터페이스

~~~java
import hello.core.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price) ;
}
~~~

- 정책 할인 정책 구현체

~~~java
import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000; // 1000원 할인

    // VIP 1000원 할인, 아니면 할인 없음
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return discountFixAmount;
        }
        else {
            return 0;
        }
    }
}
~~~

- 주문 엔티티

~~~java
public class Order {

    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;

    public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }
    public int calculatePrice() {
        return itemPrice - discountPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() { // 객체 출력하면 toString 출력하기
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
~~~

- 주문 서비스 인터페이스

~~~java
public interface OrderService {
    Order createOrder (Long memberId, String itemName,int itemPrice );
    // 최종 주문 결과를 반환
}
~~~

- 주문 서비스 구현체

~~~java
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    // 좋은 설계 - 단일 체계 원칙이 잘 지켜짐
    // discountPolicy로 인해 할인 정책을 변경하더라도, 주문 서비스(구현체)는 신경x
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 회원 정보 조회하고, 할인 정책에 회원 넘김
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    
~~~

주문 생성 요청오면, 회원 조회하고 회원 정보 할인 정책에 넘겨, 주문 객체를 생성하고, 반환한다.

### 주문과 할인 도메인 실행과 테스트

- 주문과 할인 정책 테스트

~~~JAVA
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "ItemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
~~~

### Feedback

지금까지는 다형성을 잘 적용했지만, (할인 정책을 바꾼다면)정률 할인 정책으로 바꾼다면, 지금처럼 스프링 기본 원칙들을 지켜나갈 수 있는지에 초점을 맞추고 다음 시리즈에서 개발해보자.