package com.revature.michael_mcauliffe_p0.main;

import java.util.List;
import java.util.Scanner;

import com.revature.michael_mcauliffe_p0.pojos.Player;
import com.revature.michael_mcauliffe_p0.pojos.Track;
import com.revature.michael_mcauliffe_p0.service.PlaylistCache;
import com.revature.michael_mcauliffe_p0.service.TrackCache;

public class PlayerDriver {

	private static Player player = new Player();
	private static PlaylistCache playlistCache = new PlaylistCache();
	private static TrackCache<Track> trackCache = new TrackCache<Track>();
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
					+ "[0] Exit");
	
			userInput = scan.nextLine();
	
			switch (userInput) {
	
				case "1":
					playerMenu();
					break;
				case "2":
					songMenu();
					break;
				case "3":
					// TODO: Add menu call
					System.out.println("Coming soon.");
					break;
				case "0":
					keepAlive = false;
					break;
				default:
					System.out.println("Invalid selection\n");
					break;
			}
		} while(keepAlive);
	}

	public static void playerMenu() {
		
		String userInput;
		boolean keepAlive = true;
		
		do {
			
			System.out.println("::PLAYER MENU::\nPlease select from the following:\n"
					+ "[1] Play\n"
					+ "[2] Pause\n"
					+ "[3] Stop\n"
					+ "[0] Back");
			
			userInput = scan.nextLine();
			
			switch (userInput) {
			
			case "1":
				play();
				break;
			case "2":
				pause();
				break;
			case "3":
				stop();
				break;
			case "0":
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
					+ "[0] Back");
			
			userInput = scan.nextLine();
			
			switch (userInput) {
			
			case "1":
				addSong();
				break;
			case "2":
				removeSong();
				break;
			case "0":
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
		
		List<Track> tempTrackList = trackCache.retrieveAllItems();
		
		String userInput;
		
		if(tempTrackList.isEmpty()) {
			System.out.println("No songs to remove.\n");
		}
		else {
			
			System.out.println("Select the song to remove:\n");
			printSongList(tempTrackList);
			
			int selection = -1;
			
			do {
				userInput = scan.nextLine();
				
				try {
					selection = Integer.parseInt(userInput);
				} catch(NumberFormatException nfe) {
					System.out.println("Error! Not a number!\n");
					return;
				}
				
				if(selection > 0 && selection <= tempTrackList.size()) {
					
					trackCache.removeFromCache(tempTrackList.get(selection - 1));
					
					System.out.println("Song successfully removed.\n");
				}
			} while(selection < 0);
		}
	}

	
	public static void play() {
		
		List<Track> tempTrackList = trackCache.retrieveAllItems();
		
		String userInput;		
		
		if(trackCache.retrieveAllItems().isEmpty()) {
			System.out.println("No songs available. Please add songs first.\n");
			return;
		}
		else {
			
			int selection = -1;
			
			do {
				System.out.println("Select the song to play:\n");
				printSongList(tempTrackList);
				userInput = scan.nextLine();
				
				try {
					selection = Integer.parseInt(userInput);
				} catch(NumberFormatException nfe) {
					System.out.println("Error! Not a number!\n");
					return;
				}
				
				if(selection > 0 && selection <= tempTrackList.size()) {
					
					player.load(tempTrackList.get(selection - 1));
					player.play();
					player.getCurrentTrack().increasePlayCount();
					System.out.println("Song '" + player.getCurrentTrack().getTrackTitle()
										+ "' is now playing.\nThis song has been played "
										+ player.getCurrentTrack().getPlayCount() + " times.\n");
				}
			} while(selection < 0);
		}
	}

	
	public static void pause() {
		
		if(player.isPlaying()) {
			System.out.println("Song '" + player.getCurrentTrack().getTrackTitle()
								+ "' has been paused.\n");
		}
		else if(player.getCurrentTrack() == null) {
			System.out.println("No song is playing.\n");
		}
		else {
			System.out.println("Song '" + player.getCurrentTrack().getTrackTitle()
								+ "' is already paused.\n");
		}
	}

	
	public static void stop() {
		
		if(player.isPlaying()) {
			
			player.pause();
			System.out.println("Song '" + player.getCurrentTrack().getTrackTitle()
								+ "' has been stopped and unloaded.\n");
			player.unload();
		}
		else if(player.getCurrentTrack() == null) {
			
			System.out.println("No song is loaded in.\n");
		}
		else {
			System.out.println("Song '" + player.getCurrentTrack().getTrackTitle()
								+ "' has been unloaded.");
		}
	}

	public static void printSongList(List<Track> trackList) {
		
		List<Track> tempTrackList = trackList;
		
		int i = 1;
		for(Track tempTrack : tempTrackList) {
			
			String output =	tempTrack.getTrackTitle() + " | " +
					tempTrack.getAlbumTitle() + " | " +
					tempTrack.getArtistName();
			
			System.out.println("[" + i + "] " + output);
			i++;
		}
		System.out.println("[0] Back");
	}
}
