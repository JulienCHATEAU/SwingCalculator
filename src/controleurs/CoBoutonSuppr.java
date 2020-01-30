package controleurs;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import calculatrice.*;
import composants.*;

public class CoBoutonSuppr implements ActionListener {

  private Calculatrice calcu;

  public CoBoutonSuppr(Calculatrice calcu) {
    this.calcu = calcu;
  }

  public void actionPerformed(ActionEvent e) {
    this.calcu.supprimerDernierOperateur();
    this.calcu.reprendreFocus();
  }

}
