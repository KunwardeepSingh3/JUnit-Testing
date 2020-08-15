package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    //tests the testcount method
    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers2() {
    	mycustomstring.setString("");
        assertEquals(0, mycustomstring.countNumbers());
    }

    //checks if a number with a space is treated as two numbers
    @Test
    public void testCountNumbers3() {
    	mycustomstring.setString("see how 6 1 is treated");
        assertEquals(2, mycustomstring.countNumbers());
    }
    
    //tests how many numbers
    @Test
    public void testCountNumbers4() {
    	mycustomstring.setString( "there are no numbers, bye !");
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers5() {
    	mycustomstring.setString("934 34 432 43 434 4fes");
        assertEquals(6, mycustomstring.countNumbers());
    }

    //tests that the program throws nullpointerexception
    @Test (expected = NullPointerException.class )
    public void testCountNumbers6() {
        mycustomstring.setString(null);
        mycustomstring.countNumbers();
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    //tests if Illegal argument exception is thrown
    @Test (expected = IllegalArgumentException.class )
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
        mycustomstring.setString("Let's test this exception");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, false);
    }
    
  //tests if Null Pointer exception is thrown
    @Test (expected = NullPointerException.class )
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
        mycustomstring.setString(null);
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false);
    }

    
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
        mycustomstring.setString("hello world");
        assertEquals("el ol", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
        mycustomstring.setString("hello world");
        assertEquals("el ol", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }

    //test that proves starting from end and begining of the string can net two different outcomes
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
        mycustomstring.setString("random l3t3rz  ar3 not tooo hard too wri!te");
        assertEquals("nm3r 3otoa ort", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
        mycustomstring.setString("random l3t3rz  ar3 not tooo hard too wri!te");
        assertEquals("aol3 rn ohdow!", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

	//test to print out the entire string by itteration
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
        mycustomstring.setString("Print me out completley");
        assertEquals("Print me out completley", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
        mycustomstring.setString("Print me out completley");
        assertEquals("Print me out completley", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true));
    }

    //tests the exception once more where n = -1
    @Test (expected = IllegalArgumentException.class )
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
        mycustomstring.setString("Let's test this exception");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-1, false);
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
        mycustomstring.setString("helloRandom");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(12, true));
    }

    
    //test that it prints spaces only
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
        mycustomstring.setString("1 2 3 4 5 6 7 8 9 ");
        assertEquals("         ", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }

    //test that it prints only numbers
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
        mycustomstring.setString("1 2 3 4 5 6 7 8 9 ");
        assertEquals("123456789", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }
    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    //tests the illegalArgumentException by making startingpoint > endingpoint
    @Test (expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring2() {
        mycustomstring.setString("test number two");
        mycustomstring.convertDigitsToNamesInSubstring(12,9);
    }

    //tests the index out of bounds exception for starting point
    @Test (expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring3() {
        mycustomstring.setString("test number 3");
        mycustomstring.convertDigitsToNamesInSubstring(0,9);
    }

   //tests the index out of bounds exception for Ending point
   @Test (expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring4() {
        mycustomstring.setString("test number 4");
        mycustomstring.convertDigitsToNamesInSubstring(1,mycustomstring.getString().length() + 1);
    }

    //tests Nullpointer exception by making both starting and endpoints 0
    @Test (expected = NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring5() {
        mycustomstring.setString(null);
        mycustomstring.convertDigitsToNamesInSubstring(1,2);
    }

    //test space
    @Test
    public void testConvertDigitsToNamesInSubstring6() {
        mycustomstring.setString(" ");
        mycustomstring.convertDigitsToNamesInSubstring(1,1);
    }

    //Random test to see if the method fails
    @Test
    public void testConvertDigitsToNamesInSubstring7() {
        mycustomstring.setString("test7 string01 ");
        mycustomstring.convertDigitsToNamesInSubstring(1, 15);
        assertEquals("testseven stringzeroone ", mycustomstring.getString());
    }

    //tests the method with special keys
    @Test
    public void testConvertDigitsToNamesInSubstring8() {
        mycustomstring.setString("test$8 string%1 ");
        mycustomstring.convertDigitsToNamesInSubstring(1, 15);
        assertEquals("test$eight string%one ", mycustomstring.getString());
    }

}