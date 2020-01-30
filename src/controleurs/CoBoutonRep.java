package controleurs;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import calculatrice.*;
import composants.*;

public class CoBoutonRep implements ActionListener {

  private Calculatrice calcu;

  public CoBoutonRep(Calculatrice calcu) {
    this.calcu = calcu;
  }

  public void actionPerformed(ActionEvent e) {
    JButton source = (JButton) e.getSource();
    if (this.calcu.getResultatSaved()) {
      this.calcu.ajouterOperateur(this.calcu.getDernierResultat() + "");
    }
    this.calcu.reprendreFocus();
  }
}
