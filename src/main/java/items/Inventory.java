package items;

import containers.LinkedList;


/**
 * An Inventory is composed of n slots. Each slot may store only
 * one type of item--specified by *slots*.
 * <p>
 * Once all slots are filled, no additional Item types may be
 * stored. Individual slots may contain any number of the same
 * Item--if the Item is stackable.
 */
public class Inventory
{
    /**
     * This is the Default Inventory size.
     */
    public static final int DEFAULT_SIZE = 10;

    /**
     * This is utility function that takes two ItemStacks and adds the
     * number of items in the right-hand side stack to the left-hand side stack.
     *
     * @param lhs stack whose size will be increased
     * @param rhs stack whose size we need to examine
     */
    public static void mergeStacks(ItemStack lhs, ItemStack rhs)
    {
        // lhs needs to have items added to it.
        // rhs's size is needed
        // lhs.????(rhs.????)
        this.data = d;
        this.next = null
    int lhsSize = lhs.getSize();
    int rhsSize = rhs.getSize();
    
    int maxStackSize = lhs.getMaxStackSize();


    int totalSize = lhsSize + rhsSize;

    if (totalSize <= maxStackSize) {
        lhs.setSize(totalSize); 
        rhs.setSize(0);  
    } 
    else {
        lhs.setSize(maxStackSize);  // Fill lhs to the max
        rhs.setSize(totalSize - maxStackSize);  // Remainder stays in rhs
    }
    }

    /**
     * Individual item slots--each ItemStack occupies one slot.
     */
    private LinkedList<ItemStack> slots;

    /**
     * Total number of distinct Item types that can be stored.
     */
    private int capacity;

    /**
     * Default to an inventory with 10 slots.
     */
    public Inventory()
    {
        this(DEFAULT_SIZE);
    }

    /**
     * Create an inventory with n slots.
     *
     * @param desiredCapacity size of the new Inventory
     */
    public Inventory(int desiredCapacity)
    {
        this.slots    = new LinkedList<ItemStack>();
        this.capacity = desiredCapacity;
    }

    /**
     * Determine the number of slots currently in use.
     */
    public int utilizedSlots()
    {
        return this.slots.currentSize;
    }

    /**
     * Determine the number of empty (unused) slots.
     */
    public int emptySlots()
    {
        return this.totalSlots() - this.utilizedSlots();
    }

    /**
     * Retrieve the capacity (number of distinct types of items) that this
     * inventory can store.
     */
    public int totalSlots()
    {
        return this.capacity;
    }

    /**
     * Determine if the inventory is considered full.
     *
     * @return true if the current size is equal to capacity
     */
    public boolean isFull()
    {
        // Replace the next line
        return true;
        /// return this.utillizedSlotes() >=this.capacity
    }

    /**
     * Determine if the inventory is empty.
     *
     * @return true if current size is zero
     */
    public boolean isEmpty()
    {
        return this.slots.currentSize == 0;
    }

    /**
     * Search through all slots (Nodes in the LinkedList) and look for a
     * matching ItemStack.
     *
     * @param key stack for which the search is being conducted
     *
     * @return matching stack if one was found and `null` otherwise
     */
    public ItemStack findMatchingItemStack(ItemStack key)
    {
        // Add the necessary sequential search loop
         if(!(key instanceof Item))
            return false
         Item keyItem = (Item) key
        return null;
    }

    /**
     * This is the standard Linked List append operation from Review 01
     *
     * @param toAdd data that we want to store in a Node and add to the list
     */
    public void addItemStackNoCheck(ItemStack toAdd)
    {
        LinkedList.Node<ItemStack> newNode = new LinkedList.Node<>(toAdd);
         // If adding the first Node
        if (this.slots.head == null) {
            this.slots        = newNode;
        } else {
        LinkedList.Node<ItemStack> current = this.slots.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    this.slots.currentSize++; 
//// or write as a loop 

        // Use the appendNode/add logic from Review 1 as your starting point
        // Once we reach this function... we know that `toAdd` must be stored
    }

    /**
     * Add one or more items to the inventory list.
     *
     * @param stack new stack of items to add
     *
     * @return true if *stack* was added and false otherwise
     */
    public boolean addItems(ItemStack stack)
    {
        ItemStack match = this.findMatchingItemStack(stack);

        // if a match was found
        if (match != null) {
            // If the Item is stackable, add it to the ItemStack
            if (match.permitsStacking()) {
                mergeStacks(match, stack);
                 
                return true;
            }
        }

        if (this.slots.currentSize < capacity) {
            this.addItemStackNoCheck(stack);
            return true;
        }

        return false;
    }

    /**
     * *Print* a Summary of the Inventory and all Items contained within.
     */
    @Override
    public String toString()
    {
        String summaryLine = String.format(
            " -Used %d of %d slots%n", this.slots.currentSize, this.capacity
        );

        StringBuilder strBld = new StringBuilder();
        strBld.append(summaryLine);

        LinkedList.Node<ItemStack> it = this.slots.head;

        while (it != null) {
            String itemLine = String.format("  %s%n", it.data);
            strBld.append(itemLine);

            it = it.next;
        }

        return strBld.toString();
    }
}
