public class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {	        
    	int price1 = noSpecial(price, needs);
	List<Integer> result = new ArrayList<>();
	result.add(price1);
	for (List<Integer> offer : special) {
	    boolean flag = true;
	    List<Integer> next = new ArrayList<>();
	    for (int j = 0; j < offer.size() - 1; j++) {
		int nextNeed = needs.get(j) - offer.get(j);
		if (nextNeed < 0) {
		    flag = false;
		}
		next.add(nextNeed);
	    }
	    if (flag) {
		int min = shoppingOffers(price, special, next) + offer.get(offer.size() - 1);
		result.add(min);
	    }
	}
	int minimum = Integer.MAX_VALUE;
	for (int i : result) {
	    minimum = Math.min(minimum, i);
	}
	return minimum;
	
    }
    public int noSpecial(List<Integer> price, List<Integer> needs) {
    	int sum = 0;
	for (int i = 0; i < needs.size(); i++) {
	    sum += price.get(i) * needs.get(i);
	}
	return sum;
    }
}
