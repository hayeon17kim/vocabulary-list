package mini.project.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import mini.project.domain.Vocabulary;


public class VocaList {
  private static final long serialVersionUID = 1L;
  
  List<Vocabulary> list = new ArrayList<>();
  
  Handler vocaHandler = new Handler();

  {
    list.add(new Vocabulary("python", "파이썬", "python is love"));
    list.add(new Vocabulary("javascript", "자바스크립트", "javaScript is not java"));
    list.add(new Vocabulary("java", "자바", "we love java"));
    list.add(new Vocabulary("kotlin", "코틀린", "kotlin is java's neighborhood"));
    list.add(new Vocabulary("go", "고", "Let's go!"));
    list.add(new Vocabulary("ruby", "루비", "I want Ruby"));
    list.add(new Vocabulary("c", "씨", "C is old languege"));
  }

  public Handler getVocaHandler() {
    return vocaHandler;
  }

  public void setVocaHandler(Handler vocaHandler) {
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

  public void bookmarkVoca() {
    vocaHandler.bookmark();
  }

  public void cancleBookmarkVoca() {
    vocaHandler.cancelBookmark();
  }

  public void quiz() {
    vocaHandler.quiz();
  }


  public class Handler {

    public Handler() {
    }

    public void add() {
      System.out.println("단어추가");
      Vocabulary newVoca = inputVocaInfo();
      list.add(newVoca);
    }

    public Vocabulary inputVocaInfo() {
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
      return voca;
    }

    public void list() {
      System.out.println("단어목록");
      for (int i = 0; i < list.size(); i++) {
        Vocabulary voca = list.get(i);
        detail(voca);
      }
    }


    public void update() {
      System.out.println("단어수정");
      Vocabulary voca = findByWord(Prompt.inputString("단어?"));
      if (voca == null) {
        System.out.println("찾으시는 단어가 없습니다.");
        return;
      }

      detail(voca);

      voca = inputVocaInfo();
    }

    public void detail(Vocabulary voca) {
      System.out.println("==============================================");
      if (voca.getBookmark())
        System.out.printf("   %-40s***\n", voca.getWord());
      else
        System.out.printf("   %s\n", voca.getWord());
      System.out.println("==============================================");
      System.out.printf("   뜻     : %s\n", voca.getMeaning());
      if (voca.getPart() != 0)
        System.out.printf("   품사   : %s\n", Vocabulary.partToString(voca.getPart()));
      if (voca.getLevel() != 0)
        System.out.printf("   난이도 : %s\n", voca.getLevel());
      if (voca.getExSentence() != null)
        System.out.printf("   <예문>\n%s\n", voca.getExSentence());
      System.out.println("==============================================");

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
      System.out.println("북마크 취소");
      Vocabulary voca = findByWord(Prompt.inputString("단어? "));
      if (voca == null) {
        System.out.println("찾으시는 단어가 없습니다.");
        return;
      }

      voca.setBookmark(false);

    }

    public void quiz() {

      int correct= 0;
      int testTimes = testTimes();

      boolean[] order = new boolean[testTimes];
      for (int i = 0; i < testTimes; i++) {
        int thisQuizNum = randomQuiz(testTimes, order);
        
        Vocabulary voca = list.get(thisQuizNum);
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

  private int testTimes() {
    int testTimes;
    do {
      testTimes = Prompt.inputInt(String.format("몇 문제를 푸시겠습니까?(최대 %d) ", list.size()));
      if (testTimes > list.size())
        System.out.printf("최대 %d개의 문제만 풀 수 있습니다.", list.size());
    } while (testTimes > list.size());
    return testTimes;
  }

  private int randomQuiz(int testTimes, boolean[] order) {
    Random random = new Random();
    int result;
    while(true) {
      result = random.nextInt(testTimes);
      if (!order[result]) {
        order[result] = true;
        break;
      }
    }
    return result;
  }
}
