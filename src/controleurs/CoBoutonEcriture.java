package controleurs;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import calculatrice.*;
import composants.*;

public class CoBoutonEcriture implements ActionListener {

  private Calculatrice calcu;

  public CoBoutonEcriture(Calculatrice calcu) {
    this.calcu = calcu;
  }

  public void actionPerformed(ActionEvent e) {
    BoutonEcriture source = (BoutonEcriture) e.getSource();
    this.calcu.ajouterOperateur(source.getValeur());
    this.calcu.reprendreFocus();
  }
}
