/**
* Cette classe est une classe représentant une calculatrice
*
* @author CHATEAU Julien
*@version 1.0
*/

package calculatrice;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import controleurs.*;
import composants.*;

public class Calculatrice extends JFrame {

  private JPanel tout;
  private Graphique graphique;
  private ConteneurBouton conteneurBouton;


  /** Constructeur de la classe Calculatrice
  */
  public Calculatrice() {
    super("Calculatrice");
    this.tout = new JPanel();
    this.tout.setLayout(new GridLayout(2, 1));

    JPanel tmpHaut = new JPanel();
    tmpHaut.setLayout(new BorderLayout());
    tmpHaut.add(new IhmBouton(), BorderLayout.NORTH);
    tmpHaut.add(new IhmBouton(), BorderLayout.SOUTH);
    tmpHaut.add(new IhmBouton(), BorderLayout.EAST);
    tmpHaut.add(new IhmBouton(), BorderLayout.WEST);
    this.graphique = new Graphique();
    tmpHaut.add(this.graphique, BorderLayout.CENTER);
    this.tout.add(tmpHaut);
    this.tout.add(tmpHaut, BorderLayout.NORTH);

    this.conteneurBouton = new ConteneurBouton(this);
    this.tout.add(this.conteneurBouton);
    this.tout.add(this.conteneurBouton, BorderLayout.CENTER);

    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    this.setPreferredSize(new Dimension(screen.width*30/100, screen.height*71/100));
    this.setLocation((screen.width - this.getPreferredSize().width)/2,(screen.height - this.getPreferredSize().height)/2);
    this.pack();
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setContentPane(this.tout);

    this.conteneurBouton.requestFocus();
  }


  public void reprendreFocus() {
    this.conteneurBouton.requestFocus();
  }


/*
* LES METHODES CI-DESSOUS PERMETTENT D'ACTIVER LES METHODES DE L'ATTRIBUT DE TYPE GRAPHIQUE DEPUIS CETTE CLASSES
*/

  public boolean getOperationSaved() {
    return this.graphique.getOperationSaved();
  }

  public void afficherDerniereOperation() {
    this.graphique.afficherDerniereOperation();
  }

  public void ajouterOperateur(String op) {
    this.graphique.ajouterOperateur(op);
  }

  public void setCompteurPrec(int i) {
    this.graphique.setCompteurPrec(i);
  }

  public void removeOperation() {
    this.graphique.removeOperation();
  }

  public void clearGraphique() {
    this.graphique.clear();
  }

  public boolean getResultatSaved() {
    return this.graphique.getResultatSaved();
  }

  public boolean estVide() {
    return this.graphique.affichageVide();
  }

  public boolean operationVide() {
    return this.graphique.operationVide();
  }

  public float getDernierResultat() {
    return this.graphique.getDernierResultat();
  }

  public boolean verifierExpression() {
    return this.graphique.verifierExpression();
  }

  public void calculerResultatExpression() {
    this.graphique.calculerResultatExpression();
  }

  public void afficherErreur(String erreur) {
    this.graphique.afficherErreur(erreur);
  }

  public void supprimerDernierOperateur() {
    this.graphique.supprimerOperateur();
  }

  /*
  * JUSQU'ICI
  */

  public static void main(String[] args) {
    new Calculatrice();
  }

}
