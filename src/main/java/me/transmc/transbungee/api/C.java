package me.transmc.transbungee.api;

import net.md_5.bungee.api.ChatColor;

public class C { // This class is for color formatting.

  /**
   *
   * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
   * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
   * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
   * AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
   * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
   * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
   *
   * @return :)
   */

  public static final char COLOR_CHAR = '§';
  public static final String bold = "§l";
  public static final String strike = "§m";
  public static final String underline = "§n";
  public static final String magic = "§k";
  public static final String italic = "§o";
  public static final String reset = "§r";
  public static final String black = "§0";
  public static final String darkBlue = "§1";
  public static final String darkGreen = "§2";
  public static final String darkAqua = "§3";
  public static final String darkRed = "§4";
  public static final String darkPurple = "§5";
  public static final String gold = "§6";
  public static final String gray = "§7";
  public static final String darkGray = "§8";
  public static final String blue = "§9";
  public static final String green = "§a";
  public static final String aqua = "§b";
  public static final String red = "§c";
  public static final String lightPurple = "§d";
  public static final String yellow = "§e";
  public static final String white = "§f";
  public static final String arrow = "⟶";

  public static String replaceColors(final String colorless) {
    return ChatColor.translateAlternateColorCodes('&', colorless);
  }

  public static String staff(final String msg) {
    return yellow + "Staff Tools " + reset + arrow + " " + msg;
  }

  public static String prefix(final String msg) {
    return red + "TransMC " + yellow + arrow + " " + replaceColors(msg);
  }
}
