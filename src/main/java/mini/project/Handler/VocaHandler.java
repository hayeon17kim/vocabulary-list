package mini.project.Handler;

import java.util.List;
import java.util.Random;
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
    for (int i = 0; i < list.size(); i++) {
      Vocabulary voca = list.get(i);
      System.out.println("==============================================");
      System.out.printf("   %-40s***\n", voca.getWord());
      System.out.println("==============================================");
      System.out.printf("   뜻     : %s\n", voca.getMeaning());
      if (voca.getPart() != 0)
        System.out.printf("   품사   : %s\n", voca.getPart()); 
      if (voca.getLevel() != 0)
        System.out.printf("   난이도 : %s\n", voca.getLevel());
      if (voca.getExSentence() != null)
        System.out.printf("   <예문>\n%s\n", voca.getExSentence());
      System.out.println("==============================================");
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

  public void quiz() {
    Random random = new Random();
    boolean[] order = new boolean[list.size()];
    int correct= 0;

    int testTimes;
    do {
      testTimes = Prompt.inputInt(String.format("몇 문제를 푸시겠습니까?(최대 %d) ", list.size()));
      if (testTimes > list.size())
        System.out.printf("최대 %d개의 문제만 풀 수 있습니다.", list.size());
    } while (testTimes > list.size());
    
    for (int i = 0; i < testTimes; i++) {
      int x;
      while(true) {
        x = random.nextInt(list.size());
        if (!order[x]) {
          order[x] = true;
          break;
          }
      }
        
      Vocabulary voca = list.get(x);
      System.out.println("다음 뜻에 맞는 단어를 입력하세요.");
      String response = Prompt.inputString(String.format("%d. %s : ", i + 1, voca.getMeaning()));
      
      if (response.equalsIgnoreCase(voca.getWord())) {
        System.out.println("맞았습니다!");
        correct++;
      }
      else {
        System.out.println("틀렸습니다! 해당 단어는 북마크 됩니다.");
        voca.setBookmark(true);
      }
    }
    System.out.println("시험이 완료되었습니다.");
    System.out.printf("%d 문제 중 %d개 단어를 맞추었습니다!\n", testTimes, correct);
  }
}


/*


0) 한줄로 출력 => 예제 때문에 안될듯...


1) 단어/뜻/품사/레벨 한줄, 예제 한줄
==============================================
|   word   |     단어   |   명사   |  Level.3  |
|   This word is good!                       |
==============================================
|   cake   |케이이이이크|   명사   |  Level.4  |
|   I want to eat cake...                    |
==============================================

2) 따로따로 => 그럼 많은 단어를 출력할 수 없다. 5개씩 보여줘야 할 듯
==============================================
  word
==============================================  
  뜻     : 단어
  품사   : 명사
  난이도 : Level.3
  <예문>
  This word is good!
=============================================
  cake
  케이크
  명사
  Level.4
=============================================


 */







