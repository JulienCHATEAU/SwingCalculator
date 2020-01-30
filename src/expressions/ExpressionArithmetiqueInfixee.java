package expressions;

import java.util.*;
import java.lang.*;
import piles.*;


/**
* Classe ExpressionArithmetiqueInfixee.
* Classe pour représenter une expression arithmétique sous la forme d'une String
*
* @author CHATEAU Julien
* @version 1.0
*
*/
public class ExpressionArithmetiqueInfixee {

	private String _expression;

	/**
	* Constructeur à partir d'une chaîne de caractères contenant l'expression.
	* @param s l'expression arithmétique sous forme de chaîne de caractères.
	*/
	public ExpressionArithmetiqueInfixee(String s) {
		this._expression = s;
	}


	/**
	* Accesseur de l'expression.
	* @return l'expression arithmétique sous forme de chaîne de caractères.
	*/
	public String getExpression() {
		return _expression;
	}

	public boolean estVide() {
		return this._expression.equals("");
	}

	/**
	* Méthode qui ajoute un opérateur (ou un chiffre) à l'expression
	* @param op l'opérateur (ou chiffre) à ajouter
	*/
	public void ajouterOperateur(String op) {
		if (this._expression.length() == 0 || (!this.estUnOperateur(op) && !this.estUnOperateur(String.valueOf(this._expression.charAt(this._expression.length()-1))))) {
			this._expression += op;
		} else if (this._expression.charAt(this._expression.length()-1) == '-' && (this._expression.length() == 1 || this._expression.charAt(this._expression.length()-3) == '(')) {
			this._expression += op;
		} else {
			this._expression += " " + op;
		}
	}


	/**
	* Méthode qui affecte un valeur à l'attribut expression
	* @param exp la valeur a affecter à l'attribut expression
	*/
	public void setExpression(String exp) {
		this._expression = exp;
	}


	/**
	* Méthode qui réinitialise l'expression
	*/
	public boolean estUnOperateur(String str) {
		return str.equals("*") || str.equals("/") || str.equals("-") || str.equals("+") || str.equals("^") || str.equals("(") || str.equals(")");
	}


	/**
	* Méthode qui réinitialise l'expression
	*/
	public void removeExpression() {
		this._expression = "";
	}


	/**Méthode qui calcul de résultat de l'expression entière
	@return le résultat de l'expression
	*/
	public float calculerResultatExpression() {
		while (this.possedeParenthese()) {// On calcul toutes les sous-expressions entre parentheses (celles qui sont prioritaires)
			this.premierCalculExpression();
		}
		return this.calculSansParenthese(this._expression); // On calcul le résultat de l'expression simplifiée sans parenthèse
	}


	/**
	* Méthode qui permet de savoir si l'expression possède des parentheses
	@return true si elle possède des parentheses, false sinon
	*/
	public boolean possedeParenthese() {
		return this._expression.indexOf('(') >= 0;
	}


	/**
	* Méthode qui permet de savoir si l'expression possède des parentheses
	@return true si elle possède des parentheses, false sinon
	*/
	public void supprimerOperateur() {
		if (this._expression.length() > 0) {
			if (this._expression.length() > 1 && this._expression.charAt(this._expression.length()-2) == ' ') {
				this._expression = this._expression.substring(0, this._expression.length()-2);
			} else {
				this._expression = this._expression.substring(0, this._expression.length()-1);
			}
		}
	}


	/**
	* Méthode qui permet d'effectuer le premier calcul (rioritaire) dans l'expression
	*/
	public void premierCalculExpression() {
		System.out.println("premierCalculExpression début : " + this._expression);
		boolean trouve = false;
		char courant = ' ';
		int i = 0;
		int posLastOpened = 0;
		int posFirstClosed = 0;
		String premierCalcul = "";
		String resPremierCalcul = "";
		String gauche = "";
		String droite = "";
		while (!trouve) {
			courant = this._expression.charAt(i);
			if (courant == '(') {
				posLastOpened = i; // on sauvegarde la position de la dernière parenthèse ouvrante
			}
			if (courant == ')') {
				posFirstClosed = i;// on sauvegarde la position de la première parenthèse fermante
				trouve = true;
			}
			i++;
		}
		System.out.println("posLastOpened variable = " + posLastOpened);
		System.out.println("posFirstClosed variable = " + posFirstClosed);
		for (int j = posLastOpened+2; j<posFirstClosed-1; j++) {
			premierCalcul += this._expression.charAt(j); // on récupère l'expression dans les parenthèses précédement sauvegardées
		}
		System.out.println("premierCalcul variable = " + premierCalcul);
		resPremierCalcul = this.calculSansParenthese(premierCalcul) + ""; // on effectue le calcul de cette sous-expression
		//puis on remet le résultat à la place de cette sous-expression dans l'expression générale
		gauche = this._expression.substring(0, posLastOpened);// en séparant la partie gauche
		droite = this._expression.substring(posFirstClosed+1, this._expression.length());// et la partie droite de l'expression générale
		this._expression = gauche + resPremierCalcul + droite;// puis en concaténant les 3 parties
		System.out.println("premierCalculExpression fin : " + this._expression);
	}


