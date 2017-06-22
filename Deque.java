public class Deque<Item> implements Iterable<Item> {

 private Node first;                //first node in dequeue
 private Node last;                 //last node in dequeue
 private int length;                //length of dequeue

 public Deque() {                  //default constructor
  first = null;                    //no node in dequeue yet
  last = null;       
  length = 0;
 }

 public boolean isEmpty() {
  return length == 0;                //if dequeue is empty
 }

 public int size() {               //to get the length of dequeue 
  return length;
 }

 public void addFirst(Item item) {
  if (item == null)                                    //if null node added
   throw new NullPointerException();
  if (length == 0) {                                  //if no node in dequeue yet
   Node newNode = new Node();                         //create a node
   newNode.i = item;                                  //put an item in it
   newNode.left = null;
   newNode.right = null;
   first = newNode;                                       //first and last references points to newNode(the only node in dequeue yet)
   last = newNode;    
   length++;                                               //increment lenght of dequue
  } else {                                                //if there exists a node earlier in dequeue 
   Node newNode = new Node();                                //create a new node
   newNode.i = item;     
   newNode.right = null;                                 //no item to the right of newNode yet
   newNode.left = first;                               //put first data item to the first of newNode
   first.right = newNode;                               //put newNode to the right of newNode
   first = newNode;                                    //make newNode the first
   length++;                                            //increment length of dequeue
  }
 }

 public void addLast(Item item) {                       //add data item to the end of dequeu
  if (item == null)                                     //if user adds no item
   throw new NullPointerException();
  if (length == 0) {                                    //if no node yet
   Node newNode = new Node();                          //create new node
   newNode.i = item;                //item in newNode
   newNode.left = null;          //no item to left of newNode 
   newNode.right = null;          //or right of newNode
   first = newNode;               //so newNode is the first node
   last = newNode;                //....and last node as well
   length++;                      //increment length
  } else {                  //if there exists an iten earlier in dequeue
   Node newNode = new Node();   //create a new node
   newNode.i = item;           //put a data item in it
   newNode.right = last;                                         //put it just b4 last node
   newNode.left = null;                                        // no node b4 it
   last.left = newNode;    
   last = newNode;                                            //make newNode the last
   length++;
  }
 }

 public Item removeFirst() {                                       //to remove first item
  if (isEmpty())                                                  //is dequeue empty?
   throw new java.util.NoSuchElementException();
  if (length == 1) {                                                //if only one node in dequeue
   Item item = first.i;                                             //create a data item and add it to it
   first = null;                                                    //no item b4 newNode  
   last = null;                                                     //no last item
   length--;
   return item;
  } 
  else {
   Item item = first.i;                                            //put data item in first iten
   Node temp = first.left;                                         //temp points to the node b4 left
   first.left.right = null;                                        //.. and no node to the right of left
   first.left = null;                                              //so no node to the left of first 
   first = temp;                                                   //make temp point to first
   length--;                                                       //move down dequeue
   return item;
  }
 }

 public Item removeLast() {                                      //
  if (isEmpty())
   throw new java.util.NoSuchElementException();
  if (length == 1) {
   Item item = first.i;
   first = null;
   last = null;
   length--;
   return item;
  } else {
   Item item = last.i;
   Node temp = last.right;
   last.right.left = null;
   last.right = null;
   last = temp;
   length--;
   return item;
  }
 }

 public static void main(String[] args) {
  // TODO Auto-generated method stub
 
 }

 @Override
 public Iterator<Item> iterator() {
  // TODO Auto-generated method stub
  return new ListIterator();
 }

 private class Node {
  private Node left;
  private Node right;
  private Item i;
 }

 private class ListIterator implements Iterator<Item> {
  
  private Node ptr;
  private Item i;
  
  public ListIterator()
  {
   ptr = first;
  }

  @Override
  public boolean hasNext() {
   // TODO Auto-generated method stub
   if (ptr == null)
    return false;
   else
    return true;
  }

  @Override
  public Item next() {
   // TODO Auto-generated method stub
   if (!hasNext())
    throw new java.util.NoSuchElementException();
   else {
    i = ptr.i;
    ptr = ptr.left;
    return i;
   }

  }

  public void remove() {
   throw new UnsupportedOperationException();
  }

 }
}

