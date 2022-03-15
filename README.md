# Spring-Core-Basic
[인프런] 스프링 핵심 원리 - 기본편

## 1. 객체 지향 설계와 스프링

### 1.1 스프링의 핵심 컨셉

스프링은 자바 언어 기반의 프레임워크

자바의 가장 큰 특징은 **객체 지향 언어**

그렇다면, **스프링은 객체 지향 언어의 가장 강력한 특징을 살려내는 프레임워크**라고 볼 수 있다.

`좋은 객체 지향 애플리케이션을 개발`할 수 있게 도와주는 프레임워크가 스프링이라고 할 수 있다.



### 1.2 좋은 객체 지향 프로그래밍?

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



### 1.3 좋은 객체 지향 설계의 5가지 원칙(SOLID)

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



### 1.4 객체 지향 설계와 스프링

- 스프링은 다음 기술로 다형성 + OCP, DIP를 가능하게 지원
  - DI (Dependency Injection): 의존 관계, 의존성 주입
  - DI 컨테이너 제공
- **클라이언트 코드의 변경 없이 기능 확장**
- 쉽게 부품을 교체하듯이 개발



## 2. 스프링 핵심 원리 이해1 - 예제 만들기

(스프링의 도움 없이 순수 자바로만 먼저 짜보겠음)

### 2.1 프로젝트 생성

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



### 2.2 비즈니스 요구 사항과 설계

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

### 2.3 회원 도메인 설계

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

### 2.4 회원 도메인 개발

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

### 2.5 회원 도메인 실행과 테스트

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

### 2.6 주문 과 할인 도메인 설계

- 주문과 할인 정책
  - 회원은 상품 주문 가능
  - 회원 등급에 따라 할인 정책을 적용할 수 있다.
    - 할인 정책은 모든 VIP는 1000원을 할인해주는 고정 금액 할인을 적용하자.(변경 가능)
    - 할인 정책은 변경 가능성이 높다. 회사의 기본 할인 정책을 아직 정하지 못했고, 오픈 직전까지 고민을 미루고 싶다. (미확정)

#### 주문 도메인 협력, 역할, 책임

역할만 그림으로 표현

![img](https://user-images.githubusercontent.com/38436013/127806729-8677c1ad-596d-492e-a8ad-d8f8cc156e60.png)

1. **주문 생성**: 클라이언트는 주문 생성을 요청한다.
2. **회원 조회**: 할인을 위해서는 회원 등급이 필요하고, 주문 서비스는 회원저장소에서 회원을 조회한다.
3. **할인 적용**: 주문 서비스는 회원 등급에 따른 할인 여부를 할인 정책에 위임한다.
4. **주문 결과 반환**: 주문 서비스는 할인 결과를 포함한 주문 결과를 반환한다.

#### 주문 도메인 전체

역할과 구현 그림으로 표현

정액 할인 : vip는 1000원 할인, 정률 확인 : 금액에 대한 10%, 20% 할인

![img](https://user-images.githubusercontent.com/38436013/127806739-dc421bbd-7cc3-47d0-871f-136b22ac3c82.png)

**역할과 구현을 분리**해서 자유롭게 구현 객체를 조립할 수 있게 설계

회원저장소나 할인 정책 변경 가능

협력 관계를 그대로 재사용 가능하다.

### 2.7 주문과 할인 도메인 개발

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

### 2.8 주문과 할인 도메인 실행과 테스트

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

### 2.9 Feedback

지금까지는 다형성을 잘 적용했지만, (할인 정책을 바꾼다면)정률 할인 정책으로 바꾼다면, 지금처럼 스프링 기본 원칙들을 지켜나갈 수 있는지에 초점을 맞추고 다음 시리즈에서 개발해보자.



## 3. 스프링 핵심 원리 이해1 - 객체 지향 원리 적용

### 3.1 새로운 할인 정책 개발

#### 새로운 할인 정책 확장하기

- 기획자 : 주문 금액 당 할인하는 정률% 할인으로 변경하고 싶어요. 예를 들어서 기존 정책은 VIP가 10000원을 주문하든 20000원을 주문하든 항상 1000원을 할인했는데, 이번에 새로 나온 정책은 10%로 지정해두면 고객이 10000원 주문시 1000원을 할인해주고, 20000원 주문시에 2000원을 할인해주는 거에요.

- RateDiscountPolicy 

~~~java

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10; // 10% 할인
    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return price*discountPercent / 100;
        }
        else {
            return 0;
        }
    }
}
~~~

- 테스트 작성

~~~ JAVA
import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o(){
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_x(){
        // given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        assertThat(discount).isEqualTo(0);
    }
}
~~~

### 3.2 새로운 할인 정책 적용과 문제점

#### 할인 정책을 애플리케이션에 적용해보자.

```java
public class OrderServiceImpl implements OrderService {
// private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
 private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
}
```

#### 문제점 발견

- 역할고 구현 분리 -> O

- 다형성 활용하고, 인터페이스와 구현 객체 분리 -> O

- OCP, DIP 같은 객체지향 설계 원칙을 충실히 준수 -> 그렇지 않다.

- **DIP** : 주문서비스 클라이언트(`OrderServiceImpl` )는 `DiscountPolicy` 인터페이스에 의존하면서 DIP를 지킨 것 같은데?

  - **클래스 의존관계를 분석해 보자. `추상인터페이스`뿐만 아니라 `구체클래스`에도 의존**하고 있다.
  - 추상(인터페이스) 의존: `DiscountPolicy`
  - 구체(구현) 클래스: `FixDiscountPolicy` , `RateDiscountPolicy`

- **OCP**: 변경하지 않고 확장할 수 있다고 했는데!

  - 지금 코드는 기능을 확장해서 변경하면, 클라이언트 코드에 영향을 준다! **따라서 OCP를 위반한다.**

  ~~~java
  public class OrderServiceImpl implements OrderService{
      private final MemberRepository memberRepository = new MemoryMemberRepository();
      
      //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
      private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
  }
  ~~~

   FixDiscountPolicy 를 RateDiscountPolicy 로 변경하는 순간 OrderServiceImpl 의 소스 코드도 함께 변경해야 한다! **OCP 위반**

#### 어떻게 해결?

- **인터페이스에만 의존하도록 코드 변경**

```java
public class OrderServiceImpl implements OrderService {
 //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
 private DiscountPolicy discountPolicy;
}
```

- 인터페이스에만 의존하도록 설계와 코드를 변경했다.
- 구현체 없어서 실제 실행을 해보면 NPE(null pointer exception)가 발생한다.

해결방안

누군가가 클라이언트인 OrderServiceImpl 에 DiscountPolicy 의 구현 객체를 대신 생성하고 주입해주어야 한다.

### 3.3 관심사 분리

구현 객체를 대신 생성해주고, 주입해 줄 수 있는 AppConfig 등장

#### AppConfig 등장

이전에는 구현체에서 객체를 생성했지만, appconfig에서 **구현 객체 생성**하고, 생성한 객체를 **생성자를 통해 주입**한다.

- AppConfig

~~~java
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        // 구현 객체 생성 & 생성자 주입
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
~~~

- AppConfig는 **구현 객체를 생성**한다.
  - `MemberServiceImpl`
  - `MemoryMemberRepository`
  - `OrderServiceImpl`
  - `FixDiscountPolicy`
