package me.transmc.transbungee;

import me.TransMC.TransMC.TransMC;
import me.transmc.transbungee.api.BungeeApi;
import me.transmc.transbungee.events.PluginMessageHandler;
import me.transmc.transbungee.modules.find.FindCommand;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.logging.Level;

public final class TransBungee extends Plugin {

    private static TransBungee instance;
    private static BungeeApi api;

    /**
     *
     * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
     * TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
     * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
     * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
     *
     * @return :)
     */

    @Override
    public void onEnable() {

        instance = this;
        api = new BungeeApi();
        // Plugin startup logic

        getLogger().log(Level.INFO, "Starting up...");

        /**
         * Do shit here uwu
         */

        getProxy().registerChannel("trans:bungee"); // Register plugin message channel
        getProxy().registerChannel("trans:return");

        getProxy().getPluginManager().registerListener(this, new PluginMessageHandler());

        getLogger().log(Level.INFO, "Plugin successfully loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }

    public static TransBungee getInstance() {
        return instance;
    }

    public static BungeeApi getApi() {
        return api;
    }
}
