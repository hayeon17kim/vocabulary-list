package mini.project.Handler;

import java.util.List;
import mini.project.Prompt;
import mini.project.Vocabulary;

public class VocaHandler {

  List<Vocabulary> list;

  public VocaHandler(List<Vocabulary> list) {
    this.list = list;
  }

  public void add() {
    System.out.println("단어추가");
    Vocabulary voca = new Vocabulary();
    voca.setWord(Prompt.inputString("단어? "));
    voca.setMeaning(Prompt.inputString("뜻? "));
    voca.setExSentence(Prompt.inputString("예제? "));
    voca.setLevel(Prompt.inputInt("레벨? "));
    int part;
    while (true) {
      part = Vocabulary.stringToPart(Prompt.inputString("품사? "));
      if (part == -1)
        System.out.println("품사를 다시 입력해주세요. ");
      else
        break;
    }
    voca.setPart(part);

    list.add(voca);
  }

  public void list() {
    System.out.println("단어목록");
    for(Vocabulary voca : list) {
      System.out.printf("단어 : %s, 뜻 : %s, 품사 : %s, 예제 : %s, 레벨 : %s\n",
          voca.getWord(),
          voca.getMeaning(),
          Vocabulary.partToString(voca.getPart()),
          voca.getExSentence(),
          voca.getLevel());
    }

  }

  public void update() {
    System.out.println("단어수정");
    Vocabulary voca = findByWord(Prompt.inputString("단어?"));
    if (voca == null) {
      System.out.println("찾으시는 단어가 없습니다.");
      return;
    }
    voca.setWord(Prompt.inputString(String.format("단어(%s)?", voca.getWord())));
    voca.setMeaning(Prompt.inputString(String.format("뜻(%s)?", voca.getMeaning())));
    voca.setExSentence(Prompt.inputString(String.format("예제(%s)?", voca.getExSentence())));
    voca.setLevel(Prompt.inputInt(String.format("레벨(%s)?", voca.getLevel())));
    voca.setPart(Vocabulary.stringToPart(Prompt.inputString(String.format("품사(%s)?", Vocabulary.partToString(voca.getPart())))));
  }


  public void delete() {
    System.out.println("단어삭제");
    Vocabulary voca = findByWord(Prompt.inputString("단어? "));
    if (voca == null) {
      System.out.println("찾으시는 단어가 없습니다.");
      return;
    }

    String response = Prompt.inputString("정말 삭제하시겠습니까?(y/N)");
    if(!response.equalsIgnoreCase("y")) {
      System.out.println("단어 삭제를 취소했습니다.");
      return;
    }
    list.remove(voca);

  }

  public Vocabulary findByWord(String word) {
    for (Vocabulary voca : list) {
      if (word.equals(voca.getWord())) {
        return voca;
      }
    }
    return null;
  }

  public void bookmark() {
    System.out.println("북마크 ");
    Vocabulary voca = findByWord(Prompt.inputString("단어? "));
    if (voca == null) {
      System.out.println("찾으시는 단어가 없습니다.");
      return;
    }
    
    voca.setBookmark(true);
    
  }
  
  public void cancelBookmark() {
    System.out.println("북마크 ");
    Vocabulary voca = findByWord(Prompt.inputString("단어? "));
    if (voca == null) {
      System.out.println("찾으시는 단어가 없습니다.");
      return;
    }
    
    voca.setBookmark(false);
    
  }
}
