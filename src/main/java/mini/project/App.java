package mini.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import com.google.gson.Gson;
import mini.project.Handler.MemberHandler;

public class App {
  static List<Member> memberList = new ArrayList<Member>();
  static File memberFile = new File("./member.json");
  static MemberHandler memberHandler = new MemberHandler(memberList);
  static Member loggedInMember;

  public static void main(String[] args) {
    loadObjects(memberList, memberFile, Member[].class);
    memberList.add(new Member());

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
            case "회원관리":
              memberHandler.manage();
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
            case "단어목록":
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
      Prompt.close();
      saveObjects(memberList, memberFile);
    }
  
  private static <T> void saveObjects(Collection<T> list, File file) {
    BufferedWriter out = null;
    try {
      out = new BufferedWriter(new FileWriter(file));

      Gson gson = new Gson();
      String Json = gson.toJson(list);
      out.write(Json);

      out.flush();

      System.out.printf("총 %d 개의 객체를 '%s' 파일에 저장했습니다.\n", list.size(), file.getName());

    } catch (IOException e) {
      System.out.printf("객체를 '%s' 파일에 쓰기 중 오류 발생! - %s\n", file.getName(), e.getMessage());

    } finally {
      try {
        out.close();
      } catch (IOException e) {
      }
    }
  }

  private static <T> void loadObjects(Collection<T> list, // 객체를 담을 컬렉션
      File file, // JSON 문자열이 저장된 파일
      Class<T[]> clazz // JSON 문자열을 어떤 타입의 배열로 만들 것인지 알려 주는 클래스 정보
  ) {
    BufferedReader in = null;
    try {
      in = new BufferedReader(new FileReader(file));
      list.addAll(Arrays.asList(new Gson().fromJson(in, clazz)));


      System.out.printf("%s 파일에서 총 %d 개의 객체를 로딩했습니다.\n", file.getName(), list.size());

    } catch (Exception e) {
      System.out.printf("%s 파일 읽기 중 오류 발생! - %s\n", file.getName(), e.getMessage());
    } finally {
      try {
        in.close();
      } catch (Exception e) {
      }
    }
  }
}