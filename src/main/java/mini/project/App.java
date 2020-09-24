package mini.project;

import java.util.ArrayList;
import java.util.List;
import mini.project.Handler.MemberHandler;

public class App {
  static List<Member> memberList = new ArrayList<Member>();
  static MemberHandler memberHandler = new MemberHandler(memberList);
  static Member loggedInMember;

  public static void main(String[] args) {
    
    loop:
    while (true) {
      if (loggedInMember == null) {
        switch (Prompt.inputString("명령> ")) {
          case "로그인":
            loggedInMember = memberHandler.logIn();
            break;
          case "회원가입":
            memberHandler.add();
            break;
          case "종료":
            break loop;
          default:
            System.out.println("유효하지 않은 명령어!");
        }

      } else {
        switch (Prompt.inputString("명령> ")) {
          case "퀴즈":
            loggedInMember.quiz();
            break;
          case "단어추가":
            loggedInMember.addVoca();
            break;
          case "단어삭제":
            loggedInMember.deleteVoca();
            break;
          case "단어수정":
            loggedInMember.updateVoca();
            break;
          case "단어조회":
            loggedInMember.listVoca();
            break;
          case "북마크하기":
            loggedInMember.bookmarkVoca();
            break;
          case "북마크취소":
            loggedInMember.cancelBookmarkVoca();
          case "로그아웃":
            loggedInMember = null;
            break;
          default:
            System.out.println("유효하지 않은 명령어!");
        }
      }
    }
  }

}
