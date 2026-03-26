package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if (!vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		} else {
			String[] donnesEtals = controlLibererEtal.libererEtal(nomVendeur);
			boolean etalOccupe = Boolean.valueOf(donnesEtals[0]);
			if (etalOccupe) {
				StringBuilder chaine = new StringBuilder();
				chaine.append("Vous avez vendu ");
				chaine.append(donnesEtals[4]);
				chaine.append(" sur ");
				chaine.append(donnesEtals[3]);
				chaine.append(" ");
				chaine.append(donnesEtals[2]);
				chaine.append(".");
				System.out.println(chaine);
				chaine.setLength(0);
				chaine.append("En revoir ");
				chaine.append(nomVendeur);
				chaine.append(", passez une bonne journée");
				System.out.println(chaine);
			}
		}
	}

}
