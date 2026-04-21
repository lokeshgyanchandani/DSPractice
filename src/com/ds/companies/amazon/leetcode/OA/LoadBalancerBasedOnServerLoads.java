package com.ds.companies.amazon.leetcode.OA;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancerBasedOnServerLoads {

    public static List<Integer> findRequestTarget(int num_servers, int[] requests) {
        int[] serverLoad = new int[num_servers]; // Array to track server loads
        List<Integer> result = new ArrayList<>();

        for (int request : requests) {
            int targetServer = 0;
            int minLoad = Integer.MAX_VALUE;

            // Find the server with the least load in range [0, request]
            for (int i = 0; i <= request; i++) {
                if (serverLoad[i] < minLoad) {
                    minLoad = serverLoad[i];
                    targetServer = i;
                }
            }

            result.add(targetServer);
            serverLoad[targetServer]++; // Increase the load on the assigned server
        }

        return result;
    }

    public static void main(String[] args) {
        int num_servers = 5;
        int[] requests = {3, 2, 3, 2, 4};

        List<Integer> output = findRequestTarget(num_servers, requests);
        for (int server : output) {
            System.out.println(server);
        }
    }
}
