package week2lab;

public interface List<T>{
  /*
    This method is used to check if the linkedlist is empty
  */
  public boolean isEmpty();
  /*
    This method should count the number of ojects within the linkedlist
  */
  public int size();
  /*
    This method is designed to produce a string representation of the elements
    withing the linkedList.
  */
  public String toString();
  /*
    This method adds an element to the list in the desired position
  */
  public void add(int index, T el);
  /*
    This method is designed to check if an element is in the linkedList.
  */
  public boolean contains(T target);
  /*
    This method adds an element to the list in the position
    previous to the first occurrence of the the target
    element
  */
  public void addBefore(T target, T element);
  /*
    This method adds an element to the list in the position
    after to the first occurrence of the the target
    element
  */
  public void addAfter(T target, T element);
  /*
    This method removes an element from the list if present.
  */
  public T remove(T target);
}
