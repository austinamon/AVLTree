import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class AVLTest<E extends Comparable<E>> extends BST<E> {

	public static void main(String[] args) {
		
		
		ArrayList<Integer> testList = new ArrayList<Integer>();
		ArrayList<Integer> randList = new ArrayList<Integer>();
		Random rando = new Random();
		for (int i = 0; i < 99999; i++) {
			testList.add(i);
		}
		for (int i = 0; i < 99999; i++) {
			randList.add(rando.nextInt());
		}
		BST<Integer> bstree = new BST<Integer>();
		AVLTree<Integer> avltree = new AVLTree<Integer>();
		long start = System.currentTimeMillis();
		timeTests(testList, bstree);
		long end = System.currentTimeMillis();
		long start2 = System.currentTimeMillis();
		timeTests(testList, avltree);
		long end2 = System.currentTimeMillis();
		
		long start3 = System.currentTimeMillis();
		timeTests(randList, bstree);
		long end3 = System.currentTimeMillis();
		long start4 = System.currentTimeMillis();
		timeTests(randList, avltree);
		long end4 = System.currentTimeMillis();
		
		System.out.println("Using BST on 100000 inorder elements:    " + (end-start)/1000.000 + " seconds");
		System.out.println("Using AVLTree on 100000 inorder elements:    " + (end2-start2)/1000.000 + " seconds");
		System.out.println("Using BST on 100000 random elements:    " + (end3-start3)/1000.000 + " seconds");
		System.out.println("Using AVLTree on 100000 random elements:    " + (end4-start4)/1000.000 + " seconds");
	}
	public static void timeTests(ArrayList<Integer> testList, BST<Integer> tree) {
		for (Integer i : testList) {
			tree.add(i);
		}
		Collections.shuffle(testList);
		for (Integer i : testList) {
			tree.search(i);
		}
		Collections.shuffle(testList);
		for (Integer i : testList) {
			tree.delete(i);
		}
		
	}

}
