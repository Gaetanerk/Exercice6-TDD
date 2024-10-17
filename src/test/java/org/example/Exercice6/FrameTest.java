package org.example.Exercice6;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FrameTest {
    private Frame frame;
    private IGenerateur generateur;

    @Before
    public void setUp() {
        generateur = mock(IGenerateur.class);
    }

    @Test
    public void Roll_SimpleFrame_FirstRoll_CheckScore() {
        when(generateur.randomPin(10)).thenReturn(5);
        frame = new Frame(generateur, false);
        frame.makeRoll();
        assertEquals(5, frame.getScore());
    }

    @Test
    public void Roll_SimpleFrame_SecondRoll_CheckScore() {
        when(generateur.randomPin(10)).thenReturn(5, 3);
        frame = new Frame(generateur, false);
        frame.makeRoll();
        frame.makeRoll();
        assertEquals(8, frame.getScore());
    }

    @Test
    public void Roll_SimpleFrame_SecondRoll_FirstRollStrick_ReturnFalse() {
        when(generateur.randomPin(10)).thenReturn(10);
        frame = new Frame(generateur, false);
        frame.makeRoll();
        assertFalse(frame.makeRoll());
    }

    @Test
    public void Roll_SimpleFrame_MoreRolls_ReturnFalse() {
        when(generateur.randomPin(10)).thenReturn(3, 4);
        frame = new Frame(generateur, false);
        frame.makeRoll();
        frame.makeRoll();
        assertFalse(frame.makeRoll());
    }

    @Test
    public void Roll_LastFrame_SecondRoll_FirstRollStrick_ReturnTrue() {
        when(generateur.randomPin(10)).thenReturn(10, 5);
        frame = new Frame(generateur, true);
        frame.makeRoll();
        assertTrue(frame.makeRoll());
    }

    @Test
    public void Roll_LastFrame_SecondRoll_FirstRollStrick_CheckScore() {
        when(generateur.randomPin(10)).thenReturn(10, 5);
        frame = new Frame(generateur, true);
        frame.makeRoll();
        frame.makeRoll();
        assertEquals(15, frame.getScore());
    }

    @Test
    public void Roll_LastFrame_ThirdRoll_FirstRollStrick_ReturnTrue() {
        when(generateur.randomPin(10)).thenReturn(10, 5, 3);
        frame = new Frame(generateur, true);
        frame.makeRoll();
        frame.makeRoll();
        assertTrue(frame.makeRoll());
    }

    @Test
    public void Roll_LastFrame_ThirdRoll_FirstRollStrick_CheckScore() {
        when(generateur.randomPin(10)).thenReturn(10, 5, 3);
        frame = new Frame(generateur, true);
        frame.makeRoll();
        frame.makeRoll();
        frame.makeRoll();
        assertEquals(18, frame.getScore());
    }

    @Test
    public void Roll_LastFrame_ThirdRoll_Spare_ReturnTrue() {
        when(generateur.randomPin(10)).thenReturn(5, 5, 3);
        frame = new Frame(generateur, true);
        frame.makeRoll();
        frame.makeRoll();
        assertTrue(frame.makeRoll());
    }

    @Test
    public void Roll_LastFrame_ThirdRoll_Spare_CheckScore() {
        when(generateur.randomPin(10)).thenReturn(5, 5, 3);
        frame = new Frame(generateur, true);
        frame.makeRoll();
        frame.makeRoll();
        frame.makeRoll();
        assertEquals(13, frame.getScore());
    }

    @Test
    public void Roll_LastFrame_FourthRoll_ReturnFalse() {
        when(generateur.randomPin(10)).thenReturn(10, 10, 10);
        frame = new Frame(generateur, true);
        frame.makeRoll();
        frame.makeRoll();
        frame.makeRoll();
        assertFalse(frame.makeRoll());
    }
}