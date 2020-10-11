package mini.project.util;

import java.util.ArrayList;
import java.util.Random;
import mini.project.domain.Vocabulary;


public class VocaList extends ArrayList<Vocabulary> {
  private static final long serialVersionUID = 1L;

    String title;
    Handler vocaHandler = new Handler();
    
      {
        add(new Vocabulary("python", "파이썬", "python is love"));
        add(new Vocabulary("javascript", "자바스크립트", "javaScript is not java"));
        add(new Vocabulary("java", "자바", "we love java"));
        add(new Vocabulary("kotlin", "코틀린", "kotlin is java's neighborhood"));
        add(new Vocabulary("go", "고", "Let's go!"));
        add(new Vocabulary("ruby", "루비", "I want Ruby"));
        add(new Vocabulary("c", "씨", "C is old languege"));
      }

    public VocaList(String title) {
      this.title = title;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
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

      VocaList.this.add(voca);
    }

    public void list() {
      System.out.println("단어목록");
      for (int i = 0; i < VocaList.this.size(); i++) {
        Vocabulary voca = VocaList.this.get(i);
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
      VocaList.this.remove(voca);

    }

    public Vocabulary findByWord(String word) {
      for (Vocabulary voca : VocaList.this) {
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
      Random random = new Random();
      boolean[] order = new boolean[VocaList.this.size()];
      int correct= 0;

      int testTimes;
      do {
        testTimes = Prompt.inputInt(String.format("몇 문제를 푸시겠습니까?(최대 %d) ", VocaList.this.size()));
        if (testTimes > VocaList.this.size())
          System.out.printf("최대 %d개의 문제만 풀 수 있습니다.", VocaList.this.size());
      } while (testTimes > VocaList.this.size());

      for (int i = 0; i < testTimes; i++) {
        int x;
        while(true) {
          x = random.nextInt(VocaList.this.size());
          if (!order[x]) {
            order[x] = true;
            break;
          }
        }

        Vocabulary voca = VocaList.this.get(x);
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
}
