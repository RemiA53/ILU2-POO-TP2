package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 1, village);
		village.setChef(abraracourcix);
	}
		
	@Test
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		assertNotNull(controlEmmenager, "Constructeur renvoie pas null");
	}

	@Test
	void testIsHabitant() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		assertFalse(controlEmmenager.isHabitant("Qui ???"));
		controlEmmenager.ajouterDruide("Panoramix", 10, 20, 30);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
	}

	@Test
	void testAjouterDruide() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		assertTrue(village.trouverHabitant("Panoramix")==null);
		controlEmmenager.ajouterDruide("Panoramix", 1, 0, 10);
		assertTrue(village.trouverHabitant("Panoramix")!=null);
	}

	@Test
	void testAjouterGaulois() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		assertTrue(village.trouverHabitant("Bonemine")==null);
		controlEmmenager.ajouterGaulois("Bonemine", 1);
		assertTrue(village.trouverHabitant("Bonemine")!=null);
	}
	
}
