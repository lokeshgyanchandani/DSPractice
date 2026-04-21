package com.ds.companies.amazon.leetcode.OA;

import java.util.Arrays;

public class Hackathon {

    public static int maxTeams(int[] skill, int teamSize, int maxDiff) {
        // Sort the skill levels
        Arrays.sort(skill);

        int teamCount = 0;
        int i = 0;

        // Try to form teams
        while (i <= skill.length - teamSize) {
            // Check the difference between the smallest and largest skill in the team
            if (skill[i + teamSize - 1] - skill[i] <= maxDiff) {
                teamCount++;
                i += teamSize; // Form a team and move the pointer forward by teamSize
            } else {
                i++; // If we can't form a team, move to the next member
            }
        }

        return teamCount;
    }

    public static void main(String[] args) {
        int[] skill = {3, 4, 3, 1, 6, 5};
        int teamSize = 3;
        int maxDiff = 2;

        System.out.println("Maximum number of teams: " + maxTeams(skill, teamSize, maxDiff));
    }
}
