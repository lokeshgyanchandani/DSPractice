package com.ds.companies.microsoft.OA;

import java.util.HashSet;
import java.util.Set;

public class CyberSecurityTransmission {

    private int numCompromisedData(int[] transmission) {
        Set<Integer> currentORs = new HashSet<>();

        for (int trans : transmission) {
            Set<Integer> nextORs = new HashSet<>();

            for (int currentOR : currentORs) {
                int newValue = trans | currentOR;
                nextORs.add(trans | currentOR);
            }
        }

        return 0;
    }

    public static void main(String args[]) {
        CyberSecurityTransmission obj = new CyberSecurityTransmission();
    }
}
