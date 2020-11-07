package com.ds.companies.amazon.leetcode;

public class CutOffRank {

	public int CutOffRank(int cutOffRank, int num, int[] scores) {
		int[] count = new int[101];
		for (int s : scores) // count numbers of players for each score 0 - 100
		{
			count[s]++;
		}
		int rank = 1;
		// start from score rank and assign rank based on number of players found for a particular rank
		for (int i = count.length - 1; i >= 0; i--) {
			if (count[i] != 0) {
				int counts = count[i];
				count[i] = rank;
				rank += counts; // increment current rank by number of players for this score
			}
		}
		int numPlayers = 0;
		for (int s : scores) // for each score check whether rank is below threshold
		{
			if (count[s] <= cutOffRank && s > 0)
				numPlayers++;
		}

		return numPlayers;
	}

	public static void main(String[] args) {

	}
}
