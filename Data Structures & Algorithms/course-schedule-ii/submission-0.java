class Solution {
    HashMap<Integer, List<Integer>> adj = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    HashSet<Integer> cycles = new HashSet<>();
    List<Integer> output = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int course = 0; course < numCourses; course++) adj.put(course, new ArrayList<>());
        for(int[] prereq : prerequisites) adj.get(prereq[0]).add(prereq[1]);
        for(int course = 0; course < numCourses; course++){
            if(!dfs(course)) return new int[0];
        }
        int[] res = new int[numCourses];
        res = output.stream().mapToInt(i -> i).toArray();
        return res;
    }
    public boolean dfs(int course){
        if(cycles.contains(course)) return false;
        if(visited.contains(course)) return true;
        cycles.add(course);
        for(int prereq : adj.get(course)){
            if(!dfs(prereq)) return false;
        }
        cycles.remove(course);
        visited.add(course);
        output.add(course);
        return true;
    }
}
