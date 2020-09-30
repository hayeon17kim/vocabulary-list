package mini.project.domain;

import java.io.Serializable;
import java.util.HashMap;
import mini.project.util.Prompt;
import mini.project.util.VocaList;

public class Member implements Serializable {

  private static final long serialVersionUID = 1L;


  private String name;
  private String id;
  private String password;

  private VocaList currentVocaList;

  public Member() {
    this.name = "유관순";
    this.id = "admin";
    this.password = "1234";
  }
  HashMap<String, VocaList> vocaListMap = new HashMap<String, VocaList>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public VocaList findVocaList() {
    return vocaListMap.get(Prompt.inputString("단어장 이름 : "));
  }


  public VocaList getCurrentVocaList() {
    return currentVocaList;

  }

  public void setCurrentVocaList() {
    this.currentVocaList = findVocaList();
  }

  public void addVoca() {
    currentVocaList.addVoca();
  }

  public void listVoca() {
    currentVocaList.listVoca();
  }

  public void updateVoca() {
    currentVocaList.updateVoca();
  }

  public void deleteVoca() {
    currentVocaList.deleteVoca();
  }

  public void quiz() {
    System.out.println("퀴즈");
    currentVocaList.quiz();
  }

  public void bookmarkVoca() {
    findVocaList().bookmarkVoca();
  }

  public void cancelBookmarkVoca() {
    currentVocaList.cancleBookmarkVoca();
  }


  public void listVocaList() {
    System.out.println("[단어장 목록]");
    for (String key : vocaListMap.keySet())
      System.out.println(vocaListMap.get(key).getTitle());
  }

  public void addVocaList() {
    System.out.println("[단어장 추가]");
    String title = Prompt.inputString("단어장 이름 : ");
    vocaListMap.put(title, new VocaList(title));
  }

  public void deleteVocaList() {
    System.out.println("[단어장 삭제]");
    vocaListMap.remove(Prompt.inputString("단어장 이름 : "));
  }

  public void clear() {
    currentVocaList = null;
  }

  public boolean selected() {
    return currentVocaList != null;
  }
}
