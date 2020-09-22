package mini.project;

import java.util.ArrayList;
import java.util.List;

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

  public Member findById(String Id) {
    for (int i = 0; i < memberList.size(); i++) {
      if (memberList.get(i).getId().equals(Id)) {
        return memberList.get(i);
      }
    }
    return null;
  }

  public static Member logIn() {
    /*
     * System.out.println("로그인");
     * 
     * String id = Prompt.inputString("아이디?"); while (true) { if (findById(id) == null) {
     * System.out.println("아이디가 일치하지 않습니다."); } else if
     * (findById(id).getPassword().equals(Prompt.inputString("비밀번호? "))) { return findById(id); }
     * else {
     * 
     * } System.out.println("다시 입력해주세요!"); }
     */
    return new Member();
  }
}

