class Solution {
    HashMap<Integer, List<Integer>> preMap = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++) preMap.put(i, new ArrayList<>());
        for(int[] prereq : prerequisites) preMap.get(prereq[0]).add(prereq[1]);
        for(int course = 0; course < numCourses; course++){
            if(!dfs(course)) return false;
        }
        return true;
    }
    public boolean dfs(int course){
        if(visited.contains(course)) return false;
        if(preMap.get(course).isEmpty()) return true;
        visited.add(course);
        for(int pre : preMap.get(course)){
            if(!dfs(pre)) return false;
        }
        visited.remove(course);
        preMap.put(course, new ArrayList<>());
        return true;
    }
}
