package controleurs;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import calculatrice.*;
import composants.*;

public class CoBoutonPrec implements ActionListener {

  private Calculatrice calcu;

  public CoBoutonPrec(Calculatrice calcu) {
    this.calcu = calcu;
  }

  public void actionPerformed(ActionEvent e) {
    if (this.calcu.getOperationSaved()) {
      this.calcu.afficherDerniereOperation();
    }
    this.calcu.reprendreFocus();
  }
}
