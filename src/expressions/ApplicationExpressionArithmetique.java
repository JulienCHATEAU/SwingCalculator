package expressions;

import expressions.*;


/**
 * Classe pour réaliser des calculs sur des expressions arithmétiques.
 *
 * @author Solen Quiniou
 * @version 2017-09-22
 *
 */
public class ApplicationExpressionArithmetique {

	/**
	 * Méthode principale.
	 * @param args arguments du main.
	 */
	public static void main(String[] args) {

		String exprInfixeeStr2 = "2 ^ 5 + 6 * 9";
		// String exprInfixeeStr2 = "( 12 + 8 * ( 3 - 5 ) ) + 2.5 / 3";
		ExpressionArithmetiqueInfixee exprInfixee2 = new ExpressionArithmetiqueInfixee(exprInfixeeStr2);
		System.out.println("-> valeur = " + exprInfixee2.calculerResultatExpression());
	}

}


//(*, 5, (+, (*, (+, 19, 8), (*, 4, 6)), 7))
