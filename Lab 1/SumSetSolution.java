package lession1.prob6.sumset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SumSetSolution {

	public static List<Set> sumSet(Set<Integer> setInt, int k) {
		List<Set> p = powerSet(setInt);
		List<Set> subsets = p.stream().filter(s -> isSubSumSet(s, k)).collect(Collectors.toList());
		return subsets;
	}

	private static boolean isSubSumSet(Set<Integer> setInt, int k) {
		int setSum = setInt.stream().reduce(0,(a,b) -> a+b);
		if (setSum == k) return true;
		return false;
	}
	
//	static List<Set> powerSet (Set<Integer> set) {
//		List<Set> sets = new ArrayList<>();
//		Set<Integer> emptySet = new HashSet<>();
//		sets.add(emptySet);
//		Set<Integer> newSet = new HashSet<>();
//		List<Integer> setRemain = set.stream().collect(Collectors.toList());
//
//		for (Integer i : setRemain) {
//			List<Set> newSets = new ArrayList<>();
//			for (Set<Integer> s : sets) {
//				newSets.add(s);
//				newSet = new HashSet<>();
//				newSet.addAll(s);
//				newSet.add(i);
//				newSets.add(newSet);
//			}
//			sets = newSets;
//		}
//		return sets;
//	}

	
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(1); 
        set.add(3); 
        set.add(9); 
        set.add(4); 
        set.add(8); 
        set.add(5); 
        List<Set> p = sumSet(set, 21);
        p.stream().forEach(e -> System.out.println(e));
        
	}
}
