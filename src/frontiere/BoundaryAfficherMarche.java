package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if (infosMarche.length == 0) {
			System.out.println( "Le marché est vide, revenez plus tard.");
		} else {
			StringBuilder chaine = new StringBuilder();
			chaine.append(nomAcheteur);
			chaine.append(", vous trouverez au marché : ");
			System.out.println(chaine);
			chaine.setLength(0);
			for (int i = 0; i < infosMarche.length; i++) {
				chaine.append("- ");
				chaine.append(infosMarche[i]);
				i++;
				chaine.append(" qui vend ");
				chaine.append(infosMarche[i]);
				i++;
				chaine.append(" produit");
				System.out.println(chaine);
			}
		}
	}
}
