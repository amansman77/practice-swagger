# Swagger 활용

## 목표
Swagger를 활용하여 API목록을 제공한다.

## 개발 프레임워크
 - IDE : STS-4.2.2.RELEASE
 - Java : openjdk 12.0.1
 - Spring Boot : 2.1.7
 - Gradle : 5.6
 - Swagger : 2.9.2
 
## 도입 과정
 - 라이브러리 추가 : io.springfox
 - SwaggerConfig 설정
 - Swagger API 활용
 
## 확인 기능
 - API의 명세의 표현가능 범위
 	- URI
 	- 필수 파라메타 여부
 	- 컨트롤러 설명
 		- deprecate됨, 기능은 사용 가능 
 	- 파라메타 설명
 		- Param
 		- Entity
 	- 헤더
 	- Deprecate
 - 공유하고하자는 API만 구성 가능한가
 	- 패키지, 클래스, 메소드를 활용한 구분 가능
 	- URI를 활용한 구분 가능
 	
## 특이사항
 - 웹 페이지로 RestAPI의 인터페이스 명세를 제공
 - RestAPI의 테스트도 웹 페이지로 가능
 - 클라이언트에 알리고자하는 내용들을 Annotation으로 기록해야함

## 참고 문헌
 - Swagger site : https://swagger.io/
 - Springfox site : https://springfox.github.io/springfox/docs/current/#getting-started
 - Baeldung blog : https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api