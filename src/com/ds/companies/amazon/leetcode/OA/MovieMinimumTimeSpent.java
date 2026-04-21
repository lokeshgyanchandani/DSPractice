package com.ds.companies.amazon.leetcode.OA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Complexity:
 *      Sorting: O(nlogn) + O(mlogm)
 *      Two-pointer traversal: O(n + m)
 *      Overall: O(nlogn + mlogm)
 */
class Movie {
    int releaseTime;
    int duration;

    Movie(int releaseTime, int duration) {
        this.releaseTime = releaseTime;
        this.duration = duration;
    }
}

public class MovieMinimumTimeSpent {
    public static int minimumTimeSpent(int[] comedyReleaseTime, int[] comedyDuration,
                                       int[] dramaReleaseTime, int[] dramaDuration) {
        int n = comedyReleaseTime.length;
        int m = dramaReleaseTime.length;

        List<Movie> comedyMovies = new ArrayList<>();
        List<Movie> dramaMovies = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            comedyMovies.add(new Movie(comedyReleaseTime[i], comedyDuration[i]));
        }

        for (int i = 0; i < m; i++) {
            dramaMovies.add(new Movie(dramaReleaseTime[i], dramaDuration[i]));
        }

        // Sort by release time
        comedyMovies.sort(Comparator.comparingInt(a -> a.releaseTime));
        dramaMovies.sort(Comparator.comparingInt(a -> a.releaseTime));

        int minTime = Integer.MAX_VALUE;
        int i = 0, j = 0;

        while (i < n && j < m) {
            // Try watching comedy first, then drama
            int comedyEndTime = Math.max(comedyMovies.get(i).releaseTime, 0) + comedyMovies.get(i).duration;
            int dramaStartTime = Math.max(dramaMovies.get(j).releaseTime, comedyEndTime);
            int finishTime1 = dramaStartTime + dramaMovies.get(j).duration;

            // Try watching drama first, then comedy
            int dramaEndTime = Math.max(dramaMovies.get(j).releaseTime, 0) + dramaMovies.get(j).duration;
            int comedyStartTime = Math.max(comedyMovies.get(i).releaseTime, dramaEndTime);
            int finishTime2 = comedyStartTime + comedyMovies.get(i).duration;

            minTime = Math.min(minTime, Math.min(finishTime1, finishTime2));

            // Move forward in the list with the earlier end time
            if (comedyEndTime < dramaEndTime) {
                i++;
            } else {
                j++;
            }
        }

        return minTime;
    }

    public static void main(String[] args) {
        int[] comedyReleaseTime = {1, 4};
        int[] comedyDuration = {3, 2};
        int[] dramaReleaseTime = {5, 2};
        int[] dramaDuration = {2, 2};

        System.out.println(minimumTimeSpent(comedyReleaseTime, comedyDuration, dramaReleaseTime, dramaDuration)); // Output: 6
    }
}
