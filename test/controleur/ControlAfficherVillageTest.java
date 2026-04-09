package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracoucrix;
	private ControlAfficherVillage controlAfficherVillage;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("Village", 10, 10);
		abraracoucrix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracoucrix);
		controlAfficherVillage = new ControlAfficherVillage(village);
	}

	@Test
	void testControlAfficherVillage() {
		assertNotNull(controlAfficherVillage);
	}

	@Test
	void testDonnerNomsVillageois() {
		String[] expected = {"Abraracourcix"};
		System.out.println(controlAfficherVillage.donnerNomsVillageois());
		assertEquals(expected, controlAfficherVillage.donnerNomsVillageois());
		expected[1] = "Bonemine";
		assertNotEquals(expected, controlAfficherVillage.donnerNomsVillageois());
		Gaulois bonemine = new Gaulois("Bonemine",3);
		village.ajouterHabitant(bonemine);
		assertEquals(expected, controlAfficherVillage.donnerNomsVillageois());
	}

	@Test
	void testDonnerNomVillage() {
		fail("Not yet implemented");
	}

	@Test
	void testDonnerNbEtals() {
		fail("Not yet implemented");
	}

}
