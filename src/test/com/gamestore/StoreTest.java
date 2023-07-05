package test.com.gamestore;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import com.gamestore.Store;
import com.gamestore.models.Game;

public class StoreTest {
    private Store store;
    private Game game1;
    private Game game2;
    private Game game3;

    @Before
    public void setup() {
        store = new Store();
        game1 = new Game("Super Mario Odyssey", "Platformer", "Nintendo Switch", 10, 49.99);
        game2 = new Game("The Last of Us Part II", "Action-Adventure", "PlayStation 4", 5, 59.99);
        game3 = new Game("Cyberpunk 2077", "RPG", "PC", 8, 39.99);

        store.addGameToCatalog(game1);
        store.addGameToCatalog(game2);
        store.addGameToCatalog(game3);
    }

    @Test
    public void testAddGameToCatalog() {
        Game game4 = new Game("New Game", "Genre", "Platform", 3, 29.99);
        store.addGameToCatalog(game4);

        Assert.assertEquals(4, store.getCatalog().size());
        Assert.assertTrue(store.getCatalog().contains(game4));
    }

    @Test
    public void testBuyGameSufficientQuantity() {
        store.buyGame("Super Mario Odyssey", 2);

        Assert.assertEquals(8, game1.getQuantity());
        Assert.assertEquals(2, store.getInventory().size());
        Assert.assertEquals("Super Mario Odyssey", store.getInventory().get(0).getTitle());
        Assert.assertEquals(2, store.getInventory().get(0).getQuantity());
    }

    @Test
    public void testBuyGameInsufficientQuantity() {
        store.buyGame("The Last of Us Part II", 10);

        Assert.assertEquals(5, game2.getQuantity());
        Assert.assertEquals(0, store.getInventory().size());
    }

    @Test
    public void testSellGameSufficientQuantity() {
        store.buyGame("Super Mario Odyssey", 5);
        store.sellGame("Super Mario Odyssey", 3);

        Assert.assertEquals(7, game1.getQuantity());
        Assert.assertEquals(2, store.getInventory().get(0).getQuantity());
        Assert.assertEquals(1, store.getInventory().size());
    }

    @Test
    public void testSellGameInsufficientQuantity() {
        store.buyGame("The Last of Us Part II", 5);
        store.sellGame("The Last of Us Part II", 10);

        Assert.assertEquals(0, game2.getQuantity());
        Assert.assertEquals(0, store.getInventory().size());
    }

    @Test
    public void testGenerateReport() {
        store.buyGame("Super Mario Odyssey", 3);
        store.buyGame("The Last of Us Part II", 2);
        store.sellGame("Super Mario Odyssey", 1);

        Assert.assertEquals(49.99 + 49.99 + 59.99, store.getTotalRevenue(), 0.01);
    }
}
