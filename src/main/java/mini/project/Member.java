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
    Vocabulary voca = new Vocabulary();
    voca.setWord(Prompt.inputString("단어? "));
    voca.setMeaning(Prompt.inputString("뜻? "));
    voca.setExSentence(Prompt.inputString("예제? "));
    voca.setLevel(Prompt.inputInt("레벨? "));
    voca.setPart(Vocabulary.stringToPart(Prompt.inputString("품사? ")));


    vocaList.add(voca);
  }

  public void listVoca() {
    System.out.println("단어목록");
    for(Vocabulary voca : vocaList) {
      System.out.printf("단어 : %s, 뜻 : %s, 품사 : %s, 예제 : %s, 레벨 : %s\n",
          voca.getWord(),
          voca.getMeaning(),
          Vocabulary.partToString(voca.getPart()),
          voca.getExSentence(),
          voca.getLevel());
    }
  }

  public Vocabulary findByWord(String word) {
    for (Vocabulary voca : vocaList) {
      if (word.equals(voca.getWord())) {
        return voca;
      }
    }
    return null;
  }

  public void updateVoca() {
    System.out.println("단어수정");
      Vocabulary voca = findByWord(Prompt.inputString("단어?"));
  if (voca == null) {
    /**
     voca.setWord(Prompt.inputString(String.format("단어(%s)?")));
     voca.setMeaning(Prompt.inputString(String.format("뜻(%s)?")));
     voca.setExSentence(Prompt.inputString(String.format("예제(%s)?")));
    voca.setLevel(Prompt.inputString(String.format("레벨(%s)?")));
**/
  }
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
