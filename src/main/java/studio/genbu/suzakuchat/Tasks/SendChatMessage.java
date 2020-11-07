package studio.genbu.suzakuchat.Tasks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

import studio.genbu.suzakuchat.SuzakuChat;
import studio.genbu.suzakuchat.Utils.ChatFormats;
import studio.genbu.suzakucore.utils.PlayerUtils;

public class SendChatMessage extends BukkitRunnable {
  
  SuzakuChat main = SuzakuChat.getInstance();
  AsyncPlayerChatEvent event;
  double x, y, z;

  /**
   * SendChatMessage のコンストラクタ。
   * @param event AsyncPlayerChatEvent
   * @param x X座標の半径
   * @param y Y座標の半径
   * @param z Z座標の半径
   */
  public SendChatMessage(AsyncPlayerChatEvent event, double x, double y, double z) {
    this.event = event;
  }

  /**
   * タスクを実行した際に実行されるメソッド。
   */
  @Override
  public void run() {
    
    // 発言したプレイヤーを取得
    Player player = event.getPlayer();
    
    // 近隣のプレイヤーと、さらにその近隣のプレイヤーを取得
    List<Player> players = PlayerUtils.getPlayersFromPropagationRanges(
      player,
      x,
      y,
      z
    );
    
    // 発言したプレイヤーと、先ほど取得したプレイヤーを重複のないように結合
    players = Stream.concat(players.stream(), Arrays.asList(player).stream())
      .distinct()
      .collect(Collectors.toList());

    // メッセージをプレイヤーに送信
    for(Player nearbyPlayer: players) {
      // <Player> Message
      nearbyPlayer.sendMessage(
        ChatFormats.getFormattedMessage(nearbyPlayer, event.getMessage())
      );
    }

    // ロギング
    main.getLogger().info(ChatFormats.getFormattedLogMessage(
      player,
      players,
      event.getMessage()
    ));
    
  }

}
