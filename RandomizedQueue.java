import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

 private Item items[];
 private int length;

 public RandomizedQueue() {
  items = (Item[]) new Object[2];
  length = 0;
 }

 public boolean isEmpty() {
  return length == 0;
 }

 public int size() {
  return length;
 }

 public void enqueue(Item item) {
  if (item == null)
   throw new NullPointerException();
  if (length == items.length)
   resize(items.length * 2);
  items[length] = item;
  length++;
 }

 public Item dequeue() {
  if (isEmpty())
   throw new java.util.NoSuchElementException();
  int n = (int) (Math.random() * length);
  Item i = items[n];
  if (n != length - 1)
   items[n] = items[length - 1];
  length--;
  if (length > 0 && length == items.length / 4)
   resize(items.length / 2);
  return i;
 }

 private void resize(int n) {
  Item newItem[] = (Item[]) new Object[n];
  for (int i = 0; i < length; i++)
   newItem[i] = items[i];
  items = newItem;
 }

 public Item sample() {
  if (isEmpty())
   throw new java.util.NoSuchElementException();
  int n = (int) (Math.random() * length);
  Item i = items[n];
  return i;
 }

 @Override
 public Iterator<Item> iterator() {
  // TODO Auto-generated method stub
  return new ListIterator();
 }

 private class ListIterator<Item> implements Iterator {
  
  int index;

  public ListIterator() {
   index = 0;
  }

  @Override
  public boolean hasNext() {
   // TODO Auto-generated method stub
   return index <= length - 1;
  }

  @Override
  public Object next() {
   // TODO Auto-generated method stub
   if (!hasNext())
    throw new java.util.NoSuchElementException();
   int n = (int) (Math.random()*(length-index));
   Object item = items[n];
   if(n != length-index-1)
    items[n] = items[length-index-1];
   index++;
   return item;
  }

  public void remove() {
   throw new UnsupportedOperationException();
  }

 }

 public static void main(String[] args) {
  // TODO Auto-generated method stub

 }
}
