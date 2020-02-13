
import java.util.Arrays;
import java.util.Random;


public class GrabBag<E> {
	private E[] contents;
	private int size=-1;
	private int top=-1;
	private int weight=-1;
	private Random rand = new Random();

	//constructor
	public GrabBag(int size){
		this.size=size;
		contents = (E[])new Object[size];
		weight=0;
	}


	//returns the item on top, removes the item, and changes the top to a new item
	public E grab(){
		if (top==-1){
			return null;
		}
		E returnValue=contents[top];
		remove();
		moveTop();
		return returnValue;
	}
	//randomizes the top
	public void shake(){
		moveTop();
	}
	
	//clears the bag
	public void empty(){
		contents = (E[])new Object[size];
		weight=0;
		top=-1;
	}
	
	//inserts the item into every empty slot
	public void fill(E item){
		for (int i=0; i<size; i++) {
			if (contents[i]==null) {
				contents[i]=item;
			}
		}
		weight=size;
	}
	//inserts an item into the bag
	public boolean add(E item){
		for (int i=0; i<size; i++){
			if (contents[i]==null){
				top=i;
				contents[i]=item;
				weight++;
				return true;
			}
		}
		size+=10;
		E[] array=(E[])new Object[size];
		System.arraycopy(contents, 0, array, 0, size-10);
		contents=array;
		for (int i=0; i<size; i++){
			if (contents[i]==null){
				top=i;
				contents[i]=item;
				weight++;
				return true;
			}
		}
		return false;
	}
	//returns how many items are in the bag
	public int weigh() {
		return weight;
	}
	//simply deletes an object and decrements weight
	private void remove(){
		if (top==-1){return;}
		contents[top]=null;
		weight--;
	}
	//prints every item in bag, used for debugging
	private void printAll() {
		for (int i=0; i<size; i++) {
			System.out.println(contents[i]);
		}
	}
	//moves the top to a new location with an item in it
	private void moveTop(){
		top=getWeightedRandom();
		for (int i=top; i>=0; i--) {
			if (contents[i]!=null) {
				top=i;
				return;
			}
		}
		for (int i=top; i<size; i++) {
			if (contents[i]!=null) {
				top=i;
				return;
			}
		}
		top=-1;
		return;
	}
	private int getWeightedRandom() {
		int j=rand.nextInt(size);
		if (j==0) {
			j++;
		}
		j=-1*j;
		j=(size/j)+size;
		return j; 
	}


	public static void main(String[] args) {

		
		return;





	}


}
