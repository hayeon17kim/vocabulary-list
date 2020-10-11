package mini.project;

import java.io.File;
import java.util.ArrayList;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mini.project.domain.Member;

public class FileReaderTester extends TestCase {
  
  File file;
  ArrayList<Member> arr ;
  
  public FileReaderTester(String name) {
    super(name);
  }
  
  @Override
  protected void setUp() {
    file = new File("./member.json");
    arr = new ArrayList<>();
    arr.add(new Member());
    
  }
  
  public void testArrSize() {
    App.loadObjects(arr, new File("test.json"), Member[].class);
    assert(arr.size()==1);
  }
  
  public static void main(String[] args) {
    junit.textui.TestRunner.run(new TestSuite(FileReaderTester.class));
  }
}