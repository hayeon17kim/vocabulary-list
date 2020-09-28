package mini.project.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
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


  //  {
  //    vocaList.add(new Vocabulary("python", "파이썬", "python is love"));
  //    vocaList.add(new Vocabulary("javascript", "자바스크립트", "javaScript is not java"));
  //    vocaList.add(new Vocabulary("java", "자바", "we love java"));
  //    vocaList.add(new Vocabulary("kotlin", "코틀린", "kotlin is java's neighborhood"));
  //    vocaList.add(new Vocabulary("go", "고", "Let's go!"));
  //    vocaList.add(new Vocabulary("ruby", "루비", "I want Ruby"));
  //    vocaList.add(new Vocabulary("c", "씨", "C is old languege"));
  //  }

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
    for (String key : vocaListMap.keySet())
      System.out.println(vocaListMap.get(key));
  }

  public void addVocaList() {
    vocaListMap.put(Prompt.inputString("단어장 이름 : "), new VocaList());
  }

  public void deleteVocaList() {
   vocaListMap.remove(Prompt.inputString("단어장 이름 : "));
  }
}
