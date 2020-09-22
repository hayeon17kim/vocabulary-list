/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package mini.project;

import java.util.ArrayList;
import java.util.List;

public class App {
  static List<Member> memberList = new ArrayList<Member>();
  static MemberHandler memberHandler = new MemberHandler(memberList);
  static Member loggedInMember;

  public static void main(String[] args) {
    while (true) {
      if (loggedInMember == null) {
        switch (Prompt.inputString("명령> ")) {
          case "로그인":
            loggedInMember = memberHandler.logIn();
            break;
          case "회원가입":
            memberHandler.add();
            break;
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
          case "로그아웃":
            loggedInMember = null;
            break;
        }
      }
    }
  }
}
