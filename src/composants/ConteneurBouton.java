/**
* Cette classe est une classe représentant un conteneur de boutons
*
* @author CHATEAU Julien
*@version 1.0
*/

package composants;

import java.util.*;
import javax.swing.*;
import calculatrice.*;
import controleurs.*;
import java.awt.*;
import java.awt.event.*;


public class ConteneurBouton extends JPanel {

  private java.util.List<JButton> boutons;
  private java.util.List<JButton> boutonsAction;
  private Calculatrice calcu;

/** Constructeur de la classe ConteneurBouton
@param calcu, la calculatrice auquel le conteneur de bouton est associé
*/
  public ConteneurBouton(Calculatrice calcu) {
    super();
    this.calcu = calcu;
    this.setLayout(new GridLayout(6, 6));
    this.setBackground(Constante.BEIGE);
    this.boutons = new ArrayList<JButton>();
    this.boutons.add(new BoutonEcriture("^", calcu));
    this.boutons.add(new BoutonEcriture("(", calcu));
    this.boutons.add(new BoutonEcriture(")", calcu));
    this.boutons.add(new BoutonEcriture("/", calcu));
    JButton annul = new JButton("Annul");
    annul.setBackground(Constante.GRIS);
    CoBoutonAnnul cba = new CoBoutonAnnul(this.calcu);
    annul.addActionListener(cba);
    this.boutons.add(annul);
    this.boutons.add(new BoutonEcriture("7", calcu));
    this.boutons.add(new BoutonEcriture("8", calcu));
    this.boutons.add(new BoutonEcriture("9", calcu));
    this.boutons.add(new BoutonEcriture("*", calcu));
    JButton suppr = new JButton("Suppr");
    suppr.setBackground(Constante.GRIS);
    CoBoutonSuppr cbs = new CoBoutonSuppr(this.calcu);
    suppr.addActionListener(cbs);
    this.boutons.add(suppr);
    this.boutons.add(new BoutonEcriture("4", calcu));
    this.boutons.add(new BoutonEcriture("5", calcu));
    this.boutons.add(new BoutonEcriture("6", calcu));
    this.boutons.add(new BoutonEcriture("+", calcu));
    JButton rep = new JButton("Rep");
    rep.setBackground(Constante.GRIS);
    CoBoutonRep cbr = new CoBoutonRep(this.calcu);
    rep.addActionListener(cbr);
    this.boutons.add(rep);
    this.boutons.add(new BoutonEcriture("1", calcu));
    this.boutons.add(new BoutonEcriture("2", calcu));
    this.boutons.add(new BoutonEcriture("3", calcu));
    this.boutons.add(new BoutonEcriture("-", calcu));
    JButton prec = new JButton("Prec");
    prec.setBackground(Constante.GRIS);
    CoBoutonPrec cbp = new CoBoutonPrec(this.calcu);
    prec.addActionListener(cbp);
    this.boutons.add(prec);
    this.boutons.add(new BoutonEcriture("0", calcu));
    this.boutons.add(new BoutonEcriture(".", calcu));
    JButton enter = new JButton("Enter");
    enter.setBackground(Constante.GRIS);
    CoBoutonEnter cbent = new CoBoutonEnter(this.calcu);
    enter.addActionListener(cbent);
    this.boutons.add(enter);

    CoKey ck = new CoKey(this.boutons);
    this.addKeyListener(ck);

    for (JButton be : this.boutons) {
      this.add(new IhmBouton(be));
    }
    this.add(new IhmBouton());
    this.add(new IhmBouton());
    this.add(new IhmBouton());
    this.requestFocus();
  }
}
