class Solution {

    private Map<String,Queue<String>> ticketMap = new HashMap<>();
    private LinkedList<String> itinerary = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for (List<String> ticket : tickets){

            ticketMap.computeIfAbsent(
                ticket.get(0),
                k -> new PriorityQueue<String>()
            ).add(ticket.get(1));

        }

        dfs("JFK");

        return itinerary;
    }

    private void dfs(String from){
        Queue<String> destinations = ticketMap.get(from);

        while (destinations != null && !destinations.isEmpty()){
            String nextDestination = destinations.poll();
            dfs(nextDestination);
        }

        itinerary.addFirst(from);
        return;
    }


}
