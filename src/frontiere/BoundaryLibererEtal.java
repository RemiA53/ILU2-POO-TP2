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
				StringBuilder chaineLibererEtal = new StringBuilder();
				chaineLibererEtal.append("Vous avez vendu ");
				chaineLibererEtal.append(donnesEtals[4]);
				chaineLibererEtal.append(" sur ");
				chaineLibererEtal.append(donnesEtals[3]);
				chaineLibererEtal.append(" ");
				chaineLibererEtal.append(donnesEtals[2]);
				chaineLibererEtal.append(".");
				System.out.println(chaineLibererEtal);
				StringBuilder chaineFinLibererEtal = new StringBuilder();
				chaineFinLibererEtal.append("En revoir ");
				chaineFinLibererEtal.append(nomVendeur);
				chaineFinLibererEtal.append(", passez une bonne journée");
				System.out.println(chaineFinLibererEtal);
			}
		}
	}

}
