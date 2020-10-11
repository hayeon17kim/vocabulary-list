# 📚 vocabulary-list ✍

- 팀원: 박민섭, 최희진, 김하연
- 목적: 마틴 파울러의 리팩토링 책을 읽으면서 배운 기법을 미니 프로젝트에 적용하고 실습한다.
- 주제: 단어장 프로그램

---

## 일지
- [1일차 (2020-09-22)](https://github.com/hayeon17kim/vocabulary-list#2020-09-22)
- [2일차 (2020-09-23)](https://github.com/hayeon17kim/vocabulary-list#2020-09-23)
- [3일차 (2020-09-24)](https://github.com/hayeon17kim/vocabulary-list#2020-09-24)
- [4일차 (2020-09-25)](https://github.com/hayeon17kim/vocabulary-list#2020-09-25)
- [5일차 (2020-09-26)](https://github.com/hayeon17kim/vocabulary-list#2020-09-26)
- [6일차 (2020-09-27)](https://github.com/hayeon17kim/vocabulary-list#2020-09-27)
- [7일차 (2020-09-28)](https://github.com/hayeon17kim/vocabulary-list#2020-09-28)
- [8일차 (2020-09-29)](https://github.com/hayeon17kim/vocabulary-list#2020-09-29)

------

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

___

### 2020-09-26

#### 변경사항

- Members.json 파일 수정

#### 추가한 코드

- VocaHandler의 quiz 메서드 구현
- 각 회원이 갖는 단어장을 여러개 관리할 수 있도록 단어장 HashMap을 생성

#### 느낀점

- Random 클래스를 처음 사용해봤는데, 생각보다 편리했다.
- vocaHandler에 대한 캡슐화의 필요성을 느꼈다.
- 단어장 리스트를 관리할 때, HashMap을 적용한 것은 적절했던 것 같다.다만, HashMap에 익숙해질 필요가 있음을 느꼈다.

#### 개선점

- 여러개의 단어장에 대한 VocaHandler 객체 관리 방식에 대한 아이디어
  - 메서드에서 필요할 때마다 로컬 변수로 그때 그때 생성
  - ArrayList를 상속받는 새로운 클래스 vocaList를 정의하고, VocaHandler가 갖고 있는 기능을 재사용한다.
    - VocaHandler를 패키지 멤버 클래스로 두는 방법
    - VocaHandler를 vocaList의 이너 클래스로 두는 방법

----------

### 2020-09-27

#### 변경사항
- 패키지 정리
  - **util**: Prompt, VocaList
  - **handler**: VocaHandler, MemberHandler
  - **domain**: Member, Vocabulary

#### 추가한 코드
- VocaList
  - ArrayList를 상속받는 `VocaList<T>` 클래스를 정의하였다.
  - Serializable 인터페이스를 구현하도록 하고, serialVersionUID를 1L로 설정하였다. 
  - 기존의 VocaHandler를 VocaList의 inner class로 정의하였다.
  - VocaHandler vocaHandler 필드를 정의하였다.
  - addVoca(), listVoca(), updateVoca(), deleteVoca(), bookmarkVoca(), cancleBookmarkVoca(), quiz()를 추가하였다.
    - 각 메서드 내부에서 vocaHandler의 메서드를 호출하도록 정의하였다.

- Member
  - Serializable 인터페이스를 구현하도록 하고, serialVersionUID를 1L로 설정하였다. 
- Member
  - createVocaList()
  - findVocaList()


#### 느낀점

- 현재 VocaList를 ArrayList를 상속받도록 해서 제네릭 타입을 선언해야 하는데, 사실 지금의 VocaList는 Vocabulary 객체만을 다루고 있어서 의미가 없다. 따라서 다음과 같은 방법을 생각해 보았다.
  - `VocaList <T extends Vocabulary>`로 제네릭 타입 선언
  - `Vocabulary` 객체의 메서드를 사용할 때마다 형변환
  - `VocaList extends ArrayList<Vocabulary>`  :white_check_mark:
- VocaList 클래스 선언부에 도메인 클래스인 Vocabulary를 타입 파라미터로 선언하고, 클래스 내부에서 Vobulary 객체를 생성하려고 시도하였다. 그러나 컴파일러는 이 Vocabulary를 단순한 타입 파라미터명으로 인식하였기 때문에, 타입 파라미터로 인스턴스를 생성하는 코드에서 `cannot instantiate`  컴파일 오류가 발생하였다.
- List의 iterator() 메서드가 Iterator 객체를 리턴하는 것처럼, 객체를 외부에서 리턴받아서 직접 사용하는 방식이 있었고, VocaList에서만 VocaHandler를 사용하는 방법이 있었는데, 우리는 후자의 방법을 선택해서 VocaHandler에 있는 모든 메서드에 대응되는 메서드를 VocaList에 정의해줬다. 그리고 외부에서 이 VocaList의 새 메서드를 가지고 호출하면 VocaHandler가 내부적으로 사용되도록 하였다. 

---

### 2020-09-28

#### 변경사항

- VocaList 클래스의 타입 파라미터 삭제 
  - `VocaList extends ArrayList<Vocabulary>`로 변경
- Member에서 VocaHandler의 메서드를 호출하던 것을 VocaList의 메서드를 호출하도록 변경

#### 추가한 코드

- 현재 선택한 단어장 객체를 담는 currentVocaList라는 필드를 추가하였다.
- VocaList에 대한 CRUD 메서드를 추가하였다.
- currentVocaList가 지정되어 있는 상태와 지정되어 있지 않은 상태를 분리하도록 boolean 타입의 isEmpty 로컬 변수를 main 메서드에 만들어 주었다.

#### 개선점

- main 메서드의 반복문과 switch 문을 메서드로 추출할 필요가 있다.
- 커맨드 디자인 패턴을 적용하여 App의 메인 메서드에서 호출하고 있는 메서드를 클래스로 분리해야 한다.
- VocaHandler를 Vocabulary의 중첩 클래스로 만들어준 것처럼 MemberHandler도 Member의 중첩클래스로 정의할 필요가 있다.

#### 느낀점
- VocaHandler를 VocaList에 넣는 작업을 완수해서 뿌듯하다. 이로 인해 코드가 한층 깔끔해 진 것 같다.
- 메서드가 너무 많아서 어떤 메서드가 있는지 잘 파악하지 못하고 있다. 메서드를 정리할 필요가 있다.

___

### 2020-09-28

#### 변경사항

- App 
  - 단어장이 선택된 상태의 기능들을 단어장 관리 기능 스위치문 중, case "단어장 선택" 안으로 삽입했다.  
  - 사용자가 이용할 수 있는 기능 중에 몇가지 부족한 것들 보충했다. (로그아웃, 종료)
  - 세 가지 종류의 while문에 mainLoop, loggedLoop, vocaListLoop라는 라벨을 달아, 자연스럽게 특정 while문을 나갈 수 있도록 하여, App 실행 중 발생할 수 있는 예외를 처리했다.

#### 개선점

- Member 클래스의 currentVocaList와 App 클래스의 isEmpty가 비슷한 역할인데 서로 분리되어있다. 하나로 통일을 시켜서 App에서 currentVocaList의 상태(비어있음 / 특정됨)를 곧바로 알 수 있는 방법을 취해야 한다.

#### 느낀점

- 이 프로젝트의 목표는 리팩토링 책에 대한 이해를 위해 실습할 토대였는데, 어쩌다가 리팩토링을 계속 해나가고 있다. 따라서 내일을 마지막으로 오늘 도출된 개선점만 해결하고 그 후에는 본격적으로 리팩토링 4장부터 실습을 할 것이다.

---

### 2020-09-29~30

#### 변경사항

* App
  - isEmpty변수를 지웠다.

* Member
  * App클래스에서 isEmpty가 하던 역할을 selected에게 넘기고, clear메서드를 정의해 currentVocaList를 비울 수 있게 하였다.
  * clear()메서드 정의 
  * seleted()메서드 정의

- VocaList
  - 이전 코드는 외부 클래스의 인스턴스 주소를 생성자의 파라미터로 받아 직접 필드에 넣어주었으나 VocaHandler중첩 클래스가 인스턴스 클래스이기 때문에 VocaList주소를 내장 변수로 가지고 있었으므로 그럴 필요가 없었다. 생성자의 파라미터를 없애고, 외부 클래스 인스턴스 주소를 저장하는 필드도 삭제했다. 외부 클래스의 인스턴스가 필요한 자리에는 VocaList.this로 넣어주었다.

#### 디버그

- memberList.add(new Member)가 실행할 때 마다 호출되어 기본으로 등록된 회원이 memberList에 중복저장되는 버그가 있었다. 따라서 memberList.add(new Member)코드를 삭제했다.



#### 느낀점

* 중첩 클래스를 잘 알지 못하는 상태에서 구현했더니 중첩클래스를 잘 활용하지 못했다.

- 앱을 실행할 때 마다 버그가 계속 발견되는데, 아직 디버그 및 테스트 툴을 배우지 않아 아쉬운 점이 있다.

___

### 2020-10-11

#### 4장 테스트 작성

- PromptTester : Prompt 클래스에 대한 단위 테스트를 만들었다. 
  - testInput 메서드를 통해 Prompt들의 메서드들이 반환하는 타입이 올바른지 테스트했다.
- FileReaderTester : App 클래스의 loadObejects 메서드에 대한 단위 테스트를 만들었다.
  - testArrSize 메서드를 통해 data.json에 저장된 회원 개수가 arr에 저장된 회원 개수와 일치하는지 확인했다.
  - 개선점 : data.json 파일에 있는 회원 개수를 우리가 직접 확인하여 지정하지 않고, 프로그램이 자동으로 확인할 수 있도록 개선해야 한다.

#### 느낀점

- 책을 읽을 땐 개념이 생소하게 느껴졌는데, 실습을 통해 어느 정도 감을 잡은 것 같다.
- 여전히 junit 테스트 기능에 대한 지식이 부족하여 테스트를 세우기가 힘들다. 테스트에 대한 공부가 따로 필요해보인다.
- 오류에 대한 위험성에 따라 테스트 작성 대상을 판단하는 능력이 부족하다. 테스트 케이스를 리팩토링할 때마다 만드는 연습을 해야 할 것이다.



