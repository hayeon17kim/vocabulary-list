package mini.project;

import java.util.ArrayList;
import java.util.List;
import mini.project.Handler.VocaHandler;

public class Member {
  private String name;
  private String id;
  private String password;

public Member() {
  this.name = "유관순";
  this.id = "admin";
  this.password = "1234";
}

  List<Vocabulary> vocaList = new ArrayList<Vocabulary>();
  
  {
    vocaList.add(new Vocabulary("python", "파이썬", "python is love"));
    vocaList.add(new Vocabulary("javascript", "자바스크립트", "javaScript is not java"));
    vocaList.add(new Vocabulary("java", "자바", "we love java"));
    vocaList.add(new Vocabulary("kotlin", "코틀린", "kotlin is java's neighborhood"));
    vocaList.add(new Vocabulary("go", "고", "Let's go!"));
    vocaList.add(new Vocabulary("Ruby", "루비", "I want Ruby"));
    vocaList.add(new Vocabulary("c", "씨", "C is old languege"));
  }
  
  VocaHandler vocaHandler = new VocaHandler(vocaList);

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

  public List<Vocabulary> getVocaList() {
    return vocaList;
  }

  public void setVocaList(List<Vocabulary> vocaList) {
    this.vocaList = vocaList;
    setVocaHandler(new VocaHandler(this.vocaList));
  }

  public VocaHandler getVocaHandler() {
    return vocaHandler;
  }

  public void setVocaHandler(VocaHandler vocaHandler) {
    this.vocaHandler = vocaHandler;
  }

  public void addVoca() {
    vocaHandler.add();
  }
  
  public void listVoca() {
    vocaHandler.list();
  }
  
  public void updateVoca() {
    vocaHandler.update();
  }
  
  public void deleteVoca() {
    vocaHandler.delete();
  }

  public void quiz() {
    System.out.println("퀴즈");
    vocaHandler.quiz();
  }

  public void bookmarkVoca() {
    vocaHandler.bookmark();
  }
  
  public void cancelBookmarkVoca() {
    vocaHandler.cancelBookmark();
  }
}
