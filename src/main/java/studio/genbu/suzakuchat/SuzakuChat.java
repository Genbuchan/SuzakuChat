package studio.genbu.suzakuchat;

import org.bukkit.plugin.java.JavaPlugin;

import studio.genbu.suzakuchat.Events.PlayerEvents;

public class SuzakuChat extends JavaPlugin {
  
  private static SuzakuChat suzakuChat;

  /**
   * プラグインを有効化した際に呼び出すメソッド。
   */
  @Override
  public void onEnable() {
    suzakuChat = this;

    getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
    getLogger().info("SuzakuChat を有効化しました。");
  }

  /**
   * プラグインを無効化した際に呼び出すメソッド。
   */
  @Override
  public void onDisable() {
    getLogger().info("SuzakuChat を無効化しました。");
  }

  /**
   * SuzakuChat クラスのインスタンスを返すメソッド。
   * @return SuzakuChat クラスのインスタンス
   */
  public static SuzakuChat getInstance() {
    return suzakuChat;
  }

}
