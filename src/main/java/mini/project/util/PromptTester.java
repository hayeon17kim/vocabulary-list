package mini.project.util;

import java.sql.Date;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PromptTester extends TestCase {
  
  public PromptTester(String name) {
    super(name);
  }

  @Override
  protected void tearDown() {
    Prompt.close();
  }
  
  public void testInput() {
    assert(Prompt.inputString("문자열> ") instanceof String);
    assert(Integer.valueOf(Prompt.inputInt("정수> ")) instanceof Integer);
    assert(Prompt.inputDate("날짜(yyyy-mm-dd)> ") instanceof Date);
  }


  public static Test suite() {
      TestSuite suite = new TestSuite();
      suite.addTest(new PromptTester("testInput"));
      return suite;
  }
  
  public static void main(String[] args) {
    junit.textui.TestRunner.run(new TestSuite(PromptTester.class));
  }
  
}
