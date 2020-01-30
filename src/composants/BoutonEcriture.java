/**
* Cette classe est une classe représentant un bouton d'écriture
*
* @author CHATEAU Julien
*@version 1.0
*/

package composants;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import calculatrice.*;
import controleurs.*;

public class BoutonEcriture extends JButton {

  private String valeur;
  private Calculatrice calcu;


  /** Constructeur de la classe BoutonEcriture
  @param valeur, la valeur que désigne le bouton
  @param calcu, la calculatrice auquel le bouton est associé
  */
  public BoutonEcriture(String valeur, Calculatrice calcu) {
    super(valeur);
    this.calcu = calcu;
    this.valeur = valeur;
    CoBoutonEcriture cbe = new CoBoutonEcriture(calcu);
    this.addActionListener(cbe);
    this.setBackground(Constante.GRIS);
  }


  /** Sélecteur permettant d'acceder à la valeur du bouton
  @return la valeur du bouton
  */
  public String getValeur() {
    return this.valeur;
  }
}
