package projetotematico;

import javazoom.jl.player.Player;

/**
	 * Manipula threads para executar as músicas
	 */
	public class PlayerThread extends Thread {
		
		private Player player;
		
		public PlayerThread(Player player) {
			this.player = player;
		}
		
		/**
		 * Cria uma thread para tocar uma música
		 */
		public void run() {
			try {
				player.play();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * Encerra a thread que toca música
		 */
		public void end() {
			try {
				player.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}