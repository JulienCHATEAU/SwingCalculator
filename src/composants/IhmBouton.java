/**
* Cette classe est une classe permettant de stocker un bouton dans un JPanel
*
* @author CHATEAU Julien
*@version 1.0
*/

package composants;

import java.util.*;
import javax.swing.*;
import calculatrice.*;
import java.awt.*;

public class IhmBouton extends JPanel {


  public IhmBouton(JButton b) {
    super();
    this.setBackground(Constante.BEIGE);
    this.setLayout(new GridBagLayout());
    this.add(b);
  }

  public IhmBouton() {
    super();
    this.setBackground(Constante.BEIGE);
    this.setBorder(BorderFactory.createMatteBorder(15, 15, 15, 15, Constante.BEIGE));
    this.setLayout(new GridBagLayout());
  }

  public void paintComponent(Graphics g) {
		super.paintComponent(g);
  }
}
