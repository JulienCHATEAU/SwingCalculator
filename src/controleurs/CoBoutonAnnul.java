package controleurs;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import calculatrice.*;
import composants.*;

public class CoBoutonAnnul implements ActionListener {

  private Calculatrice calcu;

  public CoBoutonAnnul(Calculatrice calcu) {
    this.calcu = calcu;
  }

  public void actionPerformed(ActionEvent e) {
    this.calcu.setCompteurPrec(0);
    if (!this.calcu.estVide()) {
      if (this.calcu.operationVide()) {
        this.calcu.clearGraphique();
      } else {
        this.calcu.removeOperation();
      }
    }
    this.calcu.reprendreFocus();
  }
}
