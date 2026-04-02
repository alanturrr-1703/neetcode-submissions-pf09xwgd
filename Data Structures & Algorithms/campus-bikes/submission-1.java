class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < workers.length; i++){
            for(int j = 0; j < bikes.length; j++){
                int dist = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                list.add(new int[] {dist, i, j});
            }
        }
        Collections.sort(list, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            if(a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });
        int[] res = new int[workers.length];
        Arrays.fill(res, -1);
        boolean[] bikeUsed = new boolean[bikes.length];
        for(int[] worker : list){
            int workerIdx = worker[1];
            int bikeIdx = worker[2];

            if(res[workerIdx] == -1 && !bikeUsed[bikeIdx]){
                res[workerIdx] = bikeIdx;
                bikeUsed[bikeIdx] = true;
            }
        }
        return res;
    }
}
