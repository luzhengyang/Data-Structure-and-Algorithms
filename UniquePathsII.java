// Follow up for "Unique Paths":

// Now consider if some obstacles are added to the grids. How many unique paths would there be?

// An obstacle and empty space is marked as 1 and 0 respectively in the grid.

// For example,
// There is one obstacle in the middle of a 3x3 grid as illustrated below.

// [
//   [0,0,0],
//   [0,1,0],
//   [0,0,0]
// ]
// The total number of unique paths is 2.


public class UniquePathsII{
	public int uniquePathsWithObstacles(int[][] obstacleGrid){
		if(obstacleGrid == null || obstacleGrid.length == 0){
			return 0;
		}

		int row = obstacleGrid.length;
		int col = obstacleGrid[0].length;
		int[][] dp = new int[row][col];

		if(obstacleGrid[0][0] == 1){
			return 0;
		}
		else{
			dp[0][0] = 1;
		}

		for(int i=0; i<row; i++){
			if(obstacleGrid[i][0] == 0){
				dp[i][0] = 1;
			}
			else{
				break;
			}
		}

		for(int j=0; j<row; j++){
			if(obstacleGrid[j][0] == 0){
				dp[j][0] = 1;
			}
			else{
				break;
			}
		}

		for(int i=1; i<row; i++){
			for(int j=1; j<col; j++){
				if(obstacleGrid[i][j] == 1){
					dp[i][j] = 0;
				}
				else{
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
		}

		return dp[row-1][col-1];
	}
}
