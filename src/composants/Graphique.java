/**
* Cette classe est une classe représentant un graphique
*
* @author CHATEAU Julien
*@version 1.0
*/

package composants;

import java.util.*;
import javax.swing.*;
import calculatrice.*;
import expressions.*;
import automates.*;
import controleurs.*;
import java.awt.*;
import java.awt.event.*;

public class Graphique extends JPanel {

  private Analyseur analyseur;
  private Automate automate;
  private ExpressionArithmetiqueInfixee operation; /*L'opération courante*/
  private float resultat;
  private int compteurPrec;
  private boolean resultatSaved;
  private int x;
  private int y;
  private java.util.List<String> expressions;
  private java.util.List<String> expressionsSaved;


  /** Constructeur de la classe Graphique
  */
  public Graphique() {
    super();
    this.analyseur = new Analyseur();
    java.util.List<Integer> eFinaux = new ArrayList<Integer>();
    eFinaux.add(1);
    eFinaux.add(12);
    this.automate = new Automate(19, eFinaux, "A_exprArithm.txt");
    this.operation = new ExpressionArithmetiqueInfixee("");
    this.resultat = 0;
    this.resultatSaved = false;
    this.x = 15;
    this.y = 25;
    this.compteurPrec = 0;
    this.expressions = new LinkedList<String>();
    this.expressionsSaved = new LinkedList<String>();
    this.setPreferredSize(new Dimension(50, 75));
    this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Constante.GRIS));
    this.setBackground(Constante.GRIS_CLAIR);
  }

  /** Méthode qui affiche sur le graphique les 7 dernières expressions tapées par l'utilisateur
  */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    boolean vide = true;
    Font font15 = new Font("Arial", Font.BOLD ,15);
    g.setFont(font15);
    int taille = (this.expressions.size() >= 7) ? 6 : this.expressions.size()-1;
    for (int i = taille; i>=0; i--) {
      if (!this.expressions.get(this.expressions.size()-1-i).equals("")) {
        vide = false;
      }
      g.drawString(this.expressions.get(this.expressions.size()-1-i), this.x, this.y);
      this.y = this.y + 25;
    }
    if (vide) {
      for (int i = 0; i<this.expressions.size()-8; i++) {
        if (!this.expressionsSaved.contains(this.expressions.get(i))) {
          this.expressionsSaved.add(this.expressions.get(i));
        }
      }
      this.expressions.clear();
    }
    this.y = 25;
  }

  /** Méthode qui néttoie et remet à vide le graphique
  */
  public void clear() {
    for (int i = 0; i<7; i++) {
      this.expressions.add("");
    }
    this.removeAll();
    this.repaint();
  }


  /** Méthode qui permet de savoir si l'opération courante est vide
  @return true si l'opération courante est vide, false sinon
  */
  public boolean operationVide() {
    return this.operation.estVide();
  }


  /** Méthode qui permet de savoir si le graphique est vide
  @return true si le graphique est vide, false sinon
  */
  public boolean affichageVide() {
    boolean vide = false;
    if (this.expressions.size() == 0) {
      vide = true;
    } else {
      vide = true;
      int taille = (this.expressions.size() >= 7) ? 6 : this.expressions.size()-1;
      for (int i = taille; i>=0; i--) {
        if (!this.expressions.get(this.expressions.size()-1-i).equals("")) {
          vide = false;
        }
      }
    }
    return vide;
  }


  /**Méthode qui permet d'ajouter un caractère (chiffres ou opérateurs arithmétiques) à l'opération courante
  @return op l'opérateur ou le chiffre à ajouter à l'opération
  */
  public void ajouterOperateur(String op) {
    this.operation.ajouterOperateur(op);
    if (this.expressions.size() > 0 && this.expressions.size() % 2 == 1) {
      this.expressions.remove(this.expressions.size()-1);
    }
    this.expressions.add(this.operation.getExpression());
    this.removeAll();
    this.repaint();
  }

  /** Méthode qui vérifie si l'opération courante est bien formé
  @return true si elle est bien formé, false sinon
  */
  public boolean verifierExpression() {
    return this.analyseur.analyser(this.automate, this.operation.getExpression());
  }

  /** Méthode qui calcul et affiche le résultat de l'opération courante
  */
  public void calculerResultatExpression() {
    this.resultat = this.operation.calculerResultatExpression();
    this.resultatSaved = true;
    this.expressionsSaved.add(this.operation.getExpression());
    this.expressions.add(" = "+this.resultat);
    this.operation.removeExpression();
    this.removeAll();
    this.repaint();
  }

  /** Méthode qui permet de savoir si un résultat a été sauvegardé
  @return true si un résultat a été sauvegardé, false sinon
  */
  public boolean getResultatSaved() {
    return this.resultatSaved;
  }


  /** Méthode qui renvoie le dernier résultat sauvegardé
  @return le dernier résultat sauvegardé
  */
  public float getDernierResultat() {
    return this.resultat;
  }


  /** Méthode qui permet de savoir si au moins une opération a été sauvegardé
  @return true si au moins une opération a été sauvegardé, false sinon
  */
  public boolean getOperationSaved() {
    return this.expressionsSaved.size() > 0;
  }


  /** Méthode qui permet de changer le compteur du bouton précédent
  @param i la nouvelle valeur de compteurPrec
  */
  public void setCompteurPrec(int i) {
    this.compteurPrec = i;
  }


  /** Méthode qui permet d'afficher la dernière opération effectuée
  */
  public void afficherDerniereOperation() {
    this.operation.setExpression(this.expressionsSaved.get(this.expressionsSaved.size() - 1 - this.compteurPrec));
    if (this.expressions.size() > 0) {
      if (this.expressions.size() % 2 == 1) {
        this.expressions.remove(this.expressions.size()-1);
      }
    }
    this.expressions.add(this.operation.getExpression());
    if (this.compteurPrec < this.expressionsSaved.size()-1) {
      this.compteurPrec++;
    }
    this.removeAll();
    this.repaint();
  }


  /** Méthode qui permet de supprimer le dernier opérateur (chiffres ou opérateurs arithmétiques) de l'opération courante
  */
  public void supprimerOperateur() {
    this.operation.supprimerOperateur();
    if (this.expressions.size() > 0 && this.expressions.size() % 2 == 1) {
      this.expressions.remove(this.expressions.size()-1);
    }
    this.expressions.add(this.operation.getExpression());
    this.removeAll();
    this.repaint();
  }


  /** Méthode qui permet de vider le contenu de l'opération courante
  */
  public void removeOperation() {
    this.operation.removeExpression();
    if (this.expressions.size() > 0 && this.expressions.size() % 2 == 1) {
      this.expressions.remove(this.expressions.size()-1);
    }
    this.removeAll();
    this.repaint();
  }

  /** Méthode qui permet d'afficher une Erreur
  @param erreur la description de l'erreur en question
  */
  public void afficherErreur(String erreur) {
    this.expressions.add("Erreur : "+erreur);
    this.operation.removeExpression();
    this.removeAll();
    this.repaint();
  }
}
