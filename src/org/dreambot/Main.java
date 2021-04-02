package org.dreambot;

import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.behaviour.ExampleBranch;
import org.dreambot.behaviour.exampleLeafs.ExampleLeaf;
import org.dreambot.behaviour.exampleLeafs.ExampleLeafTwo;
import org.dreambot.framework.Branch;
import org.dreambot.framework.Tree;
import org.dreambot.paint.CustomPaint;
import org.dreambot.paint.PaintInfo;

import java.awt.*;

@ScriptManifest(category = Category.MISC, author = "Very Cool Author", name = "TreeBranchExample", description = "Very cool example", version = 1)
public class Main extends AbstractScript implements PaintInfo {

    /**
     * @param args script quick launch arguments
     */

    @Override
    public void onStart(String... args) {
        instantiateTree();
    }

    /**
     * On start from script launcher
     */
    @Override
    public void onStart() {
        instantiateTree();
    }


    private final Tree<Main> tree = new Tree<>();
    private Branch<Main> exampleBranch;

    private void instantiateTree() {
        exampleBranch = new ExampleBranch();

        tree.addBranches(
                exampleBranch.addLeafs(new ExampleLeaf(), new ExampleLeafTwo())
        );
    }


    /**
     * onLoop is a infinite loop
     * @return gets the leaf and executes it
     */
    @Override
    public int onLoop() {

        return this.tree.onLoop(this);
    }

    /**
     * @return the information for the paint
     */
    @Override
    public String[] getPaintInfo() {
        return new String[] {
                getManifest().name() + " V" + getManifest().version()
        };
    }

    /**
     * Instantiate the paint object, can be customized to liking.
     */
    private final CustomPaint CUSTOM_PAINT = new CustomPaint(this,
            CustomPaint.PaintLocations.TOP_LEFT_PLAY_SCREEN, new Color[]{new Color(255, 251, 255)},
            "Trebuchet MS",
            new Color[]{new Color(50, 50, 50, 175)},
            new Color[]{new Color(28, 28, 29)},
            1, false, 5, 3, 0);

    private final RenderingHints aa = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


    /**
     * paint for the script
     */
    @Override
    public void onPaint(Graphics g) {
        Graphics2D gg = (Graphics2D) g;
        gg.setRenderingHints(aa);

        CUSTOM_PAINT.paint(gg);
    }

}
