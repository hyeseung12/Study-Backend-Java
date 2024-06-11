# 와탭랩스 백엔드 과제

---

## Swagger API 명세서

API 명세서는 Swagger로 작성되어 있습니다.<br>
프로젝트 실행 후, 아래의 링크에 접속해서 API를 테스트할 수 있습니다.<br>
http://localhost:8080/swagger-ui/

## 프로젝트 폴더 구조

    폴더 구조 작성 cmd 명령어 : 'tree > level.txt' 

```
├─src
│  ├─main
│  │  ├─java
│  │  │  └─io
│  │  │      └─whatap
│  │  │          └─whatap
│  │  │              ├─domain
│  │  │              │  ├─order
│  │  │              │  │  ├─dto
│  │  │              │  │  ├─exception
│  │  │              │  │  ├─repository
│  │  │              │  │  └─service
│  │  │              │  └─product
│  │  │              │      ├─dto
│  │  │              │      ├─exception
│  │  │              │      ├─repository
│  │  │              │      └─service
│  │  │              └─global
│  │  │                  ├─config
│  │  │                  └─exception
│  │  │                      └─error
```

## 런타임 구동

아래 링크에 들어가 내용을 참고하고 프로젝트를 실행시킬 수 있습니다.
[자세한 내용 참고](https://foregoing-session-2ae.notion.site/a57d70130bd34b31ae953094673bec1a?pvs=4)

Environment variables는 다음과 같습니다.

    DB_HOST=;DB_NAME=;DB_PASSWORD=;DB_PORT=;DB_USERNAME=;DDL_AUTO=;REDIS_HOST=;REDIS_PORT=;

## Commit Convention
| value | meaning |
| -- | -- |
| feat | 새로운 기능 추가 시 |
| add | 새로운 클래스 추가 시 |
| docs | 문서 변경 사항 추가 시 |
| fix | 수정 사항 추가 시 |
| refactor | 코드 품질 개선 시 |
| test | 테스트 관련 사항|

## 프로젝트 코드 설명

1. **Entity**
   1. Entity와 DTO는 분리하는 [이유](https://hstory0208.tistory.com/entry/SpirngJPA-Dto%EC%99%80-Entity%EB%A5%BC-%EB%B6%84%EB%A6%AC%ED%95%B4%EC%84%9C-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94-%EC%9D%B4%EC%9C%A0)
      1. 사용자가 필요한 데이터만 DTO에 전달하기
      2. JSON 직렬화 이슈 해결
      3. 민감한 정보는 노출되지 않는 보안성 강화
      
      -> Entity와 DTO 간 변환 메서드 구현하기 (toEntity() <-> toDto())<br><br>
      
   2. Entity로 선언된 클래스는 모든 필드를 컬럼으로 취급
      
      -> @Column(name=)은 클래스의 필드명과 데이터베이스의 필드명이 다를 경우에 사용하기<br><br>
      
   3. 생성자와 getter, setter 어노테이션 -> Lombok 이용하기
      1. 생성자
         - 파라미터가 없는 생성자 : @NoArgsConstructor<br>
           단, 접근 제어자는 PROTECTED로 하는 [이유](https://erjuer.tistory.com/106)<br>
           -> (즉시 로딩 제외) 자연 로딩(LAZY) 인 경우 실제 엔티티가 아닌 프록시 객체를 통해서 조회
           - private인 경우 : 프록시 객체 생성에 접근 불가능
           - public인 경우 : 무분별한 객체 생성 초래 + setter로 통한 값 주입 -> 값 변경 추적 어려움<br><br>
         - 모든 파라미터가 있는 생성자
           1. @AllArgsConstructor [문제점](https://velog.io/@joona95/RequiredArgsConstructor-AllArgsConstructor-%EC%82%AC%EC%9A%A9%EC%9D%80-%EC%A7%80%EC%96%91%ED%95%98%EC%9E%90)
           2. Builder 패턴 [은 무엇이고 사용하는 이유](https://velog.io/@rara_kim/Spring-Builder-%ED%8C%A8%ED%84%B4%EC%9D%80-%EC%99%9C-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94-%EA%B2%83%EC%9D%BC%EA%B9%8C)
           
           -> '첫번째 < 두번째'<br><br>

   4. PK 매핑 전략 [자세한 내용](https://fourjae.tistory.com/entry/Spring-boot-JPA-%EA%B8%B0%EB%B3%B8-%ED%82%A4-%EC%83%9D%EC%84%B1-%EC%A0%84%EB%9E%B5AUTO-IDENTITY-SEQUENCE-TABLE-UUID)
      1. AUTO : 데이터베이스에 맞는 자동 키 생성. (ex. MySQL : AUTO_INCREMENT)
      2. IDENTIFIED : insert 시 자동으로 id 키 값 증가
      3. SEQUENCE : 시퀀스를 이용하여 기본 키 생성
      4. UUID : UUID를 이용하여 기본 키 생성<br><br>

   5. BaseTimeEntity : 등록 날짜, 수정 날짜
      1. @MappedSuperclass : 상속할 경우, 해당 클래스의 필드도 컬럼으로 취급
      2. @EntityListeners(AuditingEntityListener.class) : 엔티티 생성 또는 수정 시간 등을 파악해서 자동 저장
         1. @CreatedDate : 엔티티가 생성되는 시간 자동 저장
         2. @LastModifiedDate : 엔티티가 수정될 때마다 시간 자동 저장<br><br>
         
2. **Repository**
   1. @Repository 생략
      
    - @Service, @RestController 등 각 계층마다 어노테이션이 있는 것을 확인할 수 있음.
    - @Repository는 생략 가능한 이유
      1. 기본적으로 @Repository를 생략하면 빈으로 등록되지 않음
      2. 하지만, JpaRepository를 상속받을 경우 의존성 주입 가능한 [이유](https://sudo-minz.tistory.com/147)
      3. @NoRepositoryBean : 실제 구현체는 SimpleJpaRepository = @Repository
         ![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbFSyXf%2FbtrNvMuDKpz%2Fn6vjtmXTmhJwJk9h51ihv1%2Fimg.png)<br><br>