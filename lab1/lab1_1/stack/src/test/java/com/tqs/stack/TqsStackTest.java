package com.tqs.stack;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TqsStackTest 
{
    TqsStack<String> wordsStack;

    @BeforeEach
    public void testBeforeEach() throws Exception {
        wordsStack = new TqsStack<String>(10);
    }

    @Test
    public void testIsEmpty() {
        // test a)
        assertTrue(wordsStack.isEmpty()); // true

        wordsStack.push("Teste");
        assertEquals(wordsStack.isEmpty(), false); // false

        wordsStack.pop();
        assertTrue(wordsStack.isEmpty()); // true
        
    }

    @Test
    public void testSize() {
        // test b)
        assertEquals(wordsStack.size(), 0);
    }

    @Test
    public void pushNValues_thenSizeIsN() {
        // test c)
        int n = 10;
        for (int i = 0; i < n; i++) {
            wordsStack.push("Test");    
        }    
        assertEquals(wordsStack.isEmpty(), false); // stack is not empty
        assertEquals(wordsStack.size(), n); // size = number of pushes

        // test i) can't push through the limit of the bounded stack
        assertThrows(IllegalStateException.class, () -> wordsStack.push("Another test"));

        
        for (int i = 0; i < 10; i++) {
            wordsStack.pop();
        }

        // test f)
        assertEquals(wordsStack.isEmpty(), true); // after n pops, the stack is empty, since its size was n
        assertEquals(wordsStack.size(), 0); // since the stack is now empty, its size is 0

    }

    @Test
    public void pushTwoValues_thenPopReverseOrder() {
        // test d)
        String t1 = "Test 1";
        String t2 = "Test 2";
        wordsStack.push(t1);
        wordsStack.push(t2);
        assertEquals(wordsStack.pop(), t2);
        assertEquals(wordsStack.pop(), t1);
        
        // test g)
        assertThrows(NoSuchElementException.class, () -> wordsStack.pop());
        // test h)
        assertThrows(NoSuchElementException.class, () -> wordsStack.peek());
    }

    @Test
    public void pushTwoValues_thenPeek() {
        // test e)
        String t1 = "Test 1";
        String t2 = "Test 2";
        wordsStack.push(t1);
        wordsStack.push(t2);
        assertEquals(wordsStack.peek(), t2);
        assertEquals(wordsStack.size(), 2);
        
        String t3 = "Test 3";
        wordsStack.push(t3);
        assertEquals(wordsStack.peek(), t3);
    }

}
