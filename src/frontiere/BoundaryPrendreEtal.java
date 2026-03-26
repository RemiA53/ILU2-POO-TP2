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
			StringBuilder chaine = new StringBuilder();
			chaine.append("Je suis désolée ");
			chaine.append(nomVendeur);
			chaine.append(" mais il faut être un habitant de notre village pour commercer ici.");
			System.out.println(chaine);
			chaine.setLength(0);
		} else {
			StringBuilder chaine = new StringBuilder();
			chaine.append("Bonjour ");
			chaine.append(nomVendeur);
			chaine.append(", je vais regarder si je peux vous trouver un étal.");
			System.out.println(chaine);
			chaine.setLength(0);
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if (!etalDisponible) {
				chaine.append("Désolée ");
				chaine.append(nomVendeur);
				chaine.append(" je n'ai plus d'étal qui ne soit pas déjà occupé.");
				System.out.println(chaine);
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder chaine = new StringBuilder();
		chaine.append("C'est parfait, il me reste un étal pour vous !\n");
		chaine.append("Il me faudrait quelques renseignements : ");
		System.out.println(chaine);
		chaine.setLength(0);
		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal != -1) {
			chaine.append("Le vendeur ");
			chaine.append(nomVendeur);
			chaine.append(" s'est installé à l'étal n°");
			numeroEtal++;
			chaine.append(numeroEtal);
			System.out.println(chaine);
			chaine.setLength(0);
		}
	}
}
