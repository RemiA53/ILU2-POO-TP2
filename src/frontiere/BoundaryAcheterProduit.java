package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean acheteurReconnu = controlAcheterProduit.verifierIdentite(nomAcheteur);
		
		if (!acheteurReconnu) {
			StringBuilder chaine = new StringBuilder();
			chaine.append("Je suis d�sol�e ");
			chaine.append(nomAcheteur);
			chaine.append(" mais il faut �tre un habitant de notre village pour commercer ici.");
			System.out.println(chaine);
		} else {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			Gaulois[] vendeurs = controlAcheterProduit.produitVenduMarche(produit);
			boolean isProduitVendu = vendeurs.length != 0;
			
			if (!isProduitVendu) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			} else {
				StringBuilder chaine = new StringBuilder();
				chaine.append("Chez quel commerçant voulez-vous acheter des ");
				chaine.append(produit);
				chaine.append(" ?\n");
				for (int i = 1; i < vendeurs.length+1; i++) {
					chaine.append(i);
					chaine.append(" - ");
					chaine.append(vendeurs[i-1].getNom());
				}
				int choix = Clavier.entrerEntier(chaine.toString());
				String nomVendeur = vendeurs[choix-1].getNom();
			
				chaine.setLength(0);
				chaine.append(nomAcheteur);
				chaine.append(" se déplace jusqu'à l'étal du vendeur ");
				chaine.append(nomVendeur);
				chaine.append("\nBonjour ");
				chaine.append(nomAcheteur);
				chaine.append("\nCombien de ");
				chaine.append(produit);
				chaine.append(" voulez-vous acheter ?");
				int quantiteAVendre = controlAcheterProduit.approcherEtal(nomVendeur);
				int quantiteVoulu = Clavier.entrerEntier(chaine.toString());
				chaine.setLength(0);
				int quantiteAchete = controlAcheterProduit.acheterProduit(nomVendeur, quantiteVoulu);
				if (quantiteAchete == 0) {
					chaine.append(nomAcheteur);
					chaine.append(" veut acheter ");
					chaine.append(quantiteVoulu);
					chaine.append(" ");
					chaine.append(produit);
					chaine.append(", malheureusement il n'en y a plus !");
					System.out.println(chaine.toString());
				} else if (quantiteAchete == quantiteAVendre) {
					chaine.append(nomAcheteur);
					chaine.append(" veut acheter ");
					chaine.append(quantiteVoulu);
					chaine.append(" ");
					chaine.append(produit);
					chaine.append(", malheureusement ");
					chaine.append(nomVendeur);
					chaine.append(" n'en a plus que ");
					chaine.append(quantiteAVendre);
					chaine.append(". ");
					chaine.append(nomAcheteur);
					chaine.append(" achète tout le stock de ");
					chaine.append(nomVendeur);
					System.out.println(chaine.toString());
					
				} else {
					chaine.append(nomAcheteur);
					chaine.append(" achète ");
					chaine.append(quantiteAchete);
					chaine.append(" ");
					chaine.append(produit);
					chaine.append(" à ");
					chaine.append(nomVendeur);
					System.out.println(chaine.toString());
				} 
				
			}
			
		}
	}
}
