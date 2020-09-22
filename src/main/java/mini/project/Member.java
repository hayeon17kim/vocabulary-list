package mini.project;

import java.util.List;

public class Member {
  private String name;
  private String id;
  private String password;

  List<Vocabulary> vocaList;
  List<Vocabulary> bookmarkedVocaList;

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
  }

  public List<Vocabulary> getBookmarkedVocaList() {
    return bookmarkedVocaList;
  }

  public void setBookmarkedVocaList(List<Vocabulary> bookmarkedVocaList) {
    this.bookmarkedVocaList = bookmarkedVocaList;
  }

  public void addVoca() {
    System.out.println("단어추가");
  }

  public void listVoca() {
    System.out.println("단어조회");
  }

  public void updateVoca() {
    System.out.println("단어수정");
  }

  public void deleteVoca() {
    System.out.println("단어삭제");
  }

  public void quiz() {
    System.out.println("퀴즈");
  }

  public void bookmarkVoca() {
    System.out.println("북마크");
  }
}