	/** Méthode qui permet de faire un calcul à partir d'une expression sans parenthese
	* Pré-condition : l'expression ne doit pas comporter de parenthèses
	@param calcul l'expression à calculer
	@return le résultat du calcul
	*/
	public float calculSansParenthese(String calcul) {
		System.out.println("calculSansParenthese début : " + calcul);
		Pile<String> pile = new Pile<String>();
		StringTokenizer strTok = new StringTokenizer(calcul);
		float res = 0;
		boolean empile = false;
		String next = "";
		while (strTok.hasMoreTokens()) {// on parcourt notre expression et on empile chaque caractère
			empile = false;
			next = strTok.nextToken();
			if (next.equals("^") && !pile.pileVide()) { // si on tombe sur un '^', c'est prioritaire vis à vis du '*' et du '/'
					String gauche = pile.depiler();
					String droite = strTok.nextToken();
					pile.empiler(this.calculSimple(gauche, next, droite) + "");//donc on effectue le calcul avant de l'empiler. Dans le but de n'avoir que des '+' et '-' dans la pile
					empile = true;
				}
			if ((next.equals("*") || next.equals("/")) && !pile.pileVide()) {// si on tombe sur un '*' ou un '/', c'est prioritaire vis à vis du '+' et du '-'
				String gauche = pile.depiler();
				String droite = strTok.nextToken();
				pile.empiler(this.calculSimple(gauche, next, droite) + "");// donc on effectue le calcul avant de l'empiler. Dans le but de n'avoir que des '+' et '-' dans la pile
				empile = true;
			}
			if (!empile) {
				pile.empiler(next);
			}
		}
		pile.inverser();// quand on a que des nombres et des '+' et '-' dans la pile, on l'inverse pour pouvoir dépiler dand l'ordre de calcul (de gauche à droite)
		while (pile.nombreElement() != 1) {
			String gauche = pile.depiler();
			String op = pile.depiler();
			String droite = pile.depiler();
			pile.empiler(this.calculSimple(gauche, op, droite) + "");
		}
		res = Float.parseFloat(pile.depiler());// Il reste dans la pile le résultat de l'expression générale
		System.out.println("calculSansParenthese fin : " + res);
		return res;// que l'on retourne
	}


	/** Methode qui permet de faire un calcul entre 2 nombres avec les opérateurs
			d'addition, de multiplication, de division, de soustraction et de puissance
	Exemple : 5 + 6
	12 / 98.5
	2 ^ 5
	ect
	@param gauche le nombre à gauche de l'opérateur
	@param op l'opérateur
	@param droite le nombre à droite de l'opérateur
	@return le résultat du calcul
	*/
	public float calculSimple(String gauche, String op, String droite) {
		System.out.println("calculSimple début : " + gauche + op + droite);
		float gaucheFlt = Float.parseFloat(gauche);
		float droiteFlt = Float.parseFloat(droite);
		float res = 0;
		if (op.equals("+")) {
			res = gaucheFlt + droiteFlt;
		} else if (op.equals("-")) {
			res = gaucheFlt - droiteFlt;
		} else if (op.equals("*")) {
			res = gaucheFlt * droiteFlt;
		} else if (op.equals("/")) {
			res = gaucheFlt / droiteFlt;
		} else {
			res = (float)Math.pow((double)gaucheFlt, (double)droiteFlt);
		}
		System.out.println("calculSimple fin : " + res);
		return res;
	}
}
