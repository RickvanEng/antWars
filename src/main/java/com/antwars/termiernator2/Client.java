package com.antwars.termiernator2;

import java.awt.List;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Client {

	private static int MAX_SCORE = 0;

	// Use these variables to name your bot
	private static String PLAYER_NAME = "DrakeTheSnake";
	private static String BOT_NAME = "The_Creeper";
	private static String BOT_VERSION = "1.0.0";

	// Store your player & game ID that AntWars assigned to you
	private static String PLAYER_ID;
	private static String GAME_ID;

	public static void main(String[] args) throws org.apache.http.ParseException, IOException {
		System.out.println("Game started!");

		JsonObject response = joinGame();
		setGame(response);
		playGame();

		System.out.println("Game Ended max points reached: " + MAX_SCORE);
	}

	public static JsonObject joinGame() {
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			HttpPost request = new HttpPost("http://antwars.azurewebsites.net/api/game/start");
			StringEntity params = new StringEntity("{\"playerName\": \"" + PLAYER_NAME + "\",\"botName\": \""
					+ PLAYER_NAME + "\",\"botVersion\": \"" + BOT_VERSION + "\"}");
			request.addHeader("content-type", "application/json");
			request.addHeader("Accept", "application/json");
			request.setEntity(params);
			HttpResponse response = httpClient.execute(request);
			String json = EntityUtils.toString(response.getEntity());
			JsonObject jsonGameState = (JsonObject) new JsonParser().parse(json);

			System.out.println("Successfully connected to http://antwars.azurewebsites.net/api/game/start");
			return jsonGameState;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}

	public static void setGame(JsonObject jsonGameState) throws org.apache.http.ParseException, IOException {
		PLAYER_ID = jsonGameState.get("playerId").getAsString();
		GAME_ID = jsonGameState.get("id").getAsString();

		System.out.println("We are assigned the player id: " + PLAYER_ID + " for game: " + GAME_ID);

	}

	public static void playGame() throws org.apache.http.ParseException, IOException {
		boolean gameOver = false;

		while (gameOver != true) {
			// Get your best next moves from your Game Engine.
			/// You can check the API for allowed moves and their format.

			StringEntity dummyMoves = MainClass.setData();
			JsonObject newGameState = sendMove(dummyMoves);

			// Go to next turn
			System.out.println("\nCURRENT TURN: " + newGameState.get("turn"));
			// use the new Game information to keep your Game up to date
			updateGame(newGameState);

		}
	}

	public static JsonObject sendMove(StringEntity moves) {
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			String url = ("http://antwars.azurewebsites.net/api/game/" + GAME_ID + "/move/" + PLAYER_ID);
			HttpPost move = new HttpPost(url);
			move.setHeader("content-type", "application/json");
			move.addHeader("Accept", "application/json");
			move.setEntity(moves);
			HttpResponse reply = httpClient.execute(move);

			System.out.println("Moves have been successfully sended!");
			String jReply = EntityUtils.toString(reply.getEntity());
			JsonObject j = (JsonObject) new JsonParser().parse(jReply);
			return j;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}

	public static void updateGame(JsonObject newGameState) {
		System.out.println(newGameState.toString());
		
		MainClass.turn = newGameState.get("turn").getAsInt();

		// This is dummy behaviour to show how to access game state information.
		// You might want to incorporate this info in your Game object.
		int gameState = newGameState.get("state").getAsInt();
		JsonArray units = newGameState.get("units").getAsJsonArray();
		MainClass.unitArray = units;
		// System.out.print(units);

		for (int i = 0; i < units.size(); ++i) {
			JsonObject o = (JsonObject) units.get(i).getAsJsonObject();
			String id = o.get("id").getAsString();
			String type = o.get("type").getAsString();
			// System.out.println("id = " + id + " " + "type = " + type);
		}

		int points = ((JsonObject) newGameState.get("playerState").getAsJsonObject()).get("points").getAsInt();
		if (points > MAX_SCORE)
			MAX_SCORE = points;
	}

}
