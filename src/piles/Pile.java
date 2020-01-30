/**
* Cette classe estune classe de pile
*
* @author CHATEAU Julien
*@version 1.0
*/
package piles;

import java.util.*;

public class Pile<E> {

  private List<E> pile;

  /**constructeur de la classe Pile
  */
  public Pile() {
    this.pile = new LinkedList<E>();
  }


  /** selecteur qui permer d'acceder à la pile
  @return la pile
  */
  public List<E> getPile() {
    return this.pile;
  }


  /** selecteur qui permer d'acceder à la taille de la pile
    @return la taille de la pile
  */
  public int nombreElement() {
    return this.pile.size();
  }


  /** selecteur qui permer d'acceder à l'élement au sommet de la pile
    @return l'élement au sommet de la pile
  */
  public E getSommet() {
    return this.pile.get(this.nombreElement()-1);
  }

  public void inverser() {
    List<E> inverse = new LinkedList<E>();
    for (int i = this.pile.size()-1; i>= 0; i--) {
      inverse.add(this.pile.get(i));
    }
    this.pile = inverse;
  }


  /** methode qui permer de savoir si la pile est vide
  @return true si la pile est vide, false sinon
  */
  public boolean pileVide() {
    return (this.nombreElement() == 0);
  }


  /** methode qui permer d'empiler un element dans la pile
  @param element qui représente l'element à empiler
  */
  public void empiler(E element) {
    this.pile.add(element);
  }


  /** methode qui permer de dépiler un element de la pile
  @return l'élement dépilé
  */
  public E depiler() {
    return this.pile.remove(this.nombreElement()-1);
  }

  public String toString() {
    String res = "Pile (";
    for (E element : this.pile) {
      res += element.toString() + " | ";
    }
    return res.substring(0, res.length()-3) + ")";
  }

}