- AppConfig는 생성한 객체 인스턴스의 참조를 **생성자를 통해 주입**해준다.
  - `MemberServiceImpl` -> `MemoryMemberRepository`
  - `OrderServiceImpl` -> `MemoryMemberRepository` , `FixDiscountPolicy`

- MemberServiceImpl - 생성자 주입

~~~java
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

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

- 설계 변경으로 `MemberServiceImpl` 은`MemberRepository`인터페이스만 의존한다.
- `MemberServiceImpl` 는 생성자를 통해 어떤 구현 객체가 들어올지 알 수 없고, 외부(`AppConfig`)에서 결정된다. 따라서 `MemberServiceImpl`는 **의존관계 고려하지 않고, 실행에만 집중**

- OrderServiceImpl - 생성자 주입

~~~java
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
~~~



#### 그림 - 클래스 다이어그램

![img](https://user-images.githubusercontent.com/38436013/127845579-7f2122b8-92e1-404c-b5f9-8b484d41aa73.png)

- 객체의 생성과 연결은 AppConfig가 담당
- **DIP** : MemberServiceImpl 은 MemberRepository 인 추상에만 의존하면 된다. 구체클래스는 몰라도 된다.
- **관심사의 분리** : 객체 생성, 연결의 역할과 실행의 역할이 분리됨

> MemberServiceImpl는 MemberService의 구현체로, MemberRepository 라는 인터페이스를 의존하고 있다. -> DIP
>
> AppConfig에서 memoryMemberRepository 객체를 생성하고, 이 객체의 참조값을 memberServiceImpl을 생성하면서, 생성자로 전달한다.
>
> 즉, 외부에서 생성과 연결을 해주기 때문에 MemberServiceImpl는 구체 클래스의 변경이 생겨도 OCP를 지킬 수 있다.

- 사용 클래스 - MemberApp 수정

```java
 public static void main(String[] args){
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        //MemberService memberService = new MemberServiceImpl();
```

- 사용 클래스 - OrderApp 수정

```java
public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
```

- 테스트 코드 오류 수정

```java
public class MemberServiceTest {

    MemberService memberService ;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
```

~~~JAVA
public class OrderServiceTest {
    MemberService memberService ;
    OrderService orderService ;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
~~~

> 이전에는 `MemberService memberService = new MemberServiceImpl();` 메인에서 직접 객체를 생성했다면, 메인에서 AppConfig 객체를 생성하여, 서비스(memberService를 받아온다. 이때, 서비스의 추상(MemberServiceImpl)을 호출하고, 추상의 구현체를 받아온다.

정리

- AppConfig 통해 관심사 분리했고, 객체 생성과 연결을 담당한다.
- OrderServiceImpl 은 기능을 실행하는 책임만 지면 된다. 

### 3.4 AppConfig 리팩토링

현재 AppConfig를 보면 **중복**이 있고, **역할에 따른 구현**이 잘 안보인다.

#### 리팩토링 전

```java
package hello.core;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
public class AppConfig {
 	public MemberService memberService() {
 		return new MemberServiceImpl(new MemoryMemberRepository());
 	}
 	public OrderService orderService() {
 		return new OrderServiceImpl(
 			new MemoryMemberRepository(),
 			new FixDiscountPolicy());
 	}
}
```

memberService에서 리턴하는 구체 클래스의 역할(MemberRepository 인터페이스)이 보이지 않음

#### 리팩토링 후

```java
package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        // 구현 객체 생성 & 생성자 주입
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
```

- `new MemoryMemberRepository()` 이 부분이 중복 제거되었다.
- 이제 `MemoryMemberRepository` 를 다른 구현체로 변경할 때 한 부분만 변경하면 된다.
- `AppConfig` 를 보면 역할과 구현 클래스가 한눈에 들어온다. 메서드에서 역할이 드러나고, 리턴에서 구현이 드러남

### 3.5 새로운 구조와 할인 정책 적용

- 정액 할인 정책을 정률 할인 정책으로 변경하자

![img](https://user-images.githubusercontent.com/38436013/127893289-1b452acc-a84d-4f54-8c3b-13fc3d084762.png)

- 할인 정책 변경 구성 코드

```JAVA
public class AppConfig {
    // 역할이 드러나게 리팩토링하기, 인터페이스와 구체 클래스를 한눈에 확인 가능하다.
    
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
```

- 이제 할인 정책을 변경해도, 애플리케이션의 구성 역할을 담당하는 AppConfig만 변경하면 된다.
- 사용 영역은 변경X, 구성 영역은 당연히 변경된다.

### 3.6 전체 흐름 정리

| 새로운 할인 정책 개발        | 정률 할인 정책 코드 추가 개발에는 다형성 덕분에 문제 없음    |
| ---------------------------- | ------------------------------------------------------------ |
| 새로운 할인 정책 개발 문제점 | 1. 클라이언트 코드 변경 <br />2. 클라이언트 인터페이스가 DiscountPolicy 뿐만 아니라, 구체 클래스인 FixDiscountPolicy 도 함께 의존 -> **DIP 위반** |
| 관심사 분리                  | AppConfig 등장 <br />AppConfig는 전체 동작 방식 구성을 위해, 구현 객체를 생성하고, 연결 담당 클라이언트 객체는 실행에만 집중 |
| AppConfig 리팩터링           | 역할과 구현을 명확하게 분리(AppConfig는 전체 동작 확인), 중복 제거 |
| 새로운 구조와 할인 정책 적용 | 정액 할인 정책 -> 정률 할인 정책으로 변경 <br />AppConfig의 등장으로 애플리케이션이 크게 **사용 영역**과, 객체를 생성하고 **구성(Configuration)하는 영역**으로 분리 |

### 3.7 좋은 객체 지향 설계의 5가지 원칙과 적용

여기서 3가지 SRP, DIP, OCP 적용

### SRP 단일 책임 원칙

**한 클래스는 하나의 책임만 가져야 한다.**

- 클라이언트 객체는 직접 구현 객체를 생성하고, 연결하고, 실행하는 다양한 책임을 가지고 있음
- SRP 단일 책임 원칙을 따르면서 관심사를 분리함
- 구현 객체를 생성하고 연결하는 책임은 AppConfig가 담당
- **클라이언트 객체는 실행하는 책임만 담당**

### DIP 의존관계 역전 원칙

**프로그래머는 “추상화에 의존해야지, 구체화에 의존하면 안된다.” 의존성 주입은 이 원칙을 따르는 방법 중 하나다.**

- 새로운 할인 정책을 개발하고, 적용하려고 하니 클라이언트 코드도 함께 변경해야 했다. 왜냐하면 기존 클라 이언트 코드( OrderServiceImpl )는 DIP를 지키며 DiscountPolicy 추상화 인터페이스에 의존하는 것 같았지만, FixDiscountPolicy 구체화 구현 클래스에도 함께 의존했다.
- **클라이언트 코드가 DiscountPolicy 추상화 인터페이스에만 의존**하도록 코드를 변경했다.
- 하지만 클라이언트 코드는 인터페이스만으로는 아무것도 실행할 수 없다.
- **AppConfig가 FixDiscountPolicy 객체 인스턴스를 생성해서 클라이언트 코드에 의존관계를 주입**했다. 이렇게해서 DIP 원칙을 따르면서 문제도 해결했다.

### OCP

#### **소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다**

- 다형성 사용하고 클라이언트가 DIP를 지킴
- 애플리케이션을 **사용 영역과 구성 영역으로 나눔**
- AppConfig가 의존관계를 FixDiscountPolicy RateDiscountPolicy 로 변경해서 클라이언트 코드에 주입하므로 `**클라이언트 코드는 변경하지 않아도 됨**`
- **소프트웨어 요소를 새롭게 확장해도 사용 역영의 변경은 닫혀 있다!**

### 3.8 IoC, DI, 컨테이너

#### 제어의 역전 IoC(Inversion of Control)

- 기존에는 클라이언트 구현 객체가 구현 객체 생성, 연결, 실행했지만, AppConfig 등장으로 실행하는 역할만 수행
- 프로그램에 대한 **제어 흐름에 대한 권한은 모두 AppConfig**가 가지고 있다.
- **프로그램의 제어 흐름을 외부에서 관리하는 것을 제어의 역전(IoC)**이라 한다.

#### 프레임워크 vs 라이브러리

- 프레임워크가 내가 작성한 코드를 제어하고, 대신 실행하면 그것은 프레임워크가 맞다. (JUnit) -> 제어권이 외부에 !
- 반면에 내가 작성한 코드가 직접 제어의 흐름을 담당한다면 그것은 프레임워크가 아니라 라이브러리다.

#### 의존관계 주입 DI(Dependency Injection)

- OrderServiceImpl 은 DiscountPolicy 인터페이스에 의존한다. 실제 어떤 구현 객체가 사용될지는 모른다.
- 의존관계는 **정적인 클래스 의존 관계와, 실행 시점에 결정되는 동적인 객체(인스턴스) 의존 관계** 둘을 분리해서 생각해야 한다.

#### 정적인 클래스 의존관계

클래스가 사용하는 import 코드만 보고 의존관계를 쉽게 판단할 수 있다. 정적인 의존관계는 애플리케이션을 실행하지 않아도 분석할 수 있다. 클래스 다이어그램을 보자
OrderServiceImpl 은 MemberRepository , DiscountPolicy 에 의존한다는 것을 알 수 있다. 그런데 이러한 클래스 의존관계 만으로는 실제 어떤 객체가 OrderServiceImpl 에 주입 될지 알 수 없다.

**클래스 다이어그램**

![img](https://user-images.githubusercontent.com/38436013/127897742-83687d49-4889-4e9e-8ff6-446ab9592225.png)

> OrderServiceImpl 코드를 보면, OrderService를 참조, MemberRepository , DiscountPolicy 를 참조
>
> FixDiscountPolicy를 보면 DiscountPolicy 상속하고 있음

#### 동적인 객체 인스턴스 의존 관계

애플리케이션 실행 시점에 실제 생성된 객체 인스턴스의 참조가 연결된 의존 관계다.

**객체 다이어그램**

![img](https://user-images.githubusercontent.com/38436013/127898806-ddbc991b-8aa1-43de-8568-3c8f3a644512.png)

- 애플리케이션 **실행 시점(런타임)**에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 클라이언트와 서버의 실제 의존관계가 연결 되는 것을 **의존관계 주입**이라 한다.
- `객체 인스턴스를 생성하고, 그 참조값을 전달해서 연결`된다.
- 의존관계 주입을 사용하면 클라이언트 코드를 변경하지 않고, 클라이언트가 호출하는 대상의 타입 인스턴스를 변경할 수 있다.
- **의존관계 주입을 사용하면 정적인 클래스 의존관계를 변경하지 않고, 동적인 객체 인스턴스 의존관계를 쉽게 변경할 수 있다.**

#### IoC 컨테이너, DI 컨테이너

- **AppConfig 처럼 객체를 생성하고 관리하면서 의존관계를 연결해 주는 것**을 IoC 컨테이너 또는 **DI 컨테이너**라 한다.
- 의존관계 주입에 초점을 맞추어 최근에는 주로 DI 컨테이너라 한다.
- 또는 어샘블러, 오브젝트 팩토리 등으로 불리기도 한다.

### 3.9 스프링으로 전환

- AppConfig 스프링 기반으로 변경

~~~java
@Configuration
public class AppConfig {
    
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }

    @Bean
    public MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
~~~

AppConfig에 설정을 구성한다는 뜻의 @Configuration 을 붙여준다.

각 메서드에 @Bean 을 붙여준다. 이렇게 하면 스프링 컨테이너에 스프링 빈으로 등록한다..

- MemberApp에 스프링 컨테이너 적용

~~~java
public class MemberApp {
    public static void main(String[] args){
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        // 스프링 코드, 스프링은 AppConfig.class에서 Bean이 붙은 객체 인스턴스를 스프링 컨테이너에 등록하고 관리해줌
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // AppConfig 에서 memberService 이름을 갖고 있는 Bean을 MemberService.class 에서 찾을 거야 
        // -> 이때, Bean은 참조하고 있는 구현 객체? 인 것 같음
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
~~~

- OrderApp에 스프링 컨테이너 적용

~~~java
public class OrderApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new  AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        
~~~

- ApplicationContext 를 스프링 컨테이너라 한다.
- 기존에는 개발자가 AppConfig 를 사용해서 직접 객체를 생성하고 DI를 했지만, 이제부터는 스프링 컨테이너를 통해서 사용한다.
- 스프링 컨테이너는 @Configuration 이 붙은 AppConfig 를 설정(구성) 정보로 사용한다. 여기서 **@Bean이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록한다.** 이렇게 **스프링 컨테이너에 등록된 객체를 스프링 빈**이라 한다.
- 스프링 빈은 @Bean 이 붙은 메서드의 명을 스프링 빈의 이름으로 사용한다. ( memberService ,orderService )
- 이전에는 개발자가 필요한 객체를 AppConfig 를 사용해서 직접 조회했지만, **이제부터는 스프링 컨테이너를 통해서 필요한 스프링 빈(객체)를 찾아야 한다.** 스프링 빈은 applicationContext.getBean() 메서드를 사용해서 찾을 수 있다.
- 기존에는 개발자가 직접 자바코드로 모든 것을 했다면 이제부터는 **스프링 컨테이너에 객체를 스프링 빈으로 등록하고, 스프링 컨테이너에서 스프링 빈을 찾아서 사용**하도록 변경되었다.



## 4. 스프링 컨테이너와 스프링 빈

### 4.1 스프링 컨테이너 생성

```java
//스프링 컨테이너 생성
ApplicationContext applicationContext = 
    new AnnotationConfigApplicationContext(AppConfig.class);
```

- ApplicationContext 를 스프링 컨테이너라 한다.
- ApplicationContext 는 **인터페이스**이다.
- 스프링 컨테이너는 XML을 기반으로 만들 수 있고, **애노테이션 기반의 자바 설정 클래스**로 만들 수 있다.
- 직전에 AppConfig 를 사용했던 방식이 애노테이션 기반의 자바 설정 클래스로 스프링 컨테이너를 만든 것이다.
- 자바 설정 클래스를 기반으로 스프링 컨테이너( ApplicationContext )를 만들어보자.
  - new AnnotationConfigApplicationContext(AppConfig.class);
  - 이 클래스(AnnotationConfigApplicationContext)는 ApplicationContext 인터페이스의 구현체이다.

> 참고: 더 정확히는 스프링 컨테이너를 부를 때 BeanFactory , ApplicationContext 로 구분해서 이야기한다. 이 부분은 뒤에서 설명하겠다. BeanFactory 를 직접 사용하는 경우는 거의 없으므로 일반적으로ApplicationContext 를 스프링 컨테이너라 한다.

### 스프링 컨테이너 생성 과정

#### 1. 스프링 컨테이너 생성

![img](https://user-images.githubusercontent.com/38436013/127949877-48ce8d8e-8a3c-4869-8843-160c7e0c591f.png)

- new AnnotationConfigApplicationContext(AppConfig.class)
- 스프링 컨테이너를 생성할 때는 구성 정보를 지정해주어야 한다.
- 여기서는 AppConfig.class 를 구성 정보로 지정했다.

#### 2. 스프링 빈 등록

![img](https://user-images.githubusercontent.com/38436013/127949926-41c5bbb7-5772-4a4b-8dea-d43570a59de0.png)

**빈 이름**

- 빈 이름은 메서드 이름을 사용한다.
- 빈 이름을 직접 부여할 수 도 있다.
  - @Bean(name="memberService2")

> 주의: **빈 이름은 항상 다른 이름을 부여**해야 한다. 같은 이름을 부여하면, 다른 빈이 무시되거나, 기존 빈을 덮어버리거나 설정에 따라 오류가 발생한다.

#### 3. 스프링 빈 의존관계 설정 - 준비

![img](https://user-images.githubusercontent.com/38436013/127949964-564b250a-858b-4d9c-864c-132fc3ad8a8e.png)

#### 4. 스프링 빈 의존관계 설정 - 완료

![img](https://user-images.githubusercontent.com/38436013/127949987-380ff9be-41e0-4096-a8a4-521fed5a15d1.png)

- `스프링 컨테이너는 설정 정보를 참고해서 의존관계를 주입(DI)한다`.
- 단순히 자바 코드를 호출하는 것 같지만, 차이가 있다. 이 차이는 뒤에 싱글톤 컨테이너에서 설명한다.

**참고**
스프링은 빈을 생성하고, 의존관계를 주입하는 단계가 나누어져 있다. 그런데 이렇게 자바 코드로 스프링 빈을 등록하면 생성자를 호출하면서 의존관계 주입도 한번에 처리된다. 여기서는 이해를 돕기 위해 개념적으로 나누어 설명했다. 자세한 내용은 의존관계 자동 주입에서 다시 설명하겠다.

**정리**
스프링 컨테이너를 생성하고, 설정(구성) 정보를 참고해서 스프링 빈도 등록하고, 의존관계도 설정했다. 이제 스프링 컨테이너에서 데이터를 조회해보자.

### 4.2 컨테이너에 등록된 모든 빈 조회

```java
import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = "+beanDefinitionName + "object = " + bean);
        }
    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name =  " + beanDefinitionName + " object = " + bean);
            }
        }
    }
}
```

- 모든 빈 출력하기
  - 실행하면 스프링에 등록된 모든 빈 정보를 출력할 수 있다.
  - ac.getBeanDefinitionNames() : 스프링에 등록된 모든 빈 이름을 조회한다.
  - ac.getBean() : 빈 이름으로 빈 객체(인스턴스)를 조회한다.
- 애플리케이션 빈 출력하기
  - 스프링이 내부에서 사용하는 빈은 제외하고, **내가 등록한 빈만 출력**
  - 스프링이 내부에서 사용하는 빈은 getRole() 로 구분할 수 있다.
    - ROLE_APPLICATION : 일반적으로 사용자가 정의한 빈
    - ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈

### 4.3 스프링 빈 조회 - 기본

스프링 컨테이너에서 스프링 빈을 찾는 가장 기본적인 조회 방법

- ac.getBean(빈이름, 타입)
- ac.getBean(타입)
- 조회 대상 스프링 빈이 없으면 예외 발생
  - NoSuchBeanDefinitionException: No bean named 'xxxxx' available

- 예제코드

```JAVA
package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean( MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회") // MemberService의 리턴이 MemberServiceImpl로 조회 가능
    void findBeanByName2() {
        MemberService memberService = ac.getBean( "memberService", MemberServiceImpl.class); 
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findBeanByNameX() {
        // -> 오른쪽 코드를 실행하면 ->의 왼쪽 예외가 발생해야하는 코드
//        MemberService xxxxx = ac.getBean("xxxxx", MemberService.class);
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", MemberService.class));
    }
}
```

참고: 구체 타입으로 조회하면 변경시 유연성이 떨어진다.

> 빈 이름 조회 결과
>
> ...
>
> 12:42:59.130 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'appConfig'
> 12:42:59.162 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'memberService'
> 12:42:59.242 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'MemberRepository'
> 12:42:59.249 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'orderService'
> 12:42:59.257 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'discountPolicy'

### 4.4 스프링 빈 조회 - 동일한 타입이 둘 이상

- 타입으로 조회시 같은 타입의 스프링 빈이 둘 이상이면 오류가 발생한다. 이때는 빈 이름을 지정하자.
- ac.getBeansOfType() 을 사용하면 해당 타입의 모든 빈을 조회할 수 있다.

```java
package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {


    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상이면 중복 오류")
    void findBeanByTypeDuplicate(){
        assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다.")
    void findBeanByName() {
        MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회")
    void findAllBeanType(){
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    // config 파일 새로 만듦
    @Configuration
    static class SameBeanConfig{

        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
```

### 4.5 스프링 빈 조회 - 상속 관계

부모 타입으로 조회하면, 자식 타입도 함께 조회한다. 그래서 모든 자바 객체의 최고 부모인 Object 타입으로 조회하면, 모든 스프링 빈을 조회한다

- 예제코드

```java
package hello.core.beanfind;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 중복 오류가 발생한다")
    void findBeanByParentTypeDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 빈 이름을 지정하면 된다다")
    void findBeanByParentTypeBeanName() {
        DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기")
    void findAllBeanByParentType() {
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        assertThat(beansOfType.size()).isEqualTo(2);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanBySubTree() {
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기 - Object") // 스프링 내부 빈까지 모두 조회
    void findAllBeanByObjectType() {
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
    }

    @Configuration
    static class TestConfig {
        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDisCountPolicy() {
            return new FixDiscountPolicy();
        }
    }
}
```

> /  부모 타입으로 조회하기 
>
> key = rateDiscountPolicy value = hello.core.discount.RateDiscountPolicy@4d18aa28
> key = fixDisCountPolicy value = hello.core.discount.FixDiscountPolicy@75390459

### 4.6 BeanFactory와 ApplicationContext

ApplicationContext는 BeanFactory로부터 상속 받은 인터페이스

#### 정리

- **ApplicationContext는 BeanFactory의 기능을 상속받는다.**
- ApplicationContext는 빈 관리기능 + 편리한 부가 기능을 제공한다.
- BeanFactory를 직접 사용할 일은 거의 없다. 부가기능이 포함된 ApplicationContext를 사용한다.
- **BeanFactory나 ApplicationContext를 스프링 컨테이너라 한다.**

### 4.7 다양한 설정 형식 지원

- 스프링 컨테이너는 다양한 형식의 설정 정보를 받아드릴 수 있게 유연하게 설계되어 있다.
- 자바 코드, XML, Groovy 등등

![img](https://user-images.githubusercontent.com/38436013/127959562-862e27af-2bcf-49b3-a7d9-ef6ba0742367.png)

#### 애노테이션 기반 자바 코드 설정 사용

- 지금까지 했던 것이다.
- new AnnotationConfigApplicationContext(AppConfig.class)
- AnnotationConfigApplicationContext 클래스를 사용하면서 자바 코드로된 설정 정보를 넘기면 된다.

#### XML 설정 사용

- 최근에는 스프링 부트를 많이 사용하면서 XML기반의 설정은 잘 사용하지 않는다. 아직 많은 레거시 프로젝트 들이 XML로 되어 있고, 또 XML을 사용하면 컴파일 없이 빈 설정 정보를 변경할 수 있는 장점도 있으므로 한번쯤 배워두는 것도 괜찮다.
- GenericXmlApplictionContext 를 사용하면서 xml 설정 파일을 넘기면 된다.

- XmlAppConfig 사용 자바 코드

```java
package hello.core.xml;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContext {

    @Test
    void xmlAppContext() {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
```

- xml 기반의 스프링 빈 설정 정보 : src/main/resources/appConfig.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="memberService" class="hello.core.member.MemberServiceImpl">
        <constructor-arg name="memberRepository" ref="memberRepository"/>
    </bean>

    <bean id="memberRepository"    class="hello.core.member.MemoryMemberRepository"/>

    <bean id="orderService" class="hello.core.order.OrderServiceImpl">
        <constructor-arg name="memberRepository" ref="memberRepository"/>
        <constructor-arg name="discountPolicy" ref="discountPolicy"/>
    </bean>

    <bean id="discountPolicy" class="hello.core.discount.RateDiscountPolicy"/>
</beans>
```

- xml 기반의 appConfig.xml 스프링 설정 정보와 자바 코드로 된 AppConfig.java 설정 정보를 비교해보면 거의 비슷하다는 것을 알 수 있다.

### 4.8 스프링 빈 설정 메타 정보 - BeanDefinition

스프링은 어떻게 이런 다양한 설정 형식을 지원하는 것일까? 그 중심에는 BeanDefinition 이라는 추상화가 있다.

- 쉽게 이야기해서 역할과 구현을 개념적으로 나눈 것이다!
  - XML을 읽어서 BeanDefinition을 만들면 된다.
  - 자바 코드를 읽어서 BeanDefinition을 만들면 된다.
  - 스프링 컨테이너는 자바 코드인지, XML인지 몰라도 된다. 오직 BeanDefinition만 알면 된다
- BeanDefinition 을 빈 설정 메타정보라 한다.
  - `@Bean` , `<bean>` 당 각각 하나씩 메타 정보가 생성된다.
- **스프링 컨테이너는 이 메타정보(BeanDefinition)를 기반으로 스프링 빈을 생성한다.**
- **스프링 컨테이너는 BeanDefinition 에만 의존**

![img](https://user-images.githubusercontent.com/38436013/127964591-6f3a2b69-64b5-4ca5-b447-f46a1dc38a87.png)

#### BeanDefinition 살펴보기

**BeanDefinition 정보**

- BeanClassName: 생성할 빈의 클래스 명(자바 설정 처럼 팩토리 역할의 빈을 사용하면 없음)
- factoryBeanName: 팩토리 역할의 빈을 사용할 경우 이름, 예) appConfig
- factoryMethodName: 빈을 생성할 팩토리 메서드 지정, 예) memberService
- Scope: 싱글톤(기본값)
- lazyInit: 스프링 컨테이너를 생성할 때 빈을 생성하는 것이 아니라, 실제 빈을 사용할 때 까지 최대한 생성을 지연처리 하는지 여부
- InitMethodName: 빈을 생성하고, 의존관계를 적용한 뒤에 호출되는 초기화 메서드 명
- DestroyMethodName: 빈의 생명주기가 끝나서 제거하기 직전에 호출되는 메서드 명
- Constructor arguments, Properties: 의존관계 주입에서 사용한다. (자바 설정 처럼 팩토리 역할의 빈을 사용하면 없음)

```java
package hello.core.beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + beanDefinitionName + " beanDefinition = " + beanDefinition);
            }
        }
    }
}
```

정리

BeanDefinition을 직접 생성해서 스프링 컨테이너에 등록할 수 도 있다. 하지만 실무에서 BeanDefinition을 직접 정의하거나 사용할 일은 거의 없다.

## 5. 싱글톤 컨테이너

### 5.1 웹 애플리케이션과 싱글톤

- 웹 애플리케이션은 보통 여러 고객이 동시에 요청을 한다.

![img](https://user-images.githubusercontent.com/38436013/127967886-68618115-0361-41b0-8c41-4a09d8e8f1f8.png)

> 요청의 개수 만큼 객체가 생성됨 -> 문제가 됨

- 스프링 없는 순수한 DI 컨테이너 테스트

~~~java
import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        // 1. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        // 2. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 다른 것을 확인
        System.out.println("memberService1 = "+ memberService1);
        System.out.println("memberService2 = "+ memberService2);

        //memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    }
}
// 여기서는 두개 객체를 생성한 것으로 보여지지만, 객체 인터페이스, 해당 구체 클래스 모두 생성되므로 총 4개가 생성된다.
~~~

- 우리가 만들었던 스프링 없는 순수한 DI 컨테이너인 AppConfig는 요청을 할 때 마다 객체를 새로 생성한다.

- 고객 트래픽이 초당 100이 나오면 초당 100개 객체가 생성되고 소멸된다 -> 메모리 낭비 심하다

- 해결방안은 **해당 객체가 1개만 생성되고, 공유하도록 설계**한다 -> `싱글톤 패턴`

### 5.2 싱글톤 패턴 

- 클래스의 **인스턴스가 딱 1개만 생성되는 것을 보장하는 디자인 패턴**이다.
- 그래서 객체 인스턴스를 2개 이상 생성하지 못하도록 막아야 한다.
  - 생성자를 private  사용해서 외부에서 임의로 new 키워드를 사용하지 못하도록 막아야 한다.

싱글톤 패턴을 적용한 예제 코드를 보자. main이 아닌 test 위치에 생성하자.

```java
package hello.core.singleton;

public class SingletonService {
	// 1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService  instance = new SingletonService();

     // 2. public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance(){
        return instance;
    }
    //3. 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다
    private SingletonService() {

    }
  
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
```

> 1. static 영역에 객체 instance를 미리 하나 생성해서 올려둔다.
> 2. 이 객체 인스턴스가 필요하면 오직 getInstance() 메서드를 통해서만 조회할 수 있다. 이 메서드를 호출하면 항상 같은 인스턴스를 반환한다.
> 3. 딱 1개의 객체 인스턴스만 존재해야 하므로, 생성자를 private으로 막아서 혹시라도 외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 막는다.

- 싱글톤 패턴을 사용하는 테스트 코드

```java
package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void singletonServiceTest() {
        //private으로 생성자를 막아두었다. 컴파일 오류가 발생한다.
        //new SingletonService();

        //1. 조회: 호출할 때 마다 같은 객체를 반환
        SingletonService singletonService1 = SingletonService.getInstance();

        //2. 조회: 호출할 때 마다 같은 객체를 반환
        SingletonService singletonService2 = SingletonService.getInstance();

        //참조값이 같은 것을 확인
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        // singletonService1 == singletonService2
        assertThat(singletonService1).isSameAs(singletonService2);
        singletonService1.logic();
    }
}
```

> singletonService1 = hello.core.singleton.SingletonService@327514f
> singletonService2 = hello.core.singleton.SingletonService@327514f
>
> 같은 객체를 참조하고 있음

- private으로 new 키워드를 막아두었다.
- 호출할 때 마다 같은 객체 인스턴스를 반환하는 것을 확인할 수 있다.

참고: 싱글톤 패턴을 구현하는 방법은 여러가지가 있다. 여기서는 `객체를 미리 생성해두는 가장 단순하고 안전한 방법`을 선택했다.

싱글톤 패턴을 적용하면 고객의 요청이 올 때 마다 객체를 생성하는 것이 아니라, `이미 만들어진 객체를 공유해서 효율적으로 사용`할 수 있다. 하지만 싱글톤 패턴은 다음과 같은 수 많은 문제점들을 가지고 있다.

#### 싱글톤 패턴 문제점

- 싱글톤 패턴을 구현하는 코드 자체가 많이 들어간다.
- 의존관계상 클라이언트가 구체 클래스에 의존한다. DIP를 위반한다.
- 클라이언트가 구체 클래스에 의존해서 OCP 원칙을 위반할 가능성이 높다.
- private 생성자로 자식 클래스를 만들기 어렵다.
- 결론적으로 유연성이 떨어진다.
- 안티패턴으로 불리기도 한다.

### 5.3 싱글톤 컨테이너

스프링 컨테이너는 **싱글톤 패턴의 문제점을 해결**하면서, **객체 인스턴스를 싱글톤(1개만 생성)으로 관리**한다.
지금까지 우리가 학습한 **스프링 빈이 바로 싱글톤으로 관리되는 빈**이다.

- 스프링 컨테이너는`싱글턴 패턴을 적용하지 않아도, 객체 인스턴스를 싱글톤으로 관리`한다.
- 스프링 컨테이너는 싱글톤 컨테이너 역할을 한다. 이렇게 싱글톤 객체를 생성하고 관리하는 기능을 **싱글톤 레지스트리**라 한다.
- 스프링 컨테이너의 이런 기능 덕분에 싱글톤 패턴의 모든 단점을 해결 & 객체를 싱글톤 관리
  - 싱글톤 패턴을 위한 지저분한 코드가 들어가지 않아도 된다.
  - DIP, OCP, 테스트, private 생성자로 부터 자유롭게 싱글톤을 사용할 수 있다.

- 스프링 컨테이너를 사용하는 테스트 코드

~~~java
import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 참조값이 같은 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 == memberService2
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }

}
~~~

##### 싱글톤 컨테이너 적용 후

- 스프링 컨테이너 덕분에 이미 만들어진 객체를 공유해서 효율적으로 재사용할 수 있다.

> 참고: 스프링의 기본 빈 등록 방식은 싱글톤이지만, 싱글톤 방식만 지원하는 것은 아니다. 요청할 때 마다 새로운 객체를 생성해서 반환하는 기능도 제공한다. 자세한 내용은 뒤에 빈 스코프에서 설명하겠다.

### 5.4 싱글톤 방식의 주의점

싱글톤 패턴이든, 스프링 같은 싱글톤 컨테이너를 사용하든,  `객체 인스턴스를 하나만 생성해서 공유하는 싱글톤 방식`은 `여러 클라이언트가 하나의 같은 객체 인스턴스를 공유`하기 때문에 **싱글톤 객체를 상태를 유지(stateful)하게 설계**하면 안된다.

- **무상태로 설계해야 한다!!**
  - 특정 클라이언트에 의존적인 필드가 있으면 안된다.
  - 특정 클라이언트가 값을 변경할 수 있는 필드가 있으면 안된다!
  - 가급적 읽기만 가능해야 한다.
  - 필드 대신에 자바에서 공유되지 않는, 지역변수, 파라미터, ThreadLocal 등을 사용해야 한다.

- 상태를 유지할 경우 발생하는 문제점 예시

~~~java
package hello.core.singleton;

public class StatefulService {
    private int price; // 상태를 유지하는 필드
    public void order(String name, int price){
        System.out.println("name = " + name + "price = " + price);
        this.price = price; // 여기가 문제

    }
    public int getPrice() {
        return price;
    }
}
~~~

~~~java
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    //  컨테이너 생성 ,  getBean() : 조회
    @Test
    void statefulServiceSingleton() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
    StatefulService statefulService1 = ac.getBean(StatefulService.class);
    StatefulService statefulService2 = ac.getBean(StatefulService.class);

    //ThreadA: A 사용자 10000원 주문
        statefulService1.order("userA", 10000);
    //ThreadB: B 사용자 20000원 주문
        statefulService2.order("userB", 20000);

    //ThreadA: 사용자A 주문 금액 조회
    int price = statefulService1.getPrice();
    //ThreadA: 사용자A는 10000원을 기대했지만, 20000원을 출력 -> 상태 유지 때문
        System.out.println("price = " + price);

    assertThat(statefulService1.getPrice()).isEqualTo(20000);
}

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
~~~

- `StatefulService` 의 price 필드는 공유되는 필드인데, 특정 클라이언트가 값을 변경한다.
- 사용자A의 주문금액은 10000원이 되어야 하는데, 20000원이라는 결과가 나왔다.
- 진짜 **공유필드는 조심해야 한다!** 스프링 빈은 항상 `무상태(stateless)로 설계`하자.

### 5.5 @Configuration과 싱글톤

- AppConfig

~~~java
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
   ...
}
~~~

- memberService 빈을 만드는 코드를 보면 memberRepository() 를 호출한다.
  - 이 메서드를 호출하면 new MemoryMemberRepository() 를 호출한다.
- orderService 빈을 만드는 코드도 동일하게 memberRepository() 를 호출한다.
  - 이 메서드를 호출하면 new MemoryMemberRepository() 를 호출한다.

결과적으로 각각 다른 2개의 MemoryMemberRepository 가 생성되면서 싱글톤이 깨지는 것 처럼 보인다. 스프링 컨테이너는 이 문제를 어떻게 해결할까?

- 검증 용도의 코드 추가

~~~java
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // ...
    
    // 테스트 용도 추가
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
~~~



~~~java
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository ;
    private final DiscountPolicy discountPolicy ;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 
    
    }
    //테스트 용도 추가
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
~~~



- 테스트 코드

~~~java
package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberRepository1 = " + memberRepository1);
        System.out.println("memberRepository2 = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }
}

~~~

> memberRepository1 = hello.core.member.MemoryMemberRepository@366c4480
> memberRepository2 = hello.core.member.MemoryMemberRepository@366c4480
> memberRepository = hello.core.member.MemoryMemberRepository@366c4480

- 확인해보면 memberRepository 인스턴스는 모두 같은 인스턴스가 공유되어 사용된다.

- AppConfig의 자바 코드를 보면 분명히 각각 2번 new MemoryMemberRepository 호출해서 다른 인스턴스가 생성되어야 하는데?

- 어떻게 된 일일까? 혹시 두 번 호출이 안되는 것일까?

  

- AppConfig에 호출 로그 남김

~~~java
@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
  
~~~

테스트 코드 실행 결과 : ConfigurationSingletonTest

> // 예상 호출 순서
> // call AppConfig.memberService
> // call AppConfig.memberRepository
> // call AppConfig.memberRepository
> // call AppConfig.orderService
> // call AppConfig.memberRepository
>
> // 실제 호출 순서
> // call AppConfig.memberService
> // call AppConfig.memberRepository
> // call AppConfig.orderService

- 예상과 다르게 스프링 컨테이너는 모두 1번 호출해준다
- why?

### 5.6 Configuration과 바이트코드 조작의 마법

스프링 컨테이너는 싱글톤 레지스트리다. 스프링은 싱글톤을 보장해주기 위해 **클래스의 바이트코드를 조작하는 라이브러리를 사용**한다. 

모든 비밀은 `@Configuration 을 적용한 AppConfig` 에 있다.

다음 코드를 보자.

```java
    @Test
    void configurationDeep() {
        //AppConfig도 스프링 빈으로 등록된다
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        //출력: bean = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$bd479d70

        System.out.println("bean = " + bean.getClass());
    }
```

- 사실 AnnotationConfigApplicationContext 에 파라미터로 넘긴 값은 스프링 빈으로 등록된다. 그래서 AppConfig 도 스프링 빈이 된다.
- AppConfig 스프링 빈을 조회해서 클래스 정보를 출력해보자.

> bean = class hello.core.AppConfig*E**n**h**a**n**c**e**r**B**y**S**p**r**i**n**g**C**G**L**I**B*bd479d70

'*n**h**a**n**c**e**r**B**y**S**p**r**i**n**g**C**G**L**I**B*bd479d70' 이것은 스프링이 CGLIB라는 바이트코드 조작 라이브러리를 사용해서 AppConfig 클래스를 상속받은 임의의 다른 클래스다. 임의의 다른 클래스를 스프링 빈으로 등록한 것이다.

> 임의의 클래스가 싱글톤이 보장되도록 해준다.

#### AppConfig@CGLIB 예상 코드

```java
@Bean
public MemberRepository memberRepository() {
    if (memoryMemberRepository가 이미 스프링 컨테이너에 등록되어 있으면?){
        return 스프링 컨테이너에서 찾아서 반환;
    } else { //스프링 컨테이너에 없으면
        기존 로직을 호출해서 MemoryMemberRepository를 생성하고 스프링 컨테이너에 등록
        return 반환
    }
}
```

- **@Bean이 붙은 붙은 메서드마다 스프링 빈이 존재하면, 빈 반환하고, 없으면 생성하고 빈으로 등록하여 반환해준다.**
- @Configuration 을 적용하지 않고, @Bean 만 적용하면 어떻게 될까?
  - @Configuration 을 붙이면 바이트코드를 조작하는 CGLIB 기술을 사용해서 싱글톤을 보장하지만, @Bean은 스프링 빈으로 등록만 해주고, 싱글톤 보장하지 않는다.
  - **결론은 스프링설정정보는 항상 @Configuration 사용해야 한다.**

## 6. 컴포넌트 스캔

### 6.1 컴포넌트 스캔과 의존관계 자동 주입 시작하기

- 실무에서 등록해야 할 빈이 많다. -> 스프링은 설정 정보가 없어도 자동으로 빈 등록하는 컴포넌트 스캔이라는 기능을 제공
- 의존 관계도 자동으로 주입하는 @Autowired라는 기능도 제공

컴포넌트 스캔과 의존관계 자동 주입해보자!!

기존 AppConfig.java는 과거 코드와 테스트를 유지하기 위해 남겨두고, 새로운 AutoAppConfig.java를 만들자.

- AutoAppConfig.java

```java
package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // 이전 실습에서 등록한 Configuration 어노테이션 붙은 설정 정보 제외
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
```

- 컴포넌트 스캔을 사용하려면 먼저 @ComponentScan 을 설정 정보에 붙여주면 된다.
- 기존의 AppConfig와는 다르게 @Bean으로 등록한 클래스가 하나도 없다!

> 컴포넌트 스캔을 사용하면 @Configuration 이 붙은 설정 정보도 자동으로 등록되기 때문에, AppConfig, TestConfig 등 앞서 만들어두었던 설정 정보도 함께 등록되고, 실행되어 버린다. 그래서 excludeFilters 를 이용해서 설정정보는 컴포넌트 스캔 대상에서 제외했다. 보통 설정 정보를 컴포넌트 스캔 대상에서 제외하지는 않지만, 기존 예제 코드를 최대한 남기고 유지하기 위해서 이 방법을 선택했다.

`컴포넌트 스캔`은 **이름 그대로 @Component 애노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록**한다. @Component 를 붙여주자.

- MemoryMemberRepository @Component 추가

```java
@Component
public class MemoryMemberRepository implements MemberRepository {}
```

- RateDiscountPolicy @Component 추가

```java
@Component
public class RateDiscountPolicy implements DiscountPolicy {}
```

- MemberServiceImpl @Component, @Autowired 추가

```java
@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    
    @Autowired // 자동 생성 의존 관계 주입을 생성자에 붙이기
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
}
```

- 이전에 AppConfig에서는 @Bean으로 직접 설정 정보를 작성했고, 의존 관계도 직접 명시했다. 이제는 **이런 설정 정보 자체가 없기 때문에 의존관계 주입도 이 클래스 안에서 해결해야 한다.**
- `@Autowired는 의존 관계를 자동으로 주입`해준다. 

- OrderServiceImpl @Component, @Autowired 추가

```java
@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository ;
    private final DiscountPolicy discountPolicy ;
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
}
```

`@Autowired 를 사용하면 생성자에서 여러 의존관계도 한번에 주입`받을 수 있다.

- AutoAppConfigTest.java

```java
package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {
    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class); // 객체 타입 확인
    }
}
```

- AnnotationConfigApplicationContext 컨테이너 객체 생성해주고, 설정 정보로 AutoAppConfig 클래스 넘겨준다.
- 로그를 보자. 컴포넌트 스캔이 잘 동작하는 것을 확인할 수 있다.

> ClassPathBeanDefinitionScanner - Identified candidate component class:
> .. RateDiscountPolicy.class
> .. MemberServiceImpl.class
> .. MemoryMemberRepository.class
> .. OrderServiceImpl.class

#### 1. @ComponentScan

![img](https://user-images.githubusercontent.com/38436013/128150845-64358afb-c6d2-43fa-9f22-6f91812a6b20.png)

- **@ComponentScan 은 @Component 가 붙은 모든 클래스를 스프링 빈으로 등록**한다.
- 이때 스프링 빈의 기본 이름은 클래스명을 사용하되 맨 앞글자만 소문자를 사용한다.
  \- **빈 이름 기본 전략**: MemberServiceImpl 클래스 memberServiceImpl
  \- **빈 이름 직접 지정**: 만약 스프링 빈의 이름을 직접 지정하고 싶으면
  @Component("memberService2") 이런식으로 이름을 부여하면 된다.

#### 2. Autowired 의존관계 자동 주입

![img](https://user-images.githubusercontent.com/38436013/128150876-f60c2122-1a86-40a0-967b-af3dc2a8b30e.png)

- 생성자에 @Autowired 를 지정하면, 스프링 컨테이너가 자동으로 해당 스프링 빈을 찾아서 주입한다.
- 이때 기본 조회 전략은 타입이 같은 빈을 찾아서 주입한다. (상속관계는 타입이 같다.)
  - getBean(MemberRepository.class) 와 동일하다고 이해하면 된다.
  - 컨테이너에 있는 MemberRepository를 타입으로 조회하여 같은 타입의 인스턴스(MemoMemberRepository)를 꺼낸다.

### 6.2 탐색 위치와 기본 스캔 대상

#### 탐색할 패키지의 시작 위치 지정

모든 자바 클래스를 다 컴포넌트 스캔하면 시간이 오래 걸린다. 그래서 꼭 필요한 위치부터 탐색하도록 시작 위치를 지정할 수 있다.

```java
@Configuration
@ComponentScan(
    basePackages = "hello.core",
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
```

- basePackages : 탐색할 패키지의 시작 위치를 지정한다. 이 패키지를 포함해서 하위 패키지를 모두 탐색한다.
  - basePackages = {"hello.core", "hello.service"} 이렇게 여러 시작 위치를 지정할 수도 있다.
- 만약 지정하지 않으면 @ComponentScan 이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.

#### 권장하는 방법

패키지 위치를 지정하지 않고, 설정 정보 클래스의 위치를 프로젝트 최상단에 두는 것이다.

프로젝트가 다음과 같이 구조가 되어 있으면

com.hello
com.hello.serivce
com.hello.repository

이렇게 하면 com.hello 를 포함한 하위는 모두 자동으로 컴포넌트 스캔의 대상이 된다.

스프링 부트를 사용하면 스프링 부트의 대표 시작 정보인@SpringBootApplication 를 이 프로젝트 시작 루트 위치에 두는 것이 관례이다. (그리고 이 설정안에 바로 @ComponentScan 이 들어있다!)

#### 컴포넌트 스캔 기본 대상

- 컴포넌트 스캔은 `@Component`뿐만 아니라 다음 내용도 추가로 대상에 포함한다.
  - `@Component` : 컴포넌트 스캔에서 사용
  - `@Controlller` : 스프링 MVC 컨트롤러에서 사용
  - `@Service` : 스프링 비즈니스 로직에서 사용
  - `@Repository` : 스프링 데이터 접근 계층에서 사용
  - `@Configuration` : 스프링 설정 정보에서 사용

해당 클래스의 소스 코드를 보면 @Component 를 포함하고 있는 것을 알 수 있다.

> 참고: 사실 애노테이션에는 상속관계라는 것이 없다. 그래서 이렇게 애노테이션이 특정 애노테이션을 들고있는 것을 인식할 수 있는 것은 스프링이 지원하는 기능이다.

컴포넌트 스캔의 용도 뿐만 아니라 다음 애노테이션이 있으면 스프링은 `부가 기능`을 수행한다.

> - @Controller : 스프링 MVC 컨트롤러로 인식
> - @Repository : 스프링 데이터 접근 계층으로 인식하고, 데이터 계층의 예외를 스프링 예외로 변환해준다.
> - @Configuration : 앞서 보았듯이 스프링 설정 정보로 인식하고, 스프링 빈이 싱글톤을 유지하도록 추가 처리를 한다.
> - @Service : 사실 @Service 는 특별한 처리를 하지 않는다. 대신 개발자들이 핵심 비즈니스 로직이 여기에 있겠구나 라고 비즈니스 계층을 인식하는데 도움이 된다.

### 6.3 필터

- includeFilters : 컴포넌트 스캔 대상을 추가로 지정한다.
- excludeFilters : 컴포넌트 스캔에서 제외할 대상을 지정한다.

모든 코드는 테스트 코드에 추가

- 컴포넌트 스캔 대상에 추가할 애노테이션

```java
package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {

}
```

- 컴포넌트 스캔 대상에서 제외할 애노테이션

```java
package hello.core.scan.filter;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {

}
```

- 컴포넌트 스캔 대상에 추가할 클래스

```java
package hello.core.scan.filter;

@MyIncludeComponent
public class BeanA {

}
```

- 컴포넌트 스캔 대상에서 제외할 클래스

```java
package hello.core.scan.filter;

@MyExcludeComponent
public class BeanB {

}
```

- 설정 정보와 전체 테스트 코드

```java
package hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ComponentFilterAppConfigTest {
    @Test
    void filterScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA;
        beanA = ac.getBean("beanA", BeanA.class);
        Assertions.assertThat(beanA).isNotNull();

//        ac.getBean("beanB", BeanB.class);
        assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> ac.getBean("beanB", BeanB.class)
        );
    }

    @Configuration
    @ComponentScan(
            includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
    )

    static class ComponentFilterAppConfig {

    }
}
```

- includeFilters 에 MyIncludeComponent 애노테이션을 추가해서 BeanA가 스프링 빈에 등록된다.
- excludeFilters 에 MyExcludeComponent 애노테이션을 추가해서 BeanB는 스프링 빈에 등록되지 않는다.

#### FilterType 옵션

FilterType은 5가지 옵션이 있다.

- ANNOTATION: 기본값, 애노테이션을 인식해서 동작한다.
  - ex) org.example.SomeAnnotation
- ASSIGNABLE_TYPE: 지정한 타입과 자식 타입을 인식해서 동작한다.
  - ex) org.example.SomeClass
- ASPECTJ: AspectJ 패턴 사용
  - ex) org.example..*Service+
- REGEX: 정규 표현식
  - ex) org.example.Default.*
- CUSTOM: TypeFilter 이라는 인터페이스를 구현해서 처리
  - ex) org.example.MyTypeFilter

예를 들어서 BeanA도 빼고 싶으면 다음과 같이 추가하면 된다.

```java
@ComponentScan(
    includeFilters = {
        @Filter(type = FilterType.ANNOTATION, classes =
        MyIncludeComponent.class),
    },
    excludeFilters = {
        @Filter(type = FilterType.ANNOTATION, classes =
        MyExcludeComponent.class),
        @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = BeanA.class)
    }
)
```

> @Component 면 충분하기 때문에, includeFilters 를 사용할 일은 거의 없다. excludeFilters는 여러가지 이유로 간혹 사용할 때가 있지만 많지는 않다.

### 6.4 중복 등록과 충돌

컴포넌트 스캔에서 같은 빈 이름을 등록하면 어떻게 될까?

#### 자동 빈 등록 vs 자동 빈 등록

- 컴포넌트 스캔에 의해 자동으로 스프링 빈이 등록되는데, 그 이름이 같은 경우 스프링은 오류를 발생시킨다.
  - `ConflictingBeanDefinitionException` 예외 발생

#### 수동 빈 등록 vs 자동 빈 등록

만약 수동 빈 등록과 자동 빈 등록에서 빈 이름이 충돌되면 어떻게 될까?

```null
@Component
public class MemoryMemberRepository implements MemberRepository {}
@Configuration
@ComponentScan(
    excludeFilters = @Filter(type = FilterType.ANNOTATION, classes =
Configuration.class)
)
public class AutoAppConfig {
    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
```

이 경우 수동 빈 등록이 우선권을 가진다.
(수동 빈이 자동 빈을 오버라이딩 해버린다.)

#### 수동 빈 등록시 남는 로그

> Overriding bean definition for bean 'memoryMemberRepository' with a different definition: replacing

수동 빈 설정이 꼬이면 잡기 어려운 버그가 만들어진다. 최근 스프링 부트에서는 수동 빈 등록과 자동 빈 등록이 충돌나면 오류가 발생하도록 기본 값을 바꾸었다.

#### 수동 빈 등록, 자동 빈 등록 오류시 스프링 부트 에러

> Consider renaming one of the beans or enabling overriding by setting
> spring.main.allow-bean-definition-overriding=true

스프링 부트인 CoreApplication 을 실행해보면 오류를 볼 수 있다.



## 질문

- ch2. join하지 않는 이유

- ch3 . % final 붙으면 기본으로 생성자 만든다????

- ch 4. appConfig 중복이라는 개념 혼동