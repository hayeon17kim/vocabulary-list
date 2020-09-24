package mini.project.Handler;

import java.util.ArrayList;
import java.util.List;
import mini.project.Member;
import mini.project.Prompt;

public class MemberHandler {

  List<Member> memberList = new ArrayList<>();

  public MemberHandler(List<Member> memberList) {
    this.memberList = memberList;
  }


  public void add() {
    System.out.println("회원추가");
    Member member = new Member();
    member.setName(Prompt.inputString("이름? "));
    member.setId(Prompt.inputString("아이디? "));
    member.setPassword(Prompt.inputString("비밀번호? "));
    memberList.add(member);
  }

  public void delete() {
    System.out.println("회원삭제");
    ///Member member = findById(Prompt.inputString("회원 아이디를 입력해주세요."));
  }

  public void update() {
    System.out.println("회원수정");
  }

  public Member findById(String Id) {
    for (int i = 0; i < memberList.size(); i++) {
      if (memberList.get(i).getId().equals(Id)) {
        return memberList.get(i);
      }
    }
    return null;
  }

  public Member logIn() {
    System.out.println("아이디와 비밀번호를 입력해주세요. ");
    System.out.println("아이디에 빈 문자열을 입력하시면 취소됩니다.");
    while (true) {
      String ID = Prompt.inputString("아이디: ");
      if (ID.equals(""))
        return null;

      String password = Prompt.inputString("비밀번호: ");

      if (findById(ID) == null) {
        System.out.println("아이디를 찾을 수 없습니다.");

      } else if (!findById(ID).getPassword().equals(password)) {
        System.out.println("비밀번호가 틀렸습니다.");
      } else {
        System.out.printf("%s님 안녕하세요!\n", findById(ID).getName());
        return findById(ID);
      }

    }
  }

}