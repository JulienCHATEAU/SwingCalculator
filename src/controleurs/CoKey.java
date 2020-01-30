package controleurs;

import java.util.*;
import javax.swing.*;
import calculatrice.*;
import controleurs.*;
import java.awt.*;
import java.awt.event.*;

public class CoKey implements KeyListener {

  private java.util.List<JButton> boutons;


  public CoKey(java.util.List<JButton> boutons) {
    this.boutons = boutons;
  }

  public CoKey() {
    this.boutons = null;
  }

    public void keyPressed(KeyEvent e) {
      System.out.println(e.getKeyCode());
        if (e.getKeyCode() == 130) {
          this.boutons.get(0).doClick();
        }
        if (e.getKeyCode() == 53) {
          this.boutons.get(1).doClick();
        }
        if (e.getKeyCode() == 522) {
          this.boutons.get(2).doClick();
        }
        if (e.getKeyCode() == 111) {
          this.boutons.get(3).doClick();
        }
        if (e.getKeyCode() == 127) {
          this.boutons.get(4).doClick();
        }
        if (e.getKeyCode() == 103) {
          this.boutons.get(5).doClick();
        }
        if (e.getKeyCode() == 104) {
          this.boutons.get(6).doClick();
        }
        if (e.getKeyCode() == 105) {
          this.boutons.get(7).doClick();
        }
        if (e.getKeyCode() == 106) {
          this.boutons.get(8).doClick();
        }
        if (e.getKeyCode() == 8) {
          this.boutons.get(9).doClick();
        }
        if (e.getKeyCode() == 100) {
          this.boutons.get(10).doClick();
        }
        if (e.getKeyCode() == 101) {
          this.boutons.get(11).doClick();
        }
        if (e.getKeyCode() == 102) {
          this.boutons.get(12).doClick();
        }
        if (e.getKeyCode() == 107) {
          this.boutons.get(13).doClick();
        }
        if (e.getKeyCode() == 155) {
          this.boutons.get(14).doClick();
        }
        if (e.getKeyCode() == 97) {
          this.boutons.get(15).doClick();
        }
        if (e.getKeyCode() == 98) {
          this.boutons.get(16).doClick();
        }
        if (e.getKeyCode() == 99) {
          this.boutons.get(17).doClick();
        }
        if (e.getKeyCode() == 109) {
          this.boutons.get(18).doClick();
        }
        if (e.getKeyCode() == 16) {
          this.boutons.get(19).doClick();
        }
        if (e.getKeyCode() == 96) {
          this.boutons.get(20).doClick();
        }
        if (e.getKeyCode() == 110) {
          this.boutons.get(21).doClick();
        }
        if (e.getKeyCode() == 10) {
            this.boutons.get(22).doClick();
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {
    }

}
