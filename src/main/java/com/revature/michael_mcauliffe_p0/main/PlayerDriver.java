package com.revature.michael_mcauliffe_p0.main;

import java.util.Scanner;

import com.revature.michael_mcauliffe_p0.pojos.Player;
import com.revature.michael_mcauliffe_p0.pojos.PlaylistCache;
import com.revature.michael_mcauliffe_p0.pojos.Track;
import com.revature.michael_mcauliffe_p0.pojos.TrackCache;

public class PlayerDriver {

	private static Player player = new Player();
	private static PlaylistCache playlistCache = new PlaylistCache();
	private static TrackCache trackCache = new TrackCache();
	private static Scanner scan = new Scanner(System.in);
	private static Track selectedTrack = new Track();
	private static int position = -1;
	
	public static void main(String[] args) {

		mainMenu();
	}
	
	public static void mainMenu() {
		
		String userInput;
		boolean keepAlive = true;
		do {
			System.out.println("::MAIN MENU::\nPlease select from the following:\n"
					+ "[1] Player Controls\n"
					+ "[2] Song Menu\n"
					+ "[3] Playlist Menu\n"
					+ "[4] Exit");
	
			userInput = scan.nextLine();
	
			switch (userInput) {
	
				case "1":
					// TODO: Add menu call
					break;
				case "2":
					songMenu();
					break;
				case "3":
					// TODO: Add menu call
					break;
				case "4":
					keepAlive = false;
					break;
				default:
					System.out.println("Invalid selection\n");
					break;
			}
		} while(keepAlive);
	}

	public static void songMenu() {
		
		String userInput;
		boolean keepAlive = true;
		
		do {
			System.out.println("::SONG MENU::\nPlease select from the following:\n"
					+ "[1] Add Song\n"
					+ "[2] Remove Previous Song\n"
					+ "[3] Exit");
			
			userInput = scan.nextLine();
			
			switch (userInput) {
			
			case "1":
				addSong();
				break;
			case "2":
				removeSong();
				break;
			case "3":
				keepAlive = false;
				break;
			default:
				System.out.println("Invalid selection\n");
				break;
			}
			
		} while(keepAlive);
	}

	public static void addSong() {
		
		String userInput;
		
		short trackNumber = 0;
		String trackTitle, albumTitle, artistName;
		
		do {
			System.out.println("Enter the track number:");
			userInput = scan.nextLine();
			
			try{
				trackNumber = Short.parseShort(userInput);
			} catch (NumberFormatException nfe) {
				System.out.println("Error! Not a number!\n");
				return;
			}
			if(trackNumber <= 0) {
				System.out.println("Number must be greater than 0.\n");
			}
		} while (trackNumber <= 0);

		System.out.println("Enter the song name:");
		userInput = scan.nextLine();
		trackTitle = userInput;
		
		System.out.println("Enter the album title:");
		userInput = scan.nextLine();
		albumTitle = userInput;
		
		System.out.println("Enter the artist:");
		userInput = scan.nextLine();
		artistName = userInput;
		
		selectedTrack = new Track(trackNumber, trackTitle, albumTitle, artistName);
		
		trackCache.addToCache(selectedTrack);
		
		System.out.println("Song added!\n");
	}
	
	public static void removeSong() {
		
		if(trackCache.contains(selectedTrack)) {
			trackCache.removeFromCache(selectedTrack);
			System.out.println("Song removed successfully");
		}
		else {
			System.out.println("No song to remove.");
		}
	}
}
