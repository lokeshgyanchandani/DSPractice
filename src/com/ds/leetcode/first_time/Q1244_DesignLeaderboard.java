package com.ds.leetcode.first_time;

import java.util.*;

class Leaderboard {

	private Map<Integer, Player> players;
	private Set<Player> scores;

	public Leaderboard() {
		players = new HashMap<>();
		scores = new TreeSet<>((a, b) -> {
			if (a.score == b.score) return a.playerId - b.playerId;
			else return a.score - b.score;
		});
	}

	public void addScore(int playerId, int score) {
		if (players.containsKey(playerId)) {
			Player currentPlayer = players.get(playerId);
			scores.remove(currentPlayer);
			currentPlayer.score += score;
			scores.add(currentPlayer);
		} else {
			Player newPlayer = new Player(playerId, score);
			players.put(playerId, newPlayer);
			scores.add(newPlayer);
		}
	}

	public int top(int K) {
		Iterator<Player> iterator = scores.iterator();
		int total = 0;
		while (iterator.hasNext() && K-- > 0)
			total += iterator.next().score;
		return total;
	}

	public void reset(int playerId) {
		Player currentPlayer = players.get(playerId);
		scores.remove(currentPlayer);
		currentPlayer.score = 0;
	}
}

class Player {
	int playerId;
	int score;

	public Player(int playerId, int score) {
		this.playerId = playerId;
		this.score = score;
	}
}

public class Q1244_DesignLeaderboard {

	public static void main(String[] args) {

	}
}
