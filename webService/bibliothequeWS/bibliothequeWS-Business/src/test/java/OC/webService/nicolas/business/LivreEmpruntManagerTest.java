// package OC.webService.nicolas.business;
//
// import java.util.Calendar;
// import java.util.Optional;
//
// import org.junit.After;
// import org.junit.AfterClass;
// import org.junit.Before;
// import org.junit.BeforeClass;
// import org.junit.Test;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.mockito.MockitoAnnotations;
// import org.springframework.beans.factory.annotation.Autowired;
//
// import OC.webService.nicolas.business.contract.LivreEmpruntManager;
// import OC.webService.nicolas.consumer.DaoFactoryImpl;
// import OC.webService.nicolas.model.entites.Livre;
// import OC.webService.nicolas.model.entites.LivreEmprunt;
// import OC.webService.nicolas.model.entites.Utilisateur;
//
// public class LivreEmpruntManagerTest {
//
// private LivreEmpruntManager manager;// = new LivreEmpruntManagerImpl();
// private int id;
// private static Optional<LivreEmprunt> monOptionnal;
//
// @Mock // (answer = Answers.RETURNS_DEEP_STUBS)
// private DaoFactoryImpl daoFacto;
// // @Mock
// // private ILivreEmpruntDao livreEmpruntDao;
//
// @BeforeClass
// public static void setUpBeforeClass() throws Exception {
// Calendar cal = Calendar.getInstance();
// cal.setTime(cal.getTime());
// cal.add(Calendar.DAY_OF_MONTH, -29);
//
// LivreEmprunt monEmprunt = new LivreEmprunt(cal.getTime(), false);
// monEmprunt.setId(1);
// monEmprunt.setLivre(new Livre("Titre", "Genre",
// Calendar.getInstance().getTime(), 2));
// monEmprunt.setUtilisateur(new Utilisateur("Nom", "prenom", "pseudo", "mdp"));
//
// monOptionnal.of(monEmprunt);
// }
//
// @AfterClass
// public static void tearDownAfterClass() throws Exception {
// }
//
// @Before
// public void setupMock() {
// MockitoAnnotations.initMocks(this);
// Mockito.when(this.daoFacto.getLivreEmpruntDao().findById(this.id)).thenReturn(monOptionnal);
//
// // this.ab.setDaoFactory(this.daoFacto);
// }
//
// @Before
// public void setUp() throws Exception {
// }
//
// @After
// public void tearDown() throws Exception {
// }
//
// @Test
// public void testEmprunterOuvrage() {
// // fail("Not yet implemented");
// }
//
// @Test
// public void testRetournerOuvrage() {
// // fail("Not yet implemented");
// }
//
// @Test(expected = RuntimeException.class)
// public void testProlongerEmprunt() {
//
// // LivreEmprunt
//
// this.manager.prolongerEmprunt(1);
// // fail("Not yet implemented");
// }
//
// @Test
// public void testFindByIdEmprunt() {
// // fail("Not yet implemented");
// }
//
// @Test
// public void testObtenirRetardataires() {
// // fail("Not yet implemented");
// }
//
// @Test
// public void testObtenirEmpruntUtilisateur() {
// // fail("Not yet implemented");
// }
//
// @Test
// public void testObtenirTitreEmprunte() {
// // fail("Not yet implemented");
// }
//
// @Test
// public void testObtenirListeRappelRetour() {
// // fail("Not yet implemented");
// }
//
// public LivreEmpruntManager getManager() {
// return this.manager;
// }
//
// @Autowired
// public void setManager(LivreEmpruntManager manager) {
// this.manager = manager;
// }
//
// }
