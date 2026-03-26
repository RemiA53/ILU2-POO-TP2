package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder chaineVillageois = new StringBuilder();
					chaineVillageois.append("Bienvenue villageois ");
					chaineVillageois.append(nomVisiteur);
					System.out.println(chaineVillageois);
					int force = Clavier.entrerEntier("Quelle est votre force ?");
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		int force = Clavier.entrerEntier("Quelle est votre force ?");
		int effetPotionMin = Clavier.entrerEntier("Quelle est la force de potion la plus faible que vous produisez ?");
		int effetPotionMax = Clavier.entrerEntier("Quelle est la force de potion de la plus forte que vous produisez ?");
		while (effetPotionMax < effetPotionMin) {
			System.out.println("Attention Druide, vous vous �tes tromp� entre le minimum et le maximum\n");
			effetPotionMin = Clavier.entrerEntier("Quelle est la force de potion la plus faible que vous produisez ?");
			effetPotionMax = Clavier.entrerEntier("Quelle est la force de potion de la plus forte que vous produisez ?");
		}
		controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMin, effetPotionMax);
		
	}
}
