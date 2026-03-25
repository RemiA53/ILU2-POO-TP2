package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean NomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!NomVendeurConnu) {
			StringBuilder chaineVendeurInconnu = new StringBuilder();
			chaineVendeurInconnu.append("Je suis désolée ");
			chaineVendeurInconnu.append(nomVendeur);
			chaineVendeurInconnu.append(" mais il faut être un habitant de notre village pour commercer ici.\n");
			System.out.println(chaineVendeurInconnu.toString());
		} else {
			StringBuilder chaineVendeurConnu = new StringBuilder();
			chaineVendeurConnu.append("Bonjour ");
			chaineVendeurConnu.append(nomVendeur);
			chaineVendeurConnu.append(", je vais regarder si je peux vous trouver un étal.\n");
			System.out.println(chaineVendeurConnu.toString());
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if (!etalDisponible) {
				StringBuilder chaineEtalIndisponible = new StringBuilder();
				chaineEtalIndisponible.append("Désolée ");
				chaineEtalIndisponible.append(nomVendeur);
				chaineEtalIndisponible.append(" je n'ai plus d'étal qui ne soit pas déjà occupé.\n");
				System.out.println(chaineEtalIndisponible.toString());
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder chaineQuestion = new StringBuilder();
		chaineQuestion.append("C'est parfait, il me reste un étal pour vous !\n");
		chaineQuestion.append("Il me faudrait quelques renseignements :\n");
		chaineQuestion.append("Quel produit souhaitez-vous vendre ?\n");
		String produit = Clavier.entrerChaine(chaineQuestion.toString());
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?\n");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal != -1) {
			StringBuilder chaineInstallation = new StringBuilder();
			chaineInstallation.append("Le vendeur ");
			chaineInstallation.append(nomVendeur);
			chaineInstallation.append(" s'est installé à l'étal n°");
			numeroEtal++;
			chaineInstallation.append(numeroEtal);
			System.out.println(chaineInstallation.toString());
		}
	}
}
