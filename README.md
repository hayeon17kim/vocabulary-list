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
