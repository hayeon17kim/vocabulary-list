package mini.project.util.handler;

import java.util.ArrayList;
import java.util.List;
import mini.project.domain.Member;
import mini.project.domain.Vocabulary;
import mini.project.util.Prompt;

public class MemberHandler {

  List<Member> memberList = new ArrayList<>();

  public MemberHandler(List<Member> memberList) {
    this.memberList = memberList;
  }
  
  public void manage() {
    switch(Prompt.inputString("명령> ")) {
      case "회원추가":
        add();
        break;
      case "회원조회":
        list();
        break;
      case "회원수정":
        update();
        break;
      case "회원삭제":
        delete();
        break;
      default:
        System.out.println("잘못된 명령입니다.");
        break;
    }
  }

  public void add() {
    System.out.println("회원추가");
    Member member = new Member();
    member.setName(Prompt.inputString("이름? "));
    member.setId(Prompt.inputString("아이디? "));
    member.setPassword(Prompt.inputString("비밀번호? "));
    memberList.add(member);
  }

  public void list() {
    for (Member member : memberList) {
      System.out.printf("%s, %s\n", member.getName(), member.getId());
      System.out.println("[단어목록]");
      for (Vocabulary voca : member.getCurrentVocaList()) {
        System.out.printf("%s, %s\n", voca.getWord(), voca.getMeaning());
      }
      System.out.println();
    }
  }

  public void delete() {
    System.out.println("회원삭제");
    Member member = findById(Prompt.inputString("회원 아이디를 입력해주세요."));
    if (member == null) {
      System.out.println("찾으시는 회원이 없습니다.");
      return;
    }

    String response = Prompt.inputString("정말 삭제하시겠습니까?(y/N)");
    if(!response.equalsIgnoreCase("y")) {
      System.out.println("회원 삭제를 취소했습니다.");
      return;
    }
    memberList.remove(member);
    }

  public void update() {
    System.out.println("회원수정");
    Member member = findById(Prompt.inputString("회원 아이디를 입력하세요."));
    if (member == null) {
      System.out.println("찾으시는 단어가 없습니다.");
      return;
    }
    member.setName(Prompt.inputString(String.format("이름(%s)?", member.getName())));
    member.setId(Prompt.inputString(String.format("아이디(%s)?", member.getId())));
    member.setPassword(Prompt.inputString(String.format("비밀번호(%s)?", member.getPassword())));
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