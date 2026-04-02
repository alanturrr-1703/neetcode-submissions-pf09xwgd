class Solution {
    HashMap<Integer, List<Integer>> PreMap = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++) PreMap.put(i, new ArrayList<>());
        for(int[] prereq : prerequisites) PreMap.get(prereq[0]).add(prereq[1]);
        for(int course = 0; course < numCourses; course++){
            if(!dfs(course)) return false;
        }
        return true;
    }
    public boolean dfs(int course){
        if(visited.contains(course)) return false;
        if(PreMap.get(course).isEmpty()) return true;
        visited.add(course);
        for(int pre : PreMap.get(course)){
            if(!dfs(pre)) return false;
        }
        visited.remove(course);
        PreMap.put(course, new ArrayList<>());
        return true;
    }
}
