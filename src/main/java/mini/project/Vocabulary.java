package mini.project;

public class Vocabulary {
  private String word;
  private String meaning;
  private String exSentence;
  private int level;
  private boolean isMemorized;
  private int part;

  public static final int VERB = 1;
  public static final int NOUN = 2;
  public static final int ADVERB = 3;
  public static final int ADJECTIVE = 4;

  public Vocabulary() {

  }

  public int getPart() {
    return part;
  }

  public void setPart(int part) {
    this.part = part;
  }

  public Vocabulary(String word, String meaning) {
    this.word = word;
    this.meaning = meaning;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public String getMeaning() {
    return meaning;
  }

  public void setMeaning(String meaning) {
    this.meaning = meaning;
  }

  public String getExSentence() {
    return exSentence;
  }

  public void setExSentence(String exSentence) {
    this.exSentence = exSentence;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public boolean isMemorized() {
    return isMemorized;
  }

  public void setMemorized(boolean isMemorized) {
    this.isMemorized = isMemorized;
  }

  public static int stringToPart(String inputString) {
    switch (inputString) {
      case "동사":
        return VERB;
      case "명사":
        return NOUN;
      case "부사":
        return ADVERB;
      case "형용사":
        return ADJECTIVE;
      default:
        return -1;
    }
  }

  public static String partToString(int part) {
    switch (part) {
      case VERB:
        return "동사";
      case NOUN:
        return "명사";
      case ADVERB:
        return "부사";
      case ADJECTIVE:
        return "형용사";
      default:
        return "무효한 품사";
    }
  }
}
