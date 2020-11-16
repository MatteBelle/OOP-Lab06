package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	private static long TO_ADD = 100_000;
	private static long TO_READ = 1000;
	private static long N_AFRICANS = 1_110_635_000L;
	private static long N_AMERICANS = 972_005_000L;
	private static long N_ANTARTICANS = 0L;
	private static long N_ASIANS = 4_298_723_000L; 
	private static long N_EUROPEANS = 742_452_000L;  
	private static long N_OCEANIANS = 38_304_000L;
	
    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
    	
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	final List<Integer> aL = new ArrayList<>();
    	for(int i=1000;i<2000;i++) {
    		aL.add(i);
    	}
    	/*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	final List<Integer> lL = new LinkedList<Integer>(aL);
    	System.out.println(lL);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	int temp = aL.get(0);
    	aL.set( 0 , aL.size() - 1);
    	aL.set( aL.size() - 1, temp);   	
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	System.out.print("array list : [ ");
    	for(int i : aL) {
    		System.out.print(i + ", ");
    	}
    	System.out.println("]");
    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */  	
    	double time = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
    		aL.add(0, i);
    	}
    	System.out.println("Nanoseconds to add " + TO_ADD + " elements in the head of Array List = "
    	+ (System.nanoTime() - time));
    	
       	time = System.nanoTime();
		for (int i = 0; i < TO_ADD; i++) {
    		lL.add(0, i);
    	}
		System.out.println("Nanoseconds to add " + TO_ADD + " elements in the head of Linked List = "
		+ (System.nanoTime() - time));

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
		time = System.nanoTime();
		for(int i = 0; i < TO_READ; i++) {
			aL.get(aL.size()/2);
		}
		System.out.println("Nanoseconds to read " + TO_READ + " elements in the middle of Array List = "
		+ (System.nanoTime() - time));

		time = System.nanoTime();
		for(int i = 0; i < TO_READ; i++) {
			lL.get(lL.size()/2);
		}
		System.out.println("Nanoseconds to read " + TO_READ + " elements in the middle of Linked List = "
		+ (System.nanoTime() - time));
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
		final Map<String, Long> world = new HashMap<>();
		world.put("Africa", N_AFRICANS);
		world.put("Americas", N_AMERICANS);
		world.put("Antarctica", N_ANTARTICANS);
		world.put("Asia", N_ASIANS);
		world.put("Europe", N_EUROPEANS);
		world.put("Oceania", N_OCEANIANS);
        /*
         * 8) Compute the population of the world
         */
		long worldPop = 0;
		for(long pop : world.values()) {
			worldPop += pop;
		}
		System.out.println("World population is about " + worldPop);
    }
}
