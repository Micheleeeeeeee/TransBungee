package me.transmc.transbungee;

import net.md_5.bungee.api.plugin.Plugin;

import java.util.logging.Level;

public final class TransBungee extends Plugin {

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
        // Plugin startup logic

        getLogger().log(Level.INFO, "Starting up...");

        /**
         * Do shit here uwu
         */

        getLogger().log(Level.INFO, "Plugin successfully loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
