package studio.genbu.suzakuchat.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import studio.genbu.suzakuchat.SuzakuChat;
import studio.genbu.suzakuchat.Tasks.SendChatMessage;

public class PlayerEvents implements Listener {
  
  SuzakuChat main = SuzakuChat.getInstance();
  double range = 8.0;

  /**
   * (非同期)プレイヤーがチャットメッセージを送信した際のイベント
   * @param event
   */
  @EventHandler(ignoreCancelled = true)
  public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event) {
    new SendChatMessage(event, range, range, range).runTask(main);

    event.setCancelled(true);
  }

}
