package controleurs;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import calculatrice.*;
import composants.*;

public class CoBoutonEnter implements ActionListener {

  private Calculatrice calcu;

  public CoBoutonEnter(Calculatrice calcu) {
    this.calcu = calcu;
  }

  public void actionPerformed(ActionEvent e) {
    if (!this.calcu.operationVide()) {
      this.calcu.setCompteurPrec(0);
      if (this.calcu.verifierExpression()) {
        this.calcu.calculerResultatExpression();
      } else {
        this.calcu.afficherErreur("L'expression saisie est incorrect");
      }
    }
    this.calcu.reprendreFocus();
  }
}
