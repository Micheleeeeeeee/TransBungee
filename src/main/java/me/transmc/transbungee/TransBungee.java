package me.transmc.transbungee;

import me.TransMC.TransMC.api.enumaccess.ServerStatus;
import me.transmc.transbungee.api.BungeeApi;
import me.transmc.transbungee.api.C;
import me.transmc.transbungee.events.PluginMessageHandler;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public final class TransBungee extends Plugin {

    private static TransBungee instance;
    private static BungeeApi api;
    private static HashMap<ServerStatus, String> servers = new HashMap<>();

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


        getProxy().getScheduler().schedule(
                this
                , new Runnable() {
                    @Override
                    public void run() {
                        api.getConverstations().clear();
                        System.out.println(C.yellow + "Private messages HashMap has been cleared!");
                    }
                }
                , 6
                , 0
                , TimeUnit.MINUTES
        );

        System.out.println(C.yellow + "STARTUP SERVER PINGING");
        System.out.println(C.yellow + "STARTUP SERVER PINGING");
        System.out.println(C.yellow + "STARTUP SERVER PINGING");

        checkServer("lobby", 25566, "localhost");
        checkServer("cock_testing", 25567, "localhost");
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

    private void checkServer(final String serverName, final int port, final String address) {
        try {

            final Socket server = new Socket(address, port);
            server.close();

            servers.put(ServerStatus.ONLINE, serverName);
        } catch (IOException e) {
            servers.put(ServerStatus.OFFLINE, serverName);
        }

        /**
         * TODO: Whitelisted server checkers (custom messaging shit)
         */
    }
}
