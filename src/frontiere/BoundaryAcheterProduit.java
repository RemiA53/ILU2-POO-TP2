package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean acheteurReconnu = controlAcheterProduit.VerifierIdentite(nomAcheteur);
		if (!acheteurReconnu) {
			StringBuilder chaine = new StringBuilder();
			chaine.append("Je suis désolée ");
			chaine.append(nomAcheteur);
			chaine.append(" mais il faut être un habitant de notre village pour commercer ici.");
			System.out.println(chaine);
		} else {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			//TODO VerifProduit
			
		}
	}
}
