package runtime;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Stack;
import util.RandomPermutations;
import java.util.*;


public class SortTester {
	private final String PACKAGE = "sortroutines";
	private final String FILENAME = "sorters_to_be_run.txt";
	private final int[] ARRAY_SIZES = {500,1000,4000, 5000}; //only four different sizes allowed
	private final int NUM_TESTS = 40;
	private int numSortRoutines = 0;
	private int[][][] testArrays;
	private TreeMap<Long,String> results = new TreeMap<Long,String>();
	private Stack<Sorter> sorters;
	public static void main(String[] args){
		SortTester st = new SortTester();
		st.runTests();
	}
	
	public SortTester() {
		sorters = new Stack<Sorter>();
		
		try{
			BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
			String line = null;
			while( (line = reader.readLine()) != null) {
				Sorter next = createInstance(line);
				sorters.push(next);
			}
			reader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	private void loadTestArrays(int numRoutines) {
		testArrays = new int[numRoutines][NUM_TESTS][];
		for(int k = 0; k < numRoutines; ++k ){
			for(int j = 0; j < NUM_TESTS/4; ++j){
				if(k==0){
					testArrays[k][j] = RandomPermutations.nextArray2(ARRAY_SIZES[0]);
				}
				else {
					testArrays[k][j] = new int[ARRAY_SIZES[0]];
					for(int i = 0; i < ARRAY_SIZES[0]; ++i){
						testArrays[k][j][i] = testArrays[0][j][i];
					}
				}
			}
			for(int j = NUM_TESTS/4; j < NUM_TESTS/2; ++j){
				if(k==0){
					testArrays[k][j] = RandomPermutations.nextArray2(ARRAY_SIZES[1]);
				}
				else {
					testArrays[k][j] = new int[ARRAY_SIZES[1]];
					for(int i = 0; i < ARRAY_SIZES[1]; ++i){
						testArrays[k][j][i] = testArrays[0][j][i];
					}
				}
			}	
			for(int j = NUM_TESTS/2; j < 3*NUM_TESTS/4; ++j){
				if(k==0){
					testArrays[k][j] = RandomPermutations.nextArray2(ARRAY_SIZES[2]);
				}
				else {
					testArrays[k][j] = new int[ARRAY_SIZES[2]];
					for(int i = 0; i < ARRAY_SIZES[2]; ++i){
						testArrays[k][j][i] = testArrays[0][j][i];
					}
				}
			}	
			for(int j = 3*NUM_TESTS/4; j < NUM_TESTS; ++j){
				if(k==0){
					testArrays[k][j] = RandomPermutations.nextArray2(ARRAY_SIZES[3]);
				}
				else {
					testArrays[k][j] = new int[ARRAY_SIZES[3]];
					for(int i = 0; i < ARRAY_SIZES[3]; ++i){
						testArrays[k][j][i] = testArrays[0][j][i];
					}
				}
			}				
			
		}
		
	}
	public void runTests() {
		numSortRoutines=sorters.size();
		loadTestArrays(numSortRoutines);		

		long start = 0L;
		long finish = 0L;
		int sortIndex = -1;
		long[] nextTimeArr = null;
		while(!sorters.isEmpty()) {
			Sorter nextSorter = sorters.pop();
			nextTimeArr = new long[NUM_TESTS];
			sortIndex++;
			for(int i = 0; i < NUM_TESTS; ++i){
				start = time();
				nextSorter.sort(testArrays[sortIndex][i]);
				finish = time();
				//System.out.println(Arrays.toString(newarr));
				/* debugging 
				if(i==5 || i ==15){
					System.out.println(Arrays.toString(testArrays[0][i]));
				}*/
				nextTimeArr[i] = finish-start;
			}
			String name = util.Util.getClassNameNoPackage(nextSorter.getClass());
			results.put(sum(nextTimeArr),name);
		}
		showResults();
	}
	public void showResults() {
		Set<Long> keySet = results.keySet();
		List<Long> list = new ArrayList<Long>(keySet);
		//Collections.sort(list);
		//TreeMap specs guarantee sorted order
		for(int i = 0; i < list.size(); ++i){
			Long time = list.get(i);
			String classname = results.get(time);
			System.out.println((time/1000000)+" ms -> "+ classname);
		}
	
	}
	private long sum(long[] arr) {
		long accum = 0L;
		for(long e: arr){
			accum += e;
		}
		return accum;
	}

	
	private Sorter createInstance(String className) throws Exception {
		className = PACKAGE+"."+className;
		Class cl = Class.forName(className);
		Object ob = cl.newInstance();
		return (Sorter)ob;
		
	}

	static long time() {
		return System.nanoTime();
		//return System.currentTimeMillis();
	}
}

