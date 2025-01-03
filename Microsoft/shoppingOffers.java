class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // this map will help us to differntiate between each possible state of dp
        // solution
        // telling which item is selcted and how much it is remaining in our needs list
        // every state will have it own cost
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return minCost(price, special, needs, memo);
    }

    private int minCost(List<Integer> price, List<List<Integer>> special, List<Integer> needs,
            Map<List<Integer>, Integer> memo) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }
        // calculating base cost we get after we do simple purchases without any offers
        // every new needs array will be calculated as our needs list will be updated
        // everytime
        int cost = calcCost(price, needs);

        for (List<Integer> offer : special) {
            boolean valid = true;
            List<Integer> newNeeds = new ArrayList<>(needs);

            for (int i = 0; i < price.size(); i++) {
                // checking if our current offer is valid or not depending on our current needs
                // list
                if (offer.get(i) > newNeeds.get(i)) {
                    valid = false;
                    break;
                }
                newNeeds.set(i, newNeeds.get(i) - offer.get(i));
            }
            // the base would be this as there would be no further recusions when all
            // elements are zero or one
            // of them is zero
            if (valid) {
                cost = Math.min(cost, offer.get(price.size()) + minCost(price, special, newNeeds, memo));
            }
        }

        memo.put(needs, cost);
        return cost;
    }

    private int calcCost(List<Integer> price, List<Integer> needs) {
        int cost = 0;
        for (int i = 0; i < price.size(); i++) {
            cost += price.get(i) * needs.get(i);
        }
        return cost;
    }
}