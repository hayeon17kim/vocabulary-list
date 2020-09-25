# 📚 vocabulary-list ✍

- 팀원: 박민섭, 최희진, 김하연
- 목적: 마틴 파울러의 리팩토링 책을 읽으면서 배운 기법을 미니 프로젝트에 적용하고 실습한다.
- 주제: 단어장 프로그램

## 일지

### 2020-09-22
#### 필요 기능 논의
  - 리스트에 있는 단어 모두 띄우는 기능 
	- 시험 보기 기능 
    		- 리스트에 있는 단어를 순서 랜덤으로 영어 / 한국어 한쪽만 띄워서 
		- 맞추면 "맞았습니다" & 다음 단어 띄우기
        		- 틀리면 "틀렸습니다" & 해당 단어 "못맞춘 단어"리스트에 추가 & 다음 단어 띄우기 
		- 중간에 시험을 그만 보고 싶으면 "q" 입력
	- 단어 북마크 기능
	- 간단한 로그인 기능

#### 클래스 구조 틀 잡기
  - class Member
  	- `List<Vocabulary> vocaList`
	- `List<Vocabulary> bookmarkedvocaList`
	- void addVoca()
	- void listVoca()
	- void updateVoca()
	- void deleteVoca()
	- void quiz()
	- void bookmarkVoca()
    
- class MemberHandler
	- Member findById()
	- Member logIn()
	- void add()
	- class Vocabulary
	- String word
	- String meaning
	- String exSentence
	- int level
	- boolean isMemorized
	- Vocabulary()
	- Vocabulary(String word, String meaning)

 - class Prompt
	- Scanner keyboardScan
	- String inputString(String title)
	- String inputInt(String title)
	- String inputDate(String title)
	- void close()

- class App
	- main()

#### 기능구현
- `MemberHandler`의 `findById()`, `add()`, `logIn()` 메서드를 구현하였다.

#### 느낀점
- MemberHandler는 회원관리를 위해서 필요하다고 느꼈지만 VocaHandler는 아직까지 회원 당 하나의 단어장만을 갖는 상태이니 굳이 필요하지 않다고 느꼈다. 만약 어플에서 저장되는 전체 단어장이 필요하거나 회원 당 여러개의 단어장을 갖게 되면 그때쯤에 만들어도 될 것 같다.
- 세 명이서 화상회의를 하는 것은 처음이다보니 소통에 미흡한 점이 많았다. 서로의 화면을 전부 볼 수 없는 만큼 의사를 구체적으로 전달해야 할 필요성을 느꼈다.

--------------------------

### 2020-09-23

#### 추가한 코드

* Member 

  * void addVoca() 
* void listVoca()
  
  * findByWord() 
* MemberHandler  
  
  * Member logIn()
* Vocabulary
  * stringToPart()
  * partToString()
  * part 품사 상수 필드 추가 : VERB, NOUN, ADVERB, ADJECTIVE

#### 구현중인 메서드

update() 

#### 느낀점

* Member클래스에서 하는 일이 너무 많아지고 있어서 기능분리의 필요성을 깨달았다.
* 스태틱 메서드와 인스턴스 메서드를 어떤 때에 선언해야 하는지 어려움을 느꼈다.



___

### 2020-09-24

#### 변경 사항

- VocaHandler 클래스 정의
  - add(), list() : Member에 있던 addVoca(), addVoca() 이동
  - add() 메서드 수정 : 무효한 품사 입력할 경우, 다시 입력받기
  - update(), delete(), bookmark(), cancelBookmark() 추가
- Member 클래스
  - bookmarkList 필드 삭제
  - setVocaList() 메서드 몸체에서 setVocaHandler() 호출
  - 기본 단어 리스트 추가
- Vocanulary 클래스
  - isMemorized -> bookmark 이름 변경

#### 개선점

- 단어조회할 때 조회되는 단어 가독성 높이기
- 파일 입출력 기능 구현
- 퀴즈 메서드 실감나는 서비스 구현(스레드 슬립, 아스키아트 등등)
- MemberHandler 에서 list() update() delete() 메서드 구현

#### 느낀점

- 프로그램이 무미건조한 CRUD 서비스의 상태에 머물러있다. 좀더 화려하고 역동적으로 꾸며볼 필요가 있다.



---------

### 2020-09-25

#### 변경 사항

- Vocabulary 기본 데이터 추가
- Vocabulary 생성자 초기화값 지정

#### 추가한 코드

- MemberHandler: list(), update(), delete()
- VocaHandler: list() 메서드 수정 (가독성)
  - 품사, 난이도, 예제 값이 없을 경우 출력이 되지 않도록 설정 
- App: Gson 라이브러리를 사용하여 Json 파일 입출력 기능 구현
  - saveObjects(), loadObjects() 메서드 추가

#### 느낀점

- 적절한 외부 라이브러리의 사용은 코드 작성의 효율성을 높여준다는 것을 실감했다.

#### 개선점

- VocaHandler.list() 메서드에서 북마크된 단어를 어떻게 출력할 지 정해야 한다. 
- Member.quiz() 메서드 구현 필요