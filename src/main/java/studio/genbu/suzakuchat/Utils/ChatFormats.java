package studio.genbu.suzakuchat.Utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class ChatFormats {
  
  private ChatFormats() {

  }

  /**
   * チャット形式の文字列を返すメソッド。
   * @param player プレイヤー
   * @param message メッセージ
   * @return 文字列
   */
  public static String getFormattedMessage(Player player, String message) {
    // チャット形式で文字列を返す
    return String.format("<%s> %s", player.getDisplayName(), message);
  }

  /**
   * ログメッセージを返すメソッド
   * @param player プレイヤー
   * @param players プレイヤーのリスト
   * @param message メッセージ
   * @return 文字列
   */
  public static String getFormattedLogMessage(Player player, List<Player> players, String message) {

    // プレイヤー名を格納する List を初期化
    List<String> playersDisplayName = new ArrayList<String>();

    // プレイヤーの表示名を格納
    players.forEach(groupMembers -> {
      playersDisplayName.add(groupMembers.getDisplayName());
    });

    // チャット形式にフォーマットしつつ、発言が届いたプレイヤー名を付加した文字列を返す
    return String.format(
      "%s : [ %s ]",
      getFormattedMessage(player, message),
      String.join(", ", playersDisplayName)
    );

  }

}
