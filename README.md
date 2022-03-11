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

## 질문

- ch2. join하지 않는 이유

- ch3 . % final 붙으면 기본으로 생성자 만든다????

- ch 4. appConfig 중복이라는 개념 혼동