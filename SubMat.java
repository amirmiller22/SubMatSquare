
class SubMat 
{ 

	// A function that finds the maximum square of the sub-matrix that contains the same values.
	// The function returns the indexes of the bottom right corner of the sub-matrix and the size of the sub-matrix sqare.
	static void largestKSubmatrix(int [][]mat, int n, int m) 
	{ 
		
		int index_i = 0, index_j= 0, max = 0;
		int [][]dp = new int [n][m]; 
		int result = 0; 
		for (int i = 0 ; i < n ; i++) 

		{ 
			for (int j = 0 ; j < m ; j++) 

			{ 
				// If elements is at top 
				// n or first column, 
				// it wont form a square 
				// matrix's bottom-right 
				if (i == 0 || j == 0) 
					dp[i][j] = 1; 

				else
				{ 
					// Check if adjacent 
					// elements are equal 
					if (mat[i][j] == mat[i - 1][j] && 
							mat[i][j] == mat[i][j - 1] && 
							mat[i][j] == mat[i - 1][j - 1]) 
					{ 
						dp[i][j] = (dp[i - 1][j] > dp[i][j - 1] && 
								dp[i - 1][j] > dp[i - 1][j - 1] + 1) ? 
										dp[i - 1][j] : 
											(dp[i][j - 1] > dp[i - 1][j] && 
													dp[i][j - 1] > dp[i - 1][j - 1] + 1) ? 
															dp[i][j - 1] : 
																dp[i - 1][j - 1] + 1; 
					}			 

					// If not equal, then it 
					// will form a 1x1 submatrix 
					else dp[i][j] = 1; 
				} 

				// Update result at each (i,j) 
				
				result = result > dp[i][j] ? result : dp[i][j];

			} 

		}
		// Find the maximum in the matrix to know the indexes.
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				if(dp[i][j] > max){
				max = dp[i][j];
				index_i = i;
				index_j = j;
			}
		}
		}
			
		System.out.println("The bottom right corner of the Maximum Square Indexes is:" + "mat[" + index_i + "]" + "[" + index_j +"]");
		System.out.println("The size of the square is:" + result + "X" + result); 
	
	}
	 
	public static void main(String[] args) 
	{ 
		int [][]mat = {{5, 5, 3, 3, 4, 4}, 
				       {5, 5, 7, 7, 7, 4}, 
				       {5, 5, 7, 7, 7, 8}, 
				       {4, 4, 7, 7, 7, 8}, 
				       {5, 5, 9, 8, 2, 8}, 
				       {5, 5, 8, 8, 8, 8}}; 
		

		largestKSubmatrix(mat, 6, 6);
		
	} 
} 

 
