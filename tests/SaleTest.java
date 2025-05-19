package se.kth.iv1350.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.integration.ItemDTO;

public class SaleTest {
    private Sale sale;
    private ItemDTO item1;
    private ItemDTO item2;

    @BeforeEach
    public void setUp() {
        sale = new Sale();
        item1 = new ItemDTO("001", 0.1, "Milk", 10);
        item2 = new ItemDTO("002", 0.15, "Bread", 20);
    }

    @Test
    public void testAddItemToItemListAddsNewItemCorrectly() {
        sale.addItemToItemList(item1);

        List<SoldItem> items = sale.getList();
        assertEquals(1, items.size());
        assertEquals(item1.getItemID(), items.get(0).getItem().getItemID());
    }

    @Test
    public void testAddItemToItemListIncreasesQuantityForDuplicateItem() {
        sale.addItemToItemList(item1);
        sale.addItemToItemList(item1);

        SoldItem soldItem = sale.getItem(0);
        assertEquals(2, soldItem.getQuantity());
    }

    @Test
    public void testAddItemToItemListUpdatesRunningTotalAndTax() {
        sale.addItemToItemList(item1); // price = 10, tax = 1
        sale.addItemToItemList(item2); // price = 20, tax = 3

        assertEquals(30.0, sale.getRunningTotal(), 0.0);
        assertEquals(4.0, sale.getTotalTax(), 0.0);
    }


}
